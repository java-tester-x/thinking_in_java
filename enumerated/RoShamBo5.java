package enumerated;

import java.util.*;
import static enumerated.Outcome.*;


/**
 * RUN:
 *         javac enumerated/RoShamBo5.java && java enumerated.RoShamBo5
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

public enum RoShamBo5 implements Competitor<RoShamBo5> {
    
    PAPER, SCISSORS, ROCK;

    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>
        table = new EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>(RoShamBo5.class);

    static {
        for (RoShamBo5 it : RoShamBo5.values()) {
            table.put(it, new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
        }
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }


    static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }

    public Outcome complete(RoShamBo5 it) {
        return table.get(this).get(it);
    }

    public static void main(String[] args) {
        RoShamBoX.play(RoShamBo5.class, 20);
    }
}