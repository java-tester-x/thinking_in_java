package innerclasses;

/**
 * RUN:
 *         javac innerclasses/ClassInterface.java && java innerclasses.ClassInterface$Test
 * OUTPUT:
 *         Howdy!
 */

public interface ClassInterface {

    void howdy();

    class Test implements ClassInterface {

        public void howdy() { System.out.println("Howdy!"); }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}