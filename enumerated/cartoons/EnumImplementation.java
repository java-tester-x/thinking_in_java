package enumerated.cartoons;


import java.util.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac enumerated/cartoons/EnumImplementation.java && java enumerated.cartoons.EnumImplementation
 * OUTPUT:
 *         BOB, PUNCHY, BOB, SPARKY, NUTTY, PUNCHY, SLAPY, NUTTY, NUTTY, SLAPY,
 */

enum CartoonCharacter implements Generator<CartoonCharacter> {
    
    SLAPY, SPARKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private Random rand = new Random(47);

    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}


public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.print(String.format(rg.next() + ", "));
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}