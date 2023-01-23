public class Game {
    private Player p1;
    private Player p2;
    private int numOfMonster;
    //private Supernatural[] obstacle = {new Fairy(), new Witch()};

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
            this.p1.pickDefender(p2.attack());
            if (end()) {
                return;
            }
            this.p2.pickDefender(p1.attack());
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