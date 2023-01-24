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
        int indexAttacker = RandomNumber.randomGeneratedNumber(team.length, 0);
        while (!team[indexAttacker].isAlive()) {
            indexAttacker = RandomNumber.randomGeneratedNumber(team.length, 0);
        }
        System.out.println(this.nickname + "´s picked " + team[indexAttacker].getMonsterName() + " as an attacker.");
        return team[indexAttacker].attackDamage();
    }

    public int getNumbOfDeadMonsters() {
        return numbOfDeadMonsters;
    }

    public void pickDefender(int damage) {
        int indexDefender = RandomNumber.randomGeneratedNumber(team.length, 0);
        while (!team[indexDefender].isAlive()) {
            indexDefender = RandomNumber.randomGeneratedNumber(team.length, 0);
        }
        team[indexDefender].setHitpoints(team[indexDefender].getHitpoints() - damage);
        System.out.println(this.nickname + " picked " + team[indexDefender].getMonsterName() + " as a defender.\n" +
                team[indexDefender].getMonsterName() + " now has " + team[indexDefender].getHitpoints() + " hitpoints.");
        if (team[indexDefender].getHitpoints() <= 0) {
            this.numbOfDeadMonsters++;
            team[indexDefender].kill();
        }
        System.out.println(".".repeat(150));
    }

    public String getNickname() {
        return nickname;
    }
}