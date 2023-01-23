import supernatural.strikeable.monster.Werewolf;
import supernatural.strikeable.monster.Monster;
import supernatural.strikeable.monster.Mummy;
import supernatural.strikeable.monster.Vampire;

public class Player {
    private final String nickname;
    public Monster[] team;
    private int numOfMonsters;

    public Player(String nickname, int numOfMonsters) {
        this.nickname = nickname;
        this.numOfMonsters = numOfMonsters;
        this.team = new Monster[numOfMonsters];
    }

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public void setNumOfMonsters(int numOfMonsters) {
        this.numOfMonsters = numOfMonsters;
        this.team = new Monster[numOfMonsters];

    }

    public void pickTeam() {
        int numWerewolf = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);
        int numVampire = RandomNumber.randomGeneratedNumber(numOfMonsters-numWerewolf, 0);
        int numMummy = numOfMonsters-numWerewolf-numVampire;

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

    public void pickAttacker(Monster defender) {
        int indexAttacker = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);

        while (!team[indexAttacker].isAlive()) {
            indexAttacker = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);
        }

        System.out.println(this.nickname + "´s picked " + team[indexAttacker].getMonsterName() + " as an attacker.");
        team[indexAttacker].attack(defender);

    }

    public Monster pickDefender() {
        int indexDefender = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);
        while (!team[indexDefender].isAlive()) {
            indexDefender = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);
        }
        System.out.println("You picked " + team[indexDefender].getMonsterName() + " as a defender.");

        return team[indexDefender];
    }
    public String getNickname() {
        return nickname;
    }
}
