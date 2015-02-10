package generics;

import net.mindview.util.*;
import java.util.*;

/**
 * RUN:
 *         javac generics/BankTeller.java && java generics.BankTeller
 * OUTPUT:
 *         Teller 3 serve Customer 1
 *         Teller 2 serve Customer 2
 *         Teller 3 serve Customer 3
 *         Teller 1 serve Customer 4
 *         Teller 1 serve Customer 5
 *         Teller 3 serve Customer 6
 *         Teller 1 serve Customer 7
 *         Teller 2 serve Customer 8
 *         Teller 3 serve Customer 9
 *         Teller 3 serve Customer 10
 *         Teller 2 serve Customer 11
 *         Teller 4 serve Customer 12
 *         Teller 2 serve Customer 13
 *         Teller 1 serve Customer 14
 *         Teller 1 serve Customer 15
 */

public class BankTeller {

    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serve " +c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        Generators.fill(line, Customer.generator(), 15);

        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers, Teller.generator, 4);

        for(Customer c : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }
    }
}

class Customer {

    private static long counter = 1;
    private final  long id = counter++;
    
    private Customer() {}

    public String toString() { return "Customer " + id; }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            public Customer next() { return new Customer(); }
        };
    }
}

class Teller {

    private static long counter = 1;
    private final  long id = counter++;
    
    private Teller() {}

    public String toString() { return "Teller " + id; }

    public static Generator<Teller> generator =
        new Generator<Teller>() {
            public Teller next() { return new Teller(); }
        };
}