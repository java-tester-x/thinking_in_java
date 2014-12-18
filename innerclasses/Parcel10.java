package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Parcel10.java && java innerclasses.Parcel10
 * OUTPUT:
 *         Too much more then budget!
 */

public class Parcel10 {

    public Destination destination(final String dest, final float price) {
        return new Destination() {
            
            private int cost;

            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Too much more then budget!");
                }
            }

            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}