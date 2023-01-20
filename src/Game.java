
public class Game {
    private Player p1;
    private Player p2;
    private int numOfMonster;

    public static void initializeGame(Game game, Player p1, Player p2) {
        p1.setGame(game);
        p2.setGame(game);
    }

    public static void leaveGame(Player p1, Player p2) {
        p1.setGame(null);
        p2.setGame(null);
    }


    public Game(Player p1, Player p2, int numOfMonster) {
        this.p1 = p1;
        this.p2 = p2;
        Player nuno = new Player("Bushnell",  4)
        //this.numOfMonster = RandomNumber.randomGeneratedNumber(6,2); //Random number 2-5
        this.numOfMonster = numOfMonster;
        System.out.println("Each player gets to choose " + this.numOfMonster + " Monsters.");
        System.out.println("_".repeat(100));
    }

    public void play(Player p1, Player p2) {
        while (!end(p1, p2)) {
            p1.defend(p2.attak())
            p1.pickAttacker(p2.pickDefender());
            p2.pickAttacker(p1.pickDefender());
        }
        numOfMonster = 0;
    }

    public boolean end(Player p1, Player p2) {
        for (int i = 0; i < numOfMonster; i++) {
            if (!p1.getTeam()[i].isAlive()) {
                p1.setNumDeadMonster(getNumOfMonster() + 1);
                System.out.println(p2.getNickname() + " has won the game.");
                return true;
            }
            if (!p2.getTeam()[i].isAlive()) {
                p2.setNumDeadMonster(getNumOfMonster() + 1);
                System.out.println(p1.getNickname() + " has won the game.");
                return true;
            }
        }
        return false;
    }


    public int getNumOfMonster() {
        return numOfMonster;
    }
}
