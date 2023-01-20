
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
        int switchturns = 2;
        while (!end()) {
            this.p1.pickAttacker(this.p2.pickDefender());
            if (end())  {
                return;
            }
            this.p2.pickAttacker(this.p1.pickDefender());

            /*
            if (switchturns % 2 == 0) {
                switchturns++;
                this.p2.pickAttacker(this.p1.pickDefender());
            }
            if (switchturns % 2 != 0) {
                switchturns++;
                this.p1.pickAttacker(this.p2.pickDefender());
                this.p2.pickAttacker(this.p1.pickDefender());
            }

             */
        }
        System.out.println("END");
    }

    private boolean end() {
        /*for (int i = 0; i < numOfMonster; i++) {
            if (p1.getDeadTeamLast(i) != null) {
                System.out.println(p2.getNickname() + " has won the game.");
                return true;
            }
            if (p2.getDeadTeamLast(i) != null) {
                System.out.println(p1.getNickname() + " has won the game.");
                return true;
            }
*/
        boolean p1Dead = true;
        boolean p2Dead = true;
        for (int i = 0; i < 2; i++) {
            if ((p1.team[i].getHitpoints() > 0)) {
                p1Dead = false;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (p2.team[i].getHitpoints() > 0) {
                System.out.println("p2 " + " " + i + " " + p2.team[i].getHitpoints());
                p2Dead = false;
            }
        }
        if (p1Dead) {
            System.out.println(p2.getNickname() + " has won the game.");
        } else if (p2Dead) {
            System.out.println(p1.getNickname() + " has won the game.");
        }
        return (p1Dead || p2Dead);
        /*
        if (p1.getDeadTeamLast((p1.getDeadTeam())) != null) {
            System.out.println(p2.getNickname() + " has won the game.");
            return true;
        }
        if (p2.getDeadTeamLast((p2.getDeadTeam())) != null) {
            System.out.println(p1.getNickname() + " has won the game.");
            return true;
        } return false;
        */

    }
}