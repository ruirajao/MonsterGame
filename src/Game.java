
public class Game {
    private Player p1;
    private Player p2;
    private int numOfMonster;

    public Game() {
        this.numOfMonster = RandomNumber.randomGeneratedNumber(3, 2); //Random number 2-5
        this.p1 = new Player("Bushnell", this.numOfMonster);
        this.p2 = new Player("Raja", this.numOfMonster);
        System.out.println("Each player gets to choose " + this.numOfMonster + " Monsters.");
        System.out.println("_".repeat(100));
    }

    public void play() {
        this.p1.pickTeam();
        this.p2.pickTeam();
        while (!end()) {
            /*
            tempAtt = p1.pickAttacker();
            tempDef = p2.pickDefender();
            temp.attack(tempDef);
             */
            this.p1.pickAttacker(this.p2.pickDefender());
            this.p2.pickAttacker(this.p1.pickDefender());
        }
    }

    private boolean end() {
        if (this.numOfMonster == p1.getNumOfMonstersKilled()) {
            System.out.println(p1.getNickname() + " has won the game.");
            return true;
        }
        if (this.numOfMonster == p2.getNumOfMonstersKilled()) {
            System.out.println(p2.getNickname() + " has won the game.");
            return true;
        }
        return false;
    }
}