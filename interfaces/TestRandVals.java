package interfaces;

/**
 * RUN:
 *         javac interfaces/TestRandVals.java && java interfaces.TestRandVals
 * OUTPUT:
 *         
 */


public class TestRandVals {
    
    public static void main(String[] args) {
        System.out.println(RandVals.RANDOM_INT);
        System.out.println(RandVals.RANDOM_LONG);
        System.out.println(RandVals.RANDOM_FLOAT);
        System.out.println(RandVals.RANDOM_DOUBLE);
    }
}