package generics;

import java.util.*;

import net.mindview.util.*;
import typeinfo.pets.*;

/**
 * RUN:
 *         javac generics/LimitOfInference.java && java generics.LimitOfInference
 * OUTPUT:
 *         error: method f in class LimitOfInference cannot be applied to given types;
 *                 f(New.map());
 *                 ^
 *           required: Map<Person,List<? extends Pet>>
 *           
 *           found: Map<Object,Object>
 *           reason: actual argument Map<Object,Object> cannot be converted to Map<Person,List<? extends Pet>> by method invocation conversion
 *         1 error
 */

public class LimitOfInference {
    
    static void f(Map<Person, List<? extends Pet>> petPeople) {}

    public static void main(String[] args) {
        f(New.map());
    }
}