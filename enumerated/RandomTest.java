package enumerated;


import java.util.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac enumerated/RandomTest.java && java enumerated.RandomTest
 * OUTPUT:
 *         DODGING HOPPING RUNNING SITTING LYING RUNNING LYING HOPPING 
 *         RUNNING DODGING STANDING FLYING STANDING SITTING SITTING 
 *         RUNNING FALLING LYING FALLING RUNNING
 */

enum Activity {
    SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, FALLING, FLYING;
}

public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}