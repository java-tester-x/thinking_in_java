package interfaces;

/**
 * RUN:
 *         javac interfaces/Factories.java && java interfaces.Factories
 * OUTPUT:
 *         Implementation1 method1()
 *         Implementation1 method2()
 *         Implementation2 method1()
 *         Implementation2 method2()
 */

public class Factories {

    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        // Реализации полностью заменяемы!
        serviceConsumer(new Implementation2Factory());
    }
}

interface Service {

    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {

    // visibility by package level
    Implementation1() {}

    public void method1() {
        System.out.println(getClass().getSimpleName() + " method1()");
    }

    public void method2() {
        System.out.println(getClass().getSimpleName() + " method2()");
    }
}

class Implementation1Factory implements ServiceFactory {

    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {

    // visibility by package level
    Implementation2() {}

    public void method1() {
        System.out.println(getClass().getSimpleName() + " method1()");
    }

    public void method2() {
        System.out.println(getClass().getSimpleName() + " method2()");
    }
}

class Implementation2Factory implements ServiceFactory {

    public Service getService() {
        return new Implementation2();
    }
}
