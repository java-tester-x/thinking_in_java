import  java.util.*;


abstract class A {
    abstract void x();
}

abstract class B extends A {
    // void x() {}
    abstract void y();
}


public class InterfaceTest {

    public static void main(String[] args) {
        System.out.println("Test!");
    }

}
