package innerclasses;

/**
 * RUN:
 *         javac innerclasses/TestParcel.java && java innerclasses.TestParcel
 * OUTPUT:
 *         PDestination.label = Tasmania
 */

public class TestParcel {

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");

        System.out.println(d);

        // Error! PContents is PRIVATE inner class in Parcel4 class
        // 
        // Parcel4.PContents pc = p.new PContents();
    }
}

class Parcel4 {

    private class PContents implements Contents {

        private int i = 11;
        
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {

        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }

        public String toString() {
            return getClass().getSimpleName()+".label = "+label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}