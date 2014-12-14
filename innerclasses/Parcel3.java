package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Parcel3.java && java innerclasses.Parcel3
 * OUTPUT:
 *         Destination.label = Tanzania
 */

public class Parcel3 {

    class Contents {
        
        private int i = 11;
        public int value() { return i; }
    }

    class Destination {
        
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }

        public String toString() {
            return getClass().getSimpleName()+".label = "+label;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Parcel3.Contents c = p.new Contents();
        Parcel3.Destination d = p.new Destination("Tanzania");

        System.out.println(d);
    }
}
