import supernatural.Fairy;
import supernatural.strikeable.Witch;

public class Game {
    private Player p1;
    private Player p2;
    private int numOfMonster;
    //private Supernatural[] obstacle = {new Fairy(), new Witch()};

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
        boolean checkEndGame = false;
        while (!checkEndGame) {
            checkEndGame = obstacleChance();
            if (checkEndGame) {
                return;
            }
            this.p1.pickDefender(p2.attack());
            if (p1.getNumbOfDeadMonsters() == numOfMonster) {
                System.out.println(p2.getNickname() + " WON!");
                return;
            }
            this.p2.pickDefender(p1.attack());
            if (p2.getNumbOfDeadMonsters() == numOfMonster) {
                System.out.println(p1.getNickname() + " WON!");
                return;
            }
        }
    }

    private boolean fairyAttack(Fairy fairy) {
        this.p1.pickDefender(fairy.attackDamage());
        if (end()) {
            return true;
        }
        this.p2.pickDefender(fairy.attackDamage());
        if (end()) {
            return true;
        }
        return false;
    }

    private boolean witchAttack(Witch witch) {
        while (witch.isAlive() == true) {
            this.p1.pickDefender(witch.attackDamage());
            witch.setHitpoints(witch.getHitpoints() - (p1.attack()/2));
            if (witch.getHitpoints() <= 0) {
                witch.setAlive(false);
            }
            if(end()) {
                return true;
            }
            this.p2.pickDefender(witch.attackDamage());
            if(end()) {
                return true;
            }
            witch.setHitpoints(witch.getHitpoints() - (p2.attack()/2));
            if (witch.getHitpoints() <= 0) {
                witch.setAlive(false);
            }
        }
        return false;
    }

    public boolean obstacleChance() {
        int randomObstacleChance = RandomNumber.randomGeneratedNumber(2, 2);
        switch (randomObstacleChance) {
            case 1:
                Fairy fairy = new Fairy();
                System.out.println("A fairy has appeared.");
                return fairyAttack(fairy);
            case 2:
                Witch witch = new Witch();
                System.out.println("A witch has appeared");
                return witchAttack(witch);
            default:
                break;
        }
        return false;
    }

    private boolean end() {
        if (p1.getNumbOfDeadMonsters() == numOfMonster) {
            //System.out.println(p2.getNickname() + " has won the game.");
            return true;
        }
        if (p2.getNumbOfDeadMonsters() == numOfMonster) {
            //System.out.println(p1.getNickname() + " has won the game.");
            return true;
        }
        return false;
    }
}