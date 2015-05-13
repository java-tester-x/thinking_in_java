package enumerated;

import java.util.*;
import static enumerated.Outcome.*;


/**
 * RUN:
 *         javac enumerated/RoShamBo3.java && java enumerated.RoShamBo3
 * OUTPUT:
 *         
 */

public enum RoShamBo3 implements Competitor<RoShamBo2> {

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
}