package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/CovariantArrays.java && java generics.CovariantArrays
 * OUTPUT:
 *         java.lang.ArrayStoreException: generics.Fruit
 *         java.lang.ArrayStoreException: generics.Orange
 */

public class CovariantArrays {

    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK

        try {
            fruit[0] = new Fruit(); // ArrayStoreException
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            fruit[0] = new Orange(); // ArrayStoreException
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}


class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

