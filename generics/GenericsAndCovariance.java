package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/GenericsAndCovariance.java && java generics.GenericsAndCovariance
 * OUTPUT:
 *         
 */

public class GenericsAndCovariance {

    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();

        // flist.add(new Apple());  // error: no suitable method found for add(Apple)
        // flist.add(new Fruit());  // error: no suitable method found for add(Fruit)
        // flist.add(new Object()); // error: no suitable method found for add(Object)
        
        flist.add(null);

        Fruit f = flist.get(0);
    }
}