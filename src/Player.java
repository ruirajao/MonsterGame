public class Player {
    private final String nickname;
    private Monster[] team = new Monster[5];
    private int numDeadMonster;
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public void pickTeam(Game game, int numWerewolf, int numVampire, int numMummy) {
        if (numWerewolf + numVampire + numMummy != game.getNumOfMonster()) {
            System.out.println("You have to choose " + game.getNumOfMonster() + " monsters.");
            return;
        }
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
        int temp1 = RandomNumber.randomGeneratedNumber(game.getNumOfMonster(), 0);
        while (!team[temp1].isAlive()) {
            //System.out.println("Your pick as attack " + team[temp1].getClass() + " is already dead.");
            temp1 = RandomNumber.randomGeneratedNumber(game.getNumOfMonster(), 0);
        }
        System.out.println(this.nickname + "´s picked " + team[temp1].getMonsterName() + " as an attacker.");
        team[temp1].attack(defender);
    }

    public Monster pickDefender() {
        int temp2 = RandomNumber.randomGeneratedNumber(game.getNumOfMonster(), 0);
        while (!team[temp2].isAlive()) {
            System.out.println("Your pick as defender " + team[temp2].getMonsterName() + " is already dead.");
            temp2 = RandomNumber.randomGeneratedNumber(game.getNumOfMonster(), 0);
        }
        System.out.println("You picked " + team[temp2].getMonsterName() + " as a defender.");
        return team[temp2];
    }


    public Monster[] getTeam() {
        return team;
    }

    public void setNumDeadMonster(int numDeadMonster) {
        this.numDeadMonster = numDeadMonster;
    }

    public String getNickname() {
        return nickname;
    }
}
