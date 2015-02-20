package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/CompilerIntelligence.java && java generics.CompilerIntelligence
 * OUTPUT:
 *         
 */

public class CompilerIntelligence {

    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0);
        flist.contains(new Apple());
        flist.indexOf(new Apple());
    }
}