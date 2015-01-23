package typeinfo.toys;

/**
 * RUN:
 *         javac typeinfo/toys/ToyTest.java && java typeinfo.toys.ToyTest
 * OUTPUT:
 *         Class name: typeinfo.toys.FancyToy is it interface? [false]
 *         Simple name: FancyToy
 *         Canonical name: typeinfo.toys.FancyToy
 *         Class name: typeinfo.toys.HasBatteries is it interface? [true]
 *         Simple name: HasBatteries
 *         Canonical name: typeinfo.toys.HasBatteries
 *         Class name: typeinfo.toys.Waterproof is it interface? [true]
 *         Simple name: Waterproof
 *         Canonical name: typeinfo.toys.Waterproof
 *         Class name: typeinfo.toys.Shoots is it interface? [true]
 *         Simple name: Shoots
 *         Canonical name: typeinfo.toys.Shoots
 *         Class name: typeinfo.toys.Toy is it interface? [false]
 *         Simple name: Toy
 *         Canonical name: typeinfo.toys.Toy
 */

// import java.util.logging.*;
// import java.util.*;


public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println(
            "Class name: " + cc.getName() +
            " is it interface? ["+ cc.isInterface() +"]"
        );

        System.out.println("Simple name: " + cc.getSimpleName());

        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args)
    {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class FancyToy not found");
            System.exit(1);
        }

        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        }
        catch(InstantiationException e) {
            System.out.println("Object creation failure");
        }
        catch(IllegalAccessException e) {
            System.out.println("Access deny");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy  extends     Toy
    implements  HasBatteries, Waterproof, Shoots {

    FancyToy() { super(1); }
}