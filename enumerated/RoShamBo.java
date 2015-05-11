package enumerated;

import java.util.*;
import static enumerated.Outcome.*;


/**
 * RUN:
 *         javac enumerated/RoShamBo.java && java enumerated.RoShamBo
 * OUTPUT:
 *         
 */

public class RoShamBo {

    static final int SIZE = 20;

    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0: return new Scissors();
            case 1: return new Paper();
            case 2: return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        System.out.println(String.format("%1$s vs. %2$s: %3$s", a.toString(), b.toString(), a.complete(b)));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}


interface Item {
    Outcome complete(Item item);
    Outcome eval(Paper p);
    Outcome eval(Scissors s);
    Outcome eval(Rock r);
}

class Paper implements Item {
    public Outcome complete(Item item) {
        return item.eval(this);
    }
    
    public Outcome eval(Paper p) {
        return DRAW;
    }

    public Outcome eval(Scissors s) {
        return WIN;
    }

    public Outcome eval(Rock r) {
        return LOSE;
    }

    public String toString() { return "Paper"; }
}


class Scissors implements Item {
    public Outcome complete(Item item) {
        return item.eval(this);
    }
    
    public Outcome eval(Paper p) {
        return LOSE;
    }

    public Outcome eval(Scissors s) {
        return DRAW;
    }

    public Outcome eval(Rock r) {
        return WIN;
    }

    public String toString() { return "Scissors"; }
}


class Rock implements Item {
    public Outcome complete(Item item) {
        return item.eval(this);
    }
    
    public Outcome eval(Paper p) {
        return WIN;
    }

    public Outcome eval(Scissors s) {
        return LOSE;
    }

    public Outcome eval(Rock r) {
        return DRAW;
    }

    public String toString() { return "Rock"; }
}