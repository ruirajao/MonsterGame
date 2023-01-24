import supernatural.Fairy;
import supernatural.strikeable.Witch;

public class Game {
    private final Player p1;
    private final Player p2;
    private final int numOfMonster;

    public Game(Player p1, Player p2) {
        this.numOfMonster = RandomNumber.randomGeneratedNumber(5, 2);
        this.p1 = p1;
        this.p1.setNumOfMonsters(numOfMonster);
        this.p2 = p2;
        this.p2.setNumOfMonsters(numOfMonster);
        System.out.println("Each player gets to choose " + this.numOfMonster + " Monsters.");
        System.out.println("_".repeat(100));
    }

    public void play() {
        this.p1.pickTeam();
        this.p2.pickTeam();
        fight();
        printScoreBoard();
    }

    private void fight() {
        int turnOrder = RandomNumber.randomGeneratedNumber(2, 1);
        while (!hasEndConditions()) {
            obstacleChance(RandomNumber.randomGeneratedNumber(10, 1));
            if (hasEndConditions()) break;
            if (turnOrder % 2 == 0) {
                this.p1.pickDefender(p2.attack());
                turnOrder++;
                if (hasEndConditions()) break;
            } else {
                this.p2.pickDefender(p1.attack());
                turnOrder++;
                if (hasEndConditions()) break;
            }
        }
    }

    public void obstacleChance(int obstacle) {
        switch (obstacle) {
            case 1:
                Fairy fairy = new Fairy();
                System.out.println("A fairy has appeared.");
                fairyAttack(fairy);
                break;
            case 2:
                Witch witch = new Witch();
                System.out.println("A witch has appeared");
                witchAttack(witch);
                break;
            default:
                break;
        }
    }

    private void fairyAttack(Fairy fairy) {
        this.p1.pickDefender(fairy.attackDamage());
        if (hasEndConditions()) return;
        this.p2.pickDefender(fairy.attackDamage());
        if (hasEndConditions()) return;
    }

    private void witchAttack(Witch witch) {
        while (witch.isAlive()) {
            this.p1.pickDefender(witch.attackDamage());
            if (hasEndConditions()) {
                return;
            }
            witch.takeDamage(p1.attack() / 2);
            if (!witch.isAlive()) {
                return;
            }
            this.p2.pickDefender(witch.attackDamage());
            if (hasEndConditions()) {
                return;
            }
            witch.takeDamage(p2.attack() / 2);
            if (!witch.isAlive()) {
                return;
            }
        }
    }

    private boolean hasEndConditions() {
        return p1.getNumbOfDeadMonsters() == numOfMonster || p2.getNumbOfDeadMonsters() == numOfMonster;
    }

    private void printScoreBoard() {
        if (p1.getNumbOfDeadMonsters() == numOfMonster) {
            System.out.println(p2.getNickname() + " has won the game. \nWINNING TEAM");
            for (int i = 0; i < numOfMonster; i++) {
                System.out.println(p2.team[i].getMonsterName() + " with " + p2.team[i].getHitpoints() + " hitpoints.");
            }
            System.out.println("LOSING TEAM:");
            for (int i = 0; i < numOfMonster; i++) {
                System.out.println(p1.team[i].getMonsterName() + " with " + p1.team[i].getHitpoints() + " hitpoints.");
            }
        } else {
            System.out.println(p1.getNickname() + " has won the game. \nWINNING TEAM");
            for (int i = 0; i < numOfMonster; i++) {
                System.out.println(p1.team[i].getMonsterName() + " with " + p1.team[i].getHitpoints() + " hitpoints.");
            }
            System.out.println("LOSING TEAM:");
            for (int i = 0; i < numOfMonster; i++) {
                System.out.println(p2.team[i].getMonsterName() + " with " + p2.team[i].getHitpoints() + " hitpoints.");
            }
        }
    }
}