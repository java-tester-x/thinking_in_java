package holding;

/**
 * RUN:
 *         javac typeinfo/pets/*.java
 *         javac holding/LinkedListFeatures.java && java holding.LinkedListFeatures
 * OUTPUT:
 *         
 */

import java.util.*;
import typeinfo.pets.*;

public class LinkedListFeatures {

    private static void print(Object obj) {
        System.out.print(obj);
    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        Pets aPets = new Pets();
        LinkedList<Pet> pets = new LinkedList<Pet>(aPets.arrayList(5));
        println(pets);

        // just return first element from linked list
        println("pets.getFirst(): " + pets.getFirst());
        println("pets.element(): "  + pets.element());
        println("pets.peek(): "     + pets.peek());
        println("pets: "            + pets);
        println("");

        // remove and return first element from linked list   
        println("pets.remove(): "      + pets.remove());
        println("pets.removeFirst(): " + pets.removeFirst());
        println("pets.poll(): "        + pets.poll());
        println("pets: "               + pets);
        println("");

        // add to the head of linked list
        pets.addFirst(new Rat());
        println("After addFirst(): " + pets);
        
        // add to the end of list
        pets.offer(aPets.randomPet());
        println("After offer(): " + pets);        
        pets.add(aPets.randomPet());
        println("After add(): " + pets);        
        pets.addLast(new Hamster());
        println("After addLast(): "   + pets);

        println("pets.removeLast(): " + pets.removeLast());
        println("pets: "              + pets);
    }
}