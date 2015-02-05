package generics.coffee;

import java.util.*;

import net.mindview.util.*;

/**
 * RUN:
 *         javac generics/coffee/CoffeeGenerator.java && java generics.coffee.CoffeeGenerator
 * OUTPUT:
 *         Cappuchino 0
 *         Latte 1
 *         Cappuchino 2
 *         Mocha 3
 *         Mocha 4
 *         Americano 5
 *         Cappuchino 6
 *         Latte 7
 *         Breve 8
 *         Breve 9
 */

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {
        Latte.class, Mocha.class, Breve.class
    ,   Cappuchino.class, Americano.class
    };

    private static Random rand = new Random(47);

    public CoffeeGenerator() {}

    private int size = 0;

    public CoffeeGenerator(int size) { this.size = size; }

    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

/*
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() { return count > 0; }

        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
*/

    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            int count = size;

            public boolean hasNext() { return count > 0; }

            public Coffee next() {
                count--;
                return CoffeeGenerator.this.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);    
        }
    }
}