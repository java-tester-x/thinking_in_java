package holding;

/**
 * RUN:
 *         javac holding/GenericsAndUpcasting.java && java holding.GenericsAndUpcasting
 * OUTPUT:
 *         GrannySmith
 *         Gala
 *         Fuji
 *         Braeburn
 */

import java.util.*;

public class GenericsAndUpcasting {
    
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();    
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());

        for (Apple c : apples) {
            System.out.println(c);
        }
    }
}

class GrannySmith extends Apple { }
class Gala extends Apple { }
class Fuji extends Apple { }
class Braeburn extends Apple { }

class Apple {
    private static  long counter;
    private final   long id = counter++;
    public long id() { return id; }
    public String toString() { return getClass().getSimpleName(); }
}
