package holding;

/**
 * RUN:
 *         javac holding/ListFeatures.java && java holding.ListFeatures
 * OUTPUT:
 *         
 */

import java.util.*;

public class ListFeatures {

}

class Pets {

    public static Collection arrayList(int count) {
        List<Pet> pets = ArrayList<Pet>();
        for (int i = 0; i < count; i++) {
            pets.add(new Pet());
        }
    }
}

class Pet {
    private static  long counter;
    private final   long id = counter++;
    
    public long id() {
        return id;
    }
    
    public String toString() {
        return getClass().getSimpleName() + ", id = " + id;
    }
}

class Hamster {
    private int hamsterNumber;

    public Hamster(int hamsterNumber) {
        this.hamsterNumber = hamsterNumber;
    }

    public String toString() {
        return "This is Hamster #" + hamsterNumber;
    }
}