package interfaces;

/**
 * RUN:
 *         javac interfaces/Games.java && java interfaces.Games
 * OUTPUT:
 *         Checkers move 0
 *         Checkers move 1
 *         Checkers move 2
 *         Chess move 0
 *         Chess move 1
 *         Chess move 2
 *         Chess move 3
 */

public class Games {

    public static void playGame(GameFactory factory) {
        Game g = factory.getGame();
        while (g.move());
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
}


interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    
    private int moves = 0;

    private static final int MOVES = 3;

    public boolean move() {
        System.out.println(getClass().getSimpleName() + " move " + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory {
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    
    private int moves = 0;

    private static final int MOVES = 4;

    public boolean move() {
        System.out.println(getClass().getSimpleName() + " move " + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory {
    public Game getGame() {
        return new Chess();
    }
}
