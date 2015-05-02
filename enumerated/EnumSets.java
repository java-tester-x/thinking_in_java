package enumerated;

import java.util.*;
import static enumerated.AlarmPoints.*;

/**
 * RUN:
 *         javac enumerated/EnumSets.java && java enumerated.EnumSets
 * OUTPUT:
 *         [BATHROOM]
 *         [STAIR1, STAIR2, BATHROOM, KITCHEN]
 *         [LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY]
 *         [LOBBY, OFFICE2, OFFICE3, BATHROOM, UTILITY]
 *         [STAIR1, STAIR2, OFFICE1, OFFICE4, KITCHEN]
 */

public class EnumSets {

    public static void main(String[] args) {
        // empty set
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);

        points.add(BATHROOM);
        System.out.println(points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points.removeAll(EnumSet.of(OFFICE1, OFFICE4));
        System.out.println(points);

        points = EnumSet.complementOf(points);
        System.out.println(points);
    }

}