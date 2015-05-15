package enumerated;

import java.util.*;
import static enumerated.Outcome.*;


/**
 * RUN:
 *         javac enumerated/RoShamBo3.java && java enumerated.RoShamBo3
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

public enum RoShamBo3 implements Competitor<RoShamBo3> {

    PAPER {
        public Outcome complete(RoShamBo3 it) {
            switch(it) {
                default:
                case PAPER: return DRAW;
                case SCISSORS: return LOSE;
                case ROCK: return WIN;
            }
        }
    },

    SCISSORS {
        public Outcome complete(RoShamBo3 it) {
            switch(it) {
                default:
                case PAPER: return WIN;
                case SCISSORS: return DRAW;
                case ROCK: return LOSE;
            }
        }
    },

    ROCK {
        public Outcome complete(RoShamBo3 it) {
            switch(it) {
                default:
                case PAPER: return LOSE;
                case SCISSORS: return WIN;
                case ROCK: return DRAW;
            }
        }
    };

    public abstract Outcome complete(RoShamBo3 it);

    public static void main(String[] args) {
        RoShamBoX.play(RoShamBo3.class, 20);
    }
}