package typeinfo;

/**
 * RUN:
 *         javac typeinfo/GenericClassReferences.java && java typeinfo.GenericClassReferences
 * OUTPUT:
 *         
 */

// import java.util.logging.*;
import java.util.*;


public class GenericClassReferences {

    public static void main(String[] args) {
        Class intClass = int.class;

        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;

        intClass = double.class;

        /*
        typeinfo\GenericClassReferences.java:23: error: incompatible types
        genericIntClass = double.class;
                                ^
            required: Class<Integer>
            found:    Class<Double>
         */
        // genericIntClass = double.class;
    }
}