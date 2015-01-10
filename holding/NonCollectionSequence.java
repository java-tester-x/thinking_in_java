package holding;

/**
 * RUN:
 *         javac typeinfo/pets/*.java
 *         javac holding/NonCollectionSequence.java && java holding.NonCollectionSequence
 * OUTPUT:
 *         0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 */

import java.util.*;
import typeinfo.pets.*;

public class NonCollectionSequence extends PetSequence {

    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            public boolean hasNext() {
                return index < pets.length;
            }
            
            public Pet next() {
                return pets[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}

class PetSequence {
    protected Pet[] pets = new Pets().createArray(8);
}