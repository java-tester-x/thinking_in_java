package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Parcel9.java && java innerclasses.Parcel9
 * OUTPUT:
 *         label = Tasmania
 */

public class Parcel9 {

    // local variable dest is accessed from within inner class;
    // needs to be declared final
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            public String readLabel() { return label; }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");

        System.out.println("label = " + d.readLabel());
    }
}