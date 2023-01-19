
public class Main {
    /*
RULES OF THE GAME:
    1. Create players
    2. Create Game
    3. Initialize Game
    4. Both players pick their own teams
    5. Play Game
    6. Leave Game
 */
    public static void main(String[] args) {

        Player nuno = new Player("Bushnell");
        Player rui = new Player("Raja");
        //Player miguel = new Player("Xai");

        Game game1 = new Game(nuno, rui, 3);
        Game.initializeGame(game1, nuno, rui); //DUVIDA - ISTO É BOA PRATICA?
        nuno.pickTeam(game1, 1, 1, 1);
        rui.pickTeam(game1, 0, 1, 2);
        game1.play(nuno, rui);
        Game.leaveGame(nuno, rui);
    }
}