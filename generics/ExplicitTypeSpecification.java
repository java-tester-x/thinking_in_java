package generics;

import java.util.*;

import net.mindview.util.*;
import typeinfo.pets.*;

/**
 * RUN:
 *         javac generics/ExplicitTypeSpecification.java && java generics.ExplicitTypeSpecification
 * OUTPUT:
 *         I'm working now!
 */

public class ExplicitTypeSpecification {
    
    static void f(Map<Person, List<? extends Pet>> petPeople) {
        System.out.println("I'm working now!");
    }

    public static void main(String[] args) {
        f(New.<Person, List<? extends Pet>>map());
    }
}