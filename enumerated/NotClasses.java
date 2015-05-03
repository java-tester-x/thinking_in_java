package enumerated;

import java.util.*;
import java.text.*;


/**
 * RUN:
 *         javac enumerated/NotClasses.java && java enumerated.NotClasses
 *         javap -c LikeClasses
 * OUTPUT:
 *         
 */

public class NotClasses {

    // void f1(LikeClasses.WINKEN instance) {}
}

enum LikeClasses {
    WINKEN { void behavior() { System.out.println("Behavior1"); } },
    BLINKEN { void behavior() { System.out.println("Behavior2"); } },
    NOD { void behavior() { System.out.println("Behavior3"); } };

    abstract void behavior();
}