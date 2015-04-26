package enumerated;

import java.util.*;
import java.lang.reflect.*;
import net.mindview.util.*;

/**
 * RUN:
 *         javac enumerated/Reflection.java && java enumerated.Reflection
 * OUTPUT:
 *         
 */


enum Explore { HERE, THERE }

public class Reflection {

    public static Set<String> analize(Class<?> enumClass) {
        System.out.println("----- Analizing " + enumClass + " -----");
        
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }

        System.out.println("Base: "+enumClass.getSuperclass());
        
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);

        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analize(Explore.class);
        Set<String> enumMethods = analize(Enum.class);

        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));

        System.out.print("Explore.removeAll(Enum): " + exploreMethods.removeAll(enumMethods));
        System.out.println(exploreMethods);

        OSExecute.command("javap enumerated.Explore");
    }
}