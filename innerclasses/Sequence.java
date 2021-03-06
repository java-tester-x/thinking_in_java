package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Sequence.java && java innerclasses.Sequence
 * OUTPUT:
 *         0 1 2 3 4 5 6 7 8 9
 */

public class Sequence {

    private Object[] items;
    private int next = 0;
    
    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        } 
    }

    private class SequenceSelector implements Selector {
        
        private int i = 0;

        public boolean end() {
            return i == items.length; // using private field "items" of outer class !  
        }
        
        public Object current() {
            return items[i]; // using private field "items" of outer class !
        }
        
        public void next() {
            if (i < items.length) { // using private field "items" of outer class !
                i++;
            }
        }
    }

    public Selector getSelector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }

        Selector selector = sequence.getSelector();
        while ( ! selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

interface Selector {
    boolean end();
    Object  current();
    void    next();
}