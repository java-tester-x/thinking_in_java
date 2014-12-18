package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Games.java && java innerclasses.Games
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
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }
}


interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    
    private Checkers() {}

    private int moves = 0;

    private static final int MOVES = 3;

    public boolean move() {
        System.out.println(getClass().getSimpleName() + " move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory factory = new GameFactory() {
        public Game getGame() {
            return new Checkers();
        }
    };    
}

class Chess implements Game {
    
    private Chess() {}

    private int moves = 0;

    private static final int MOVES = 4;

    public boolean move() {
        System.out.println(getClass().getSimpleName() + " move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory factory = new GameFactory() {
        public Game getGame() {
            return new Chess();
        }
    }; 
}