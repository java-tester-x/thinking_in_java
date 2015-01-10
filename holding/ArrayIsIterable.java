package holding;

/**
 * RUN:
 *         javac holding/ArrayIsIterable.java && java holding.ArrayIsIterable
 * OUTPUT:
 *         1 2 3 A B C
 */

import java.util.*;

public class ArrayIsIterable {

    static <T> void test(Iterable<T> ib) {
        for(T t : ib) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args)
    {
        // Ok !!!
        test(Arrays.asList(1, 2, 3));
        
        String[] strings = {"A", "B", "C"};
        
        // Error !!!
        //
        // required: Iterable<T>
        // found: String[]
        // reason: no instance(s) of type variable(s) T exist so that argument type String[] conforms to formal parameter type Iterable<T>
        // where T is a type-variable:
        //   T extends Object declared in method <T>test(Iterable<T>)
        //   
        //test(strings);

        // Ok !!!
        test(Arrays.asList(strings));
    }
}