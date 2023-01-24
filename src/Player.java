import supernatural.strikeable.monster.Werewolf;
import supernatural.strikeable.monster.Monster;
import supernatural.strikeable.monster.Mummy;
import supernatural.strikeable.monster.Vampire;

public class Player {
    private final String nickname;
    public Monster[] team;
    private int numbOfDeadMonsters;

    public Player(String nickname) {
        this.nickname = nickname;
        this.numbOfDeadMonsters = 0;
    }

    public void setNumOfMonsters(int numOfMonsters) {
        this.team = new Monster[numOfMonsters];
    }

    public void pickTeam() {
        int numWerewolf = 0;
        int numVampire = 0;
        int numMummy = 0;
        for (int i = 0; i < team.length; i++) {
            int monsterPick = RandomNumber.randomGeneratedNumber(3, 1);
            switch (monsterPick) {
                case 1:
                    team[i] = new Werewolf();
                    numWerewolf++;
                    break;
                case 2:
                    team[i] = new Vampire();
                    numVampire++;
                    break;
                case 3:
                    team[i] = new Mummy();
                    numMummy++;
                    break;
            }
        }
        System.out.println(this.nickname + " has:\n" +
                "- " + numWerewolf + " Werewolf(s) \n" +
                "- " + numVampire + " Vampire(s)\n" +
                "- " + numMummy + " Mummy(ies)");
        System.out.println("=".repeat(50));
    }

    public int attack() {
        int attacker = pickRandomMonster();
        while (!team[attacker].isAlive()) {
            attacker = pickRandomMonster();
        }
        System.out.println(this.nickname + "´s picked " + team[attacker].getMonsterName() + " as an attacker.");
        return team[attacker].attackDamage();
    }


    public void pickDefender(int damage) {
        int defender = pickRandomMonster();
        while (!team[defender].isAlive()) {
            defender = pickRandomMonster();
        }
        team[defender].takeDamage(damage);
        if (team[defender].getHitpoints() <= 0) {
            team[defender].setHitpoints(0);
            this.numbOfDeadMonsters++;
            team[defender].kill();
        }
        System.out.println(this.nickname + " picked " + team[defender].getMonsterName() + " as a defender.\n" +
                team[defender].getMonsterName() + " now has " + team[defender].getHitpoints() + " hitpoints.");
        System.out.println(".".repeat(150));
    }

    public int getNumbOfDeadMonsters() {
        return numbOfDeadMonsters;
    }

    public String getNickname() {
        return nickname;
    }

    public int pickRandomMonster() {
        return (int) RandomNumber.randomGeneratedNumber(team.length - 1, 0);
    }
}