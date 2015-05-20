package enumerated;

import java.util.*;
import static enumerated.Outcome.*;


/**
 * RUN:
 *         javac enumerated/RoShamBo6.java && java enumerated.RoShamBo6
 * OUTPUT:
 *         ROCK vs. ROCK: DRAW
 *         SCISSORS vs. ROCK: LOSE
 *         SCISSORS vs. ROCK: LOSE
 *         SCISSORS vs. ROCK: LOSE
 *         PAPER vs. SCISSORS: LOSE
 *         PAPER vs. PAPER: DRAW
 *         PAPER vs. SCISSORS: LOSE
 *         ROCK vs. SCISSORS: WIN
 *         SCISSORS vs. SCISSORS: DRAW
 *         ROCK vs. SCISSORS: WIN
 *         SCISSORS vs. PAPER: WIN
 *         SCISSORS vs. PAPER: WIN
 *         ROCK vs. PAPER: LOSE
 *         ROCK vs. SCISSORS: WIN
 *         SCISSORS vs. ROCK: LOSE
 *         PAPER vs. SCISSORS: LOSE
 *         SCISSORS vs. PAPER: WIN
 *         SCISSORS vs. PAPER: WIN
 *         SCISSORS vs. PAPER: WIN
 *         SCISSORS vs. PAPER: WIN
 */

public enum RoShamBo6 implements Competitor<RoShamBo6> {

    PAPER, SCISSORS, ROCK;

    private static Outcome[][] table = {
        {DRAW, LOSE, WIN}, // PAPER
        {WIN, DRAW, LOSE}, // SCISSORS
        {LOSE, WIN, DRAW}, // ROCK
    };

    public Outcome complete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBoX.play(RoShamBo6.class, 20);
    }
}