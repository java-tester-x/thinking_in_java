package enumerated;

import java.util.*;
import static enumerated.Outcome.*;


/**
 * RUN:
 *         javac enumerated/RoShamBo2.java && java enumerated.RoShamBo2
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

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER (DRAW, LOSE, WIN),
    SCISSORS (WIN, DRAW, LOSE),
    ROCK (LOSE, WIN, DRAW);

    private Outcome vPAPER, vSCISSORS, vROCK;

    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        this.vPAPER    = paper;
        this.vSCISSORS = scissors;
        this.vROCK     = rock;
    }

    public Outcome complete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER: return vPAPER;
            case SCISSORS: return vSCISSORS;
            case ROCK: return vROCK;
        }
    }

    public static void main(String[] args) {
        RoShamBoX.play(RoShamBo2.class, 20);
    }
}

