package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/NoCovariantGenerics.java && java generics.NoCovariantGenerics
 * OUTPUT:
 *         
 */

public class NoCovariantGenerics {
    //
    // error: incompatible types
    //     List<Fruit> flist = new ArrayList<Apple>();
    //                             ^
    //     required: List<Fruit>
    //     found:    ArrayList<Apple>
    //
    List<Fruit> flist = new ArrayList<Apple>();
}