/*
1. Implementar obstaculos (Witch e Fairy)
2. Ataques consecutivos da mummy é por objeto
3. no game: Otimizar os turnos e otimizar o codigo do check end a meio
*/

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Game game1 = new Game(p1, p2);
        game1.play();
    }
}