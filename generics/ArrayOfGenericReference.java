package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/ArrayOfGenericReference.java
 * OUTPUT:
 *         
 */

public class ArrayOfGenericReference {

    static Generic<Integer>[] gia;
}

class Generic<T> {}