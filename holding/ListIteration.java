package holding;

/**
 * RUN:
 *         javac typeinfo/pets/*.java
 *         javac holding/ListIteration.java && java holding.ListIteration
 * OUTPUT:
 *         Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug, 5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
 *         7 6 5 4 3 2 1 0
 *         [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
 *         [Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]
 */

import java.util.*;
import typeinfo.pets.*;

public class ListIteration {

    public static void main(String[] args)
    {
        Pets aPets = new Pets();
        List<Pet> pets = aPets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        // direct printing
        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        System.out.println();
        
        // reverse printing
        while (it.hasPrevious()) {
            System.out.print(it.previous().id() + " ");
        }
        System.out.println();

        // pets
        System.out.println(pets);        

        // replace items
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(aPets.randomPet());
        }
        System.out.println(pets);
    }
}