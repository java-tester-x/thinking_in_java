package typeinfo.pets;

import java.util.*;

/**
 * RUN:
 *         javac typeinfo/pets/PetCount2.java && java typeinfo.pets.PetCount2
 * OUTPUT:
 *         Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau 
 *         Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
 *
 *         {Rat=2, Cymric=5, Cat=9, Pet=20, Dog=6, Manx=7, EgyptianMau=2, Pug=3,
 *          Mouse=2, Rodent=5, Hamster=1, Mutt=3}
 */

public class PetCount2 {

    public static void main(String[] args) {
        PetCount.countPets(Pets.creator);
    }
}