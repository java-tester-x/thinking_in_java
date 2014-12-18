package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Factories.java && java innerclasses.Factories
 * OUTPUT:
 *         Implementation1 method1
 *         Implementation1 method2
 *         Implementation2 method1
 *         Implementation2 method2
 */

public class Factories {

    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        // Реализации полностью заменяемы!
        serviceConsumer(Implementation2.factory);
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

    private Implementation1() {}

    public void method1() { System.out.println(getClass().getSimpleName() + " method1"); }
    
    public void method2() { System.out.println(getClass().getSimpleName() + " method2"); }

    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {

    private Implementation2() {}

    public void method1() { System.out.println(getClass().getSimpleName() + " method1"); }
    
    public void method2() { System.out.println(getClass().getSimpleName() + " method2"); }

    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new Implementation2();
        }
    };
}