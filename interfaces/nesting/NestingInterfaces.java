package interfaces.nesting;

/**
 * RUN:
 *         javac interfaces/nesting/NestingInterfaces.java && java interfaces.nesting.NestingInterfaces
 * OUTPUT:
 *         DImp2 f()
 */

public class NestingInterfaces {

    public class Bimp implements A.B {
        
        public void f() {
            System.out.println(getClass().getSimpleName() + " f()"); 
        }
    }


    class Cimp implements A.C {
        
        public void f() {
            System.out.println(getClass().getSimpleName() + " f()"); 
        }
    }


    // 
    // Private-интерфейс не может быть реализован нигде,
    // кроме как внутри класса, где он был определен
    // 
    // class DImp implements A.D {
    //     public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
    // }

    class EImp implements E {
        public void g() { System.out.println(getClass().getSimpleName() + " g()"); }
    }

    class EGImp implements E.G {
        public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
    }

    class EImp2 implements E {

        public void g() { System.out.println(getClass().getSimpleName() + " g()"); }

        class EG implements E.G {
            public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
        }
    }


    public static void main(String[] args) {
        A a = new A();
        
        // A.D ad = a.getD();
        
        // A.DImp2 di2 = a.getD();
        
        // a.getD().f();

        A a2 = new A();
        a2.receivedD(a.getD());
    }
}

class A {

    interface B {
        void f();
    }

    public class BImp implements B {
        public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
    }

    private class BImp2 implements B {
        public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
    }

    
    public interface C {
        void f();
    }

    class CImp implements C {
        public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
    }

    private class CImp2 implements C {
        public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
    }


    private interface D {
        void f();
    }

    private class DImp implements D {
        public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
    }

    public class DImp2 implements D {
        public void f() { System.out.println(getClass().getSimpleName() + " f()"); }
    }

    
    public D getD() {
        return new DImp2();
    }

    private D dRef;

    public void receivedD(D d) {
        dRef = d;
        dRef.f();
    }
}

interface E {

    interface G {
        void f();
    }

    public interface H {
        void f();
    }

    void g();

    // 
    // Не может быть private внутри интерфейса!!!
    // 
    // private interface I {}
}