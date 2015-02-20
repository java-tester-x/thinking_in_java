package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/SuperTypeWildcards.java
 * OUTPUT:
 *         
 */

public class SuperTypeWildcards {
    
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());    // OK
        apples.add(new Jonathan()); // OK
        
        // apples.add(new Fruit()); //  error: no suitable method found for add(Fruit)
    }
}