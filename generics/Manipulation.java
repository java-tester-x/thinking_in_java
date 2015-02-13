package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/Manipulation.java && java generics.Manipulation
 * OUTPUT:
 *         
 */

public class Manipulation {

    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
        manipulator.manipulate();
    }
}

class Manipulator<T> {

    private T obj;

    public Manipulator(T x) { obj = x; }

    /**
     * error: cannot find symbol
     *  public void manipulate() { obj.f(); }
     *                                    ^
     *  symbol:   method f()
     *  location: variable obj of type T
     *  where T is a type-variable:
     *      T extends Object declared in class Manipulator
     */
    public void manipulate() { obj.f(); }
}