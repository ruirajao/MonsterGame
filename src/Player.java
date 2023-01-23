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
        int numWerewolf = RandomNumber.randomGeneratedNumber(team.length, 0);
        int numVampire = RandomNumber.randomGeneratedNumber(team.length-numWerewolf, 0);
        int numMummy = team.length-numWerewolf-numVampire;

        int index = 0;
        for (int i = 0; i < numWerewolf; i++) {
            team[index] = new Werewolf();
            index++;
        }
        for (int j = 0; j < numVampire; j++) {
            team[index] = new Vampire();
            index++;
        }
        for (int k = 0; k < numMummy; k++) {
            team[index] = new Mummy();
            index++;
        }
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
        team[indexDefender].setHitpoints(team[indexDefender].getHitpoints()-damage);
        System.out.println(this.nickname + " picked " + team[indexDefender].getMonsterName() + " as a defender.\n" +
                team[indexDefender].getMonsterName() + " now has " + team[indexDefender].getHitpoints() + " hitpoints.");
        if (team[indexDefender].getHitpoints() <= 0){
            this.numbOfDeadMonsters++;
            team[indexDefender].kill();
        }
        System.out.println(".".repeat(150));
    }
    public String getNickname() {
        return nickname;
    }


}
