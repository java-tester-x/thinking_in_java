package typeinfo.pets;

import java.util.*;

/**
 * RUN:
 *         javac typeinfo/pets/PetCount.java && java typeinfo.pets.PetCount
 * OUTPUT:
 *         
 */

public class PetCount {

    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            put(type, (quantity == null ? 1 : ++quantity));
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                counter.count("Pet");
            }
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
            }
            if (pet instanceof Pug) {
                counter.count("Pug");
            }
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
            if (pet instanceof EgyptianMau) {
                counter.count("EgyptianMau");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
            }
            if (pet instanceof Cymric) {
                counter.count("Cymric");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
            }
        }
        System.out.println();
        System.out.println(counter);        
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}