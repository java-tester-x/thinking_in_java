package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/ErasureAndInheritance.java && javac generics.ErasureAndInheritance
 * OUTPUT:
 *         
 */

public class ErasureAndInheritance {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj); // Note: generics\ErasureAndInheritance.java uses unchecked or unsafe operations.
                     // Note: Recompile with -Xlint:unchecked for details.
    }
}


class GenericBase<T> {

    private T element;

    public void set(T arg) { element =arg; }

    public T get() { return element; }
}

class Derived1<T> extends GenericBase<T> {}

class Derived2 extends GenericBase {}

/*
 * 
 * error: unexpected type
 * class Derived3 extends GenericBase<?> {}
 *                                   ^
 *   required: class or interface without bounds
 *   found:    ?
 * 1 error
 * 
 */
class Derived3 extends GenericBase<?> {}