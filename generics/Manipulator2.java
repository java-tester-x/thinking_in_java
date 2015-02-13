package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/Manipulator2.java
 * OUTPUT:
 *         
 */

// 
// Compile without errors cause exists type constraint <T extends HasF>
// 
public class Manipulator2<T extends HasF> {

    private T obj;

    public Manipulator2(T x) { obj = x; }

    public void manipulate() { obj.f(); }
}