package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/SimpleHolder.java && java generics.SimpleHolder
 * OUTPUT:
 *         
 */

public class SimpleHolder {

    private Object obj;

    public void set(Object obj) { this.obj = obj; }

    public Object get() { return obj; }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String s = (String)holder.get();
        System.out.println("s = " + s);
    }
}