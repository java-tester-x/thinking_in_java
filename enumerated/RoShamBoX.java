package enumerated;

import java.util.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac enumerated/RoShamBo2.java && java enumerated.RoShamBo2
 * OUTPUT:
 *         
 */

public class RoShamBoX {

    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(String.format("%1$s vs. %2$s: %3$s", a, b, a.complete(b)));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }
}

