package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/InstantiateGenericType.java && java generics.InstantiateGenericType
 * OUTPUT:
 *         ClassAsFactory<Employee> success!
 *         ClassAsFactory<Integer> failure!
 */

// COMPILETIME ERROR !!!

public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);

        System.out.println("ClassAsFactory<Employee> success!");
        try {
            // 
            // Fire exception here cause Integer class have not constructor w/o args !
            // 
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        }
        catch(Exception e) {
            System.out.println("ClassAsFactory<Integer> failure!");
        }
    }
}

class ClassAsFactory<T> {

    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}

class Employee {}