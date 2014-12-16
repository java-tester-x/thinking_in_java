package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Parcel8.java && java innerclasses.Parcel8
 * OUTPUT:
 *         470
 */

public class Parcel8 {

    public Wrapping wrapping(int x)
    {
        return new Wrapping(x) { // argument in constructor

            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);

        System.out.println(w.value());
    }
}