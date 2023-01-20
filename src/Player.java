public class Player {
    private final String nickname;
    public Monster[] team;
    private Monster[] deadTeam;
    private int numOfMonsters;
    private  int numOfMonstersKilled;

    public int getNumOfMonstersKilled() {
        return numOfMonstersKilled;
    }

    public Player(String nickname, int numOfMonsters) {
        this.nickname = nickname;
        this.numOfMonsters = numOfMonsters;
        this.team = new Monster[numOfMonsters];
        this.deadTeam = new Monster[numOfMonsters];
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
        int temp1 = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);

/*
        for (int i = 0; i < numOfMonster; i++) {
            temp1 = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);
            if (!team[temp1].isAlive()) {
                return;
            }
        }*/
        while (!team[temp1].isAlive()) {
            temp1 = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);
        }

        System.out.println(this.nickname + "´s picked " + team[temp1].getMonsterName() + " as an attacker.");
        team[temp1].attack(defender);
        if (team[temp1].isAlive() == false) {
            deadTeam[temp1] = team[temp1];
        }
    }

    public Monster pickDefender() {
        int temp2 = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);
        while (!team[temp2].isAlive()) {
            temp2 = RandomNumber.randomGeneratedNumber(numOfMonsters, 0);
        }
        System.out.println("You picked " + team[temp2].getMonsterName() + " as a defender.");

        return team[temp2];
    }

    /*
    public void defend(int hitPoints){
        if (hitPoints <= 0){
            return;
        }
        pickDefender().suffer(hitPoints);

    }
    public  int attack(){
        return  pickAttacker().getHitpoints();
    }
    */

    public Monster getDeadTeamLast(int index) {
        return deadTeam[index];
    }

    public int getDeadTeam() {
        return deadTeam.length -1;
    }

    public String getNickname() {
        return nickname;
    }
}
