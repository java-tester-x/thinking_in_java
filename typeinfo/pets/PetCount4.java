package typeinfo.pets;

import net.mindview.util.*;
import java.util.*;

/**
 * RUN:
 *         javac typeinfo/pets/PetCount4.java && java typeinfo.pets.PetCount4
 * OUTPUT:
 *         Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster
 *         EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
 *         
 *         {Cymric=5, Mouse=2, Rat=2, Manx=7, EgyptianMau=2, Pet=20, Dog=6, Hamster=1,
 *          Rodent=5, Pug=3, Cat=9, Mutt=3}
 */

public class PetCount4 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}