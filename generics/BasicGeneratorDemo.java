package generics;

import net.mindview.util.*;

/**
 * RUN:
 *         javac generics/BasicGeneratorDemo.java && java generics.BasicGeneratorDemo
 * OUTPUT:
 *         CountedObject 0
 *         CountedObject 1
 *         CountedObject 2
 *         CountedObject 3
 *         CountedObject 4
 */

public class BasicGeneratorDemo {

    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);

        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}