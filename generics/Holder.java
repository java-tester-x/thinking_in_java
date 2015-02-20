package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/Holder.java && java generics.Holder
 * OUTPUT:
 *         java.lang.ClassCastException: generics.Apple cannot be cast to generics.Orange
 *         true
 */

public class Holder<T> {

    private T value;

    public Holder() {}

    public Holder(T val) { value = val; }

    public void set(T val) { value = val; }

    public T get() { return value; }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }


    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);

        // error: incompatible types
        //        Holder<Fruit> Fruit = Apple;
        //                              ^
        // required: Holder<Fruit>
        // found:    Holder<Apple>
        // 
        // Holder<Fruit> Fruit = Apple;

        Holder<? extends Fruit> fruit = Apple;

        Fruit p = fruit.get();
        d = (Apple)fruit.get();
        try {
            Orange c = (Orange)fruit.get();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        // fruit.set(new Apple()); // error: method set in class Holder<T> cannot be applied to given types;
        // fruit.set(new Fruit()); // error: method set in class Holder<T> cannot be applied to given types;

        System.out.println(fruit.equals(d));
    }
}