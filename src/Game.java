import supernatural.Fairy;
import supernatural.strikeable.Witch;

public class Game {
    private Player p1;
    private Player p2;
    private int numOfMonster;

    public Game(Player p1, Player p2) {
        this.numOfMonster = RandomNumber.randomGeneratedNumber(2, 2); //Random number 2-5
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
        int goesFirst = RandomNumber.randomGeneratedNumber(5, 2);
        for (int i = goesFirst; i < 1000; i++) {
            while (!end()) {
                obstacleChance();
                if (end()) {
                    return;
                }
                if (i % 2 == 0) {
                    this.p1.pickDefender(p2.attack());
                } else this.p2.pickDefender(p1.attack());
            }
        }
    }

    private void fairyAttack(Fairy fairy) {
        this.p1.pickDefender(fairy.attackDamage());
        if (end()) {
            return;
        }
        this.p2.pickDefender(fairy.attackDamage());
    }

    private void witchAttack(Witch witch) {
        while (witch.isAlive() == true) {
            this.p1.pickDefender(witch.attackDamage());
            if (end()) {
                return;
            }
            witch.setHitpoints(witch.getHitpoints() - (p1.attack() / 2));
            if (!witch.isAlive()) {
                return;
            }
            this.p2.pickDefender(witch.attackDamage());
            if (end()) {
                return;
            }
            witch.setHitpoints(witch.getHitpoints() - (p2.attack() / 2));
        }
    }

    public void obstacleChance() {
        int randomObstacleChance = RandomNumber.randomGeneratedNumber(10, 1);
        switch (randomObstacleChance) {
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

    private boolean end() {
        if (p1.getNumbOfDeadMonsters() == numOfMonster) {
            System.out.println(p2.getNickname() + " has won the game.");
            return true;
        }
        if (p2.getNumbOfDeadMonsters() == numOfMonster) {
            System.out.println(p1.getNickname() + " has won the game.");
            return true;
        }
        return false;
    }
}