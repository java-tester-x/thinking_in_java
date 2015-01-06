package holding;

/**
 * RUN:
 *         javac typeinfo/pets/*.java
 *         javac holding/SimpleIteration.java && java holding.SimpleIteration
 * OUTPUT:
 *         0 Rat 1 Manx 2 Cymric 3 Mutt 4 Pug 5 Cymric 6 Pug 7 Manx 8 Cymric 9 Rat 10 EgyptianMau 11 Hamster
 *         0 Rat 1 Manx 2 Cymric 3 Mutt 4 Pug 5 Cymric 6 Pug 7 Manx 8 Cymric 9 Rat 10 EgyptianMau 11 Hamster
 *         [Pug, Manx, Cymric, Rat, EgyptianMau, Hamster]
 */

import java.util.*;
import typeinfo.pets.*;

public class SimpleIteration {
    
    public static void main(String[] args)
    {
        Pets aPets = new Pets();
        List<Pet> pets = aPets.arrayList(12);

        // simple iterator
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + " " + p + " ");
        }
        System.out.println();

        // using foreach
        for (Pet p : pets) {
            System.out.print(p.id() + " " + p + " ");
        }
        System.out.println();

        // deleting from collection using iterator
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
}