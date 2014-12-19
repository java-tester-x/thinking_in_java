package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Parcel11.java && java innerclasses.Parcel11
 * OUTPUT:
 *         ParcelDestination.f()
 */

public class Parcel11 {

    private static class ParcelContents implements Contents
    {
        private int i = 11;

        public int value() { return i; }
    }

    protected static class ParcelDestination implements Destination
    {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() { return label; }

        public static void f()  {
            System.out.println("ParcelDestination.f()");
        }

        static int x = 10;

        static class AnotherLevel
        {            
            public static void f() {
                System.out.println("ParcelDestination.AnotherLevel.f()");
            }

            static int x = 9;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }


    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");

        // Error when try:
        // 
        // d.f();
        //
        // innerclasses\Parcel11.java:58: error: cannot find symbol
        //         d.f();
        //          ^
        //   symbol:   method f()
        //   location: variable d of type Destination
        // 1 error
        

        // It's ok !
        ((ParcelDestination) d).f();
    }
}