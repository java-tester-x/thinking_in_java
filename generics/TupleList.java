package generics;

import java.util.*;
import net.mindview.util.*;

/**
 * RUN:
 *         javac generics/TupleList.java && java generics.TupleList
 * OUTPUT:
 *         
 */

public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {

    public static void main(String[] args) {
        
    }
}