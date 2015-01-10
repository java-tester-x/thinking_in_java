package holding;

/**
 * RUN:
 *         javac typeinfo/pets/*.java
 *         javac holding/CollectionSequence.java && java holding.CollectionSequence
 * OUTPUT:
 *         0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 *         0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 */

import java.util.*;
import typeinfo.pets.*;

public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = new Pets().createArray(8);

    public int size() {
        return pets.length;
    }

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
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}