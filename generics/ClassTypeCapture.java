package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/ClassTypeCapture.java && java generics.ClassTypeCapture
 * OUTPUT:
 *         true
 *         true
 *         false
 *         true
 */

// COMPILETIME ERROR !!!

public class ClassTypeCapture<T> {

    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt2 = new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

        ClassTypeCapture<House> ctt3 = new ClassTypeCapture<House>(House.class);
        System.out.println(ctt3.f(new Building()));
        System.out.println(ctt3.f(new House()));        
    }
}

class Building {}

class House extends Building {}