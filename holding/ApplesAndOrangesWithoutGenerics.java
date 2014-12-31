package holding;

/**
 * RUN:
 *         javac holding/ApplesAndOrangesWithoutGenerics.java && java holding.ApplesAndOrangesWithoutGenerics
 * OUTPUT (1):
 *         Note: holding\ApplesAndOrangesWithoutGenerics.java uses unchecked or unsafe operations.
 *         Note: Recompile with -Xlint:unchecked for details.
 *         Exception in thread "main" java.lang.ClassCastException: holding.Orange cannot be cast to holding.Apple
 *                 at holding.ApplesAndOrangesWithoutGenerics.main(ApplesAndOrangesWithoutGenerics.java:37)
 *                 
 * OUTPUT (2):
 *         Exception in thread "main" java.lang.ClassCastException: holding.Orange cannot be cast to holding.Apple
 *                 at holding.ApplesAndOrangesWithoutGenerics.main(ApplesAndOrangesWithoutGenerics.java:37)
 */

import java.util.*;

public class ApplesAndOrangesWithoutGenerics {

    // OUTPUT (1):
    // @SuppressWarnings("unchecked")
    
    // OUTPUT (2):
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        // YES! 
        apples.add(new Orange());

        for (int i = 0; i < apples.size(); i++) {
            // But one object is not Apple! We see this in run time.
            ((Apple)apples.get(i)).id();
        }
    }
}

class Apple {
    private static  long counter;
    private final   long id = counter++;
    public long id() { return id; }
}

class Orange { }