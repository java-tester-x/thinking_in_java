package holding;

/**
 * RUN:
 *         javac typeinfo/pets/*.java
 *         javac holding/MapOfList.java && java holding.MapOfList
 * OUTPUT:
 *         People: [Person Marilyn, Person Luke, Person Kate, Person Isaac, Person Dawn]
 *         Pets: [[Pug Louie aka Louis Snorkelstein Dupree, Cat Stanfoed aka Stinky el Negro, Cat Pinkola], [Rat Fuzzy, Rat Fizzy], [Cat Elsie May, Dog Margrett], [Rat Freckly], [Cymric Molly, Mutt Spot]]
 *         Person Marilyn has:
 *            Pug Louie aka Louis Snorkelstein Dupree
 *            Cat Stanfoed aka Stinky el Negro
 *            Cat Pinkola
 *         
 *         Person Luke has:
 *            Rat Fuzzy
 *            Rat Fizzy
 *         
 *         Person Kate has:
 *            Cat Elsie May
 *            Dog Margrett
 *         
 *         Person Isaac has:
 *            Rat Freckly
 *         
 *         Person Dawn has:
 *            Cymric Molly
 *            Mutt Spot
 */

import java.util.*;
import typeinfo.pets.*;

public class MapOfList {

    private static void print(Object obj) {
        System.out.print(obj);
    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();

    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"), Arrays.asList(
            new Pug("Louie aka Louis Snorkelstein Dupree"),
            new Cat("Stanfoed aka Stinky el Negro"),
            new Cat("Pinkola")
        ));
        petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        println("People: " + petPeople.keySet());
        println("Pets: " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            println(person + " has: ");
            for (Pet pet : petPeople.get(person)) {
                println("   " + pet);
            }
            System.out.println();
        }
    }
}