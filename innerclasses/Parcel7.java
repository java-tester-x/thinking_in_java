package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Parcel7.java && java innerclasses.Parcel7
 * OUTPUT:
 *         , int i = 11
 *         MyContents, int i = 11
 */

public class Parcel7 {

    public Contents contents()
    {
        return new Contents() {

            private int i = 11;

            public int value() { return i; }

            public String toString() { return getClass().getSimpleName() + ", int i = "+i; }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();

        System.out.println(c);

        Parcel7b.main(args);
    }
}


class Parcel7b {

    class MyContents implements Contents {
        private int i = 11;
        public int value() { return i; }
        public String toString() { return getClass().getSimpleName() + ", int i = "+i; }
    }

    public Contents contents() { return new MyContents(); }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();

        System.out.println(c);
    }
}