package enumerated;


/**
 * RUN:
 *         javac enumerated/UpcastEnum.java && java enumerated.UpcastEnum
 * OUTPUT:
 *         HITHER
 *         YON
 */


enum Search { HITHER, YON }


public class UpcastEnum {

    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; // Upcast

        // e.values(); // NO values() in Enum !!!

        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}