package holding;

/**
 * RUN:
 *         javac typeinfo/pets/*.java
 *         javac holding/PetMap.java && java holding.PetMap
 * OUTPUT:
 *         {My Cat=Cat Molly, My Dog=Dog Ginger, My Hamster=Hamster Bosco}
 *         Dog Ginger
 *         true
 *         true
 */

import java.util.*;
import typeinfo.pets.*;

public class PetMap {

    private static void print(Object obj) {
        System.out.print(obj);
    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<String, Pet>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        println(petMap);

        Pet dog = petMap.get("My Dog");
        println(dog);

        println(petMap.containsKey("My Dog"));
        println(petMap.containsValue(dog));
    }
}