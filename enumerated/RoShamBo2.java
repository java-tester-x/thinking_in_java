package enumerated;

import java.util.*;
import static enumerated.Outcome.*;


/**
 * RUN:
 *         javac enumerated/RoShamBo2.java && java enumerated.RoShamBo2
 * OUTPUT:
 *         
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

