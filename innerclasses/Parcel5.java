package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Parcel5.java && java innerclasses.Parcel5
 * OUTPUT:
 *         PDestination, label = Tasmania
 */

public class Parcel5 {

    public Destination dest(String s) {

        class PDestination implements Destination {

            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            public String readLabel() {
                return label;
            }

            public String toString() {
                return getClass().getSimpleName() + ", label = "+label;
            }
        }

        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.dest("Tasmania");

        System.out.println(d);
    }
}