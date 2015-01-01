package holding;

/**
 * RUN:
 *         javac holding/ApplesAndOrangesWithGenerics.java && java holding.ApplesAndOrangesWithGenerics
 * OUTPUT:
 *         0
 *         1
 *         2
 *         0
 *         1
 *         2
 */

import java.util.*;

public class ApplesAndOrangesWithGenerics {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        // Error:  no suitable method found for add(Orange)
        // apples.add(new Orange());

        for (int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i).id());
        }

        for (Apple c : apples) {
            System.out.println(c.id());
        }
    }
}

class Apple {
    private static  long counter;
    private final   long id = counter++;
    public long id() { return id; }
}

class Orange { }