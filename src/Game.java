import supernatural.Fairy;
import supernatural.Supernatural;
import supernatural.strikeable.Witch;

public class Game {
    private Player p1;
    private Player p2;
    private int numOfMonster;
    //private Supernatural[] obstacle = {new Fairy(), new Witch()};

    public Game() {
        this.numOfMonster = RandomNumber.randomGeneratedNumber(5, 2); //Random number 2-5
        this.p1 = new Player("Player 1", this.numOfMonster);
        this.p2 = new Player("Player 2", this.numOfMonster);
        //this.obstacle = obstacle;
        System.out.println("Each player gets to choose " + this.numOfMonster + " Monsters.");
        System.out.println("_".repeat(100));
    }

    public Game(Player p1, Player p2) {
        this.numOfMonster = RandomNumber.randomGeneratedNumber(5, 2); //Random number 2-5
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
        while (!end()) {
            this.p1.pickAttacker(this.p2.pickDefender());
            if (end()) {
                return;
            }
            this.p2.pickAttacker(this.p1.pickDefender());

        }
    }

    private boolean end() {
        boolean p1Dead = true;
        boolean p2Dead = true;
        for (int i = 0; i < numOfMonster-1; i++) {
            if ((p1.team[i].getHitpoints() > 0)) {
                p1Dead = false;
            }
        }

        for (int i = 0; i < numOfMonster-1; i++) {
            if (p2.team[i].getHitpoints() > 0) {
                p2Dead = false;
            }
        }
        if (p1Dead) {
            System.out.println(p2.getNickname() + " has won the game.");
        } else if (p2Dead) {
            System.out.println(p1.getNickname() + " has won the game.");
        }
        return (p1Dead || p2Dead);
    }
}