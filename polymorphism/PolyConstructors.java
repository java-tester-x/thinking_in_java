package polymorphism;

/**
 * RUN:
 * 
 *     javac polymorphism/PolyConstructors.java && java polymorphism.PolyConstructors
 *     
 * OUTPUT:
 * 
 *     Glyph() before invoking draw()
 *     RoundGlyph.draw().radius = 0
 *     Glyph() after invoking draw()
 *     RoundGlyph.RoundGlyph().radius = 5
 *     
 */

class Glyph {
    
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before invoking draw()");
        draw();
        System.out.println("Glyph() after invoking draw()");
    }
}


class RoundGlyph extends Glyph {
    
    private int radius = 1;

    void draw() {
        System.out.println("RoundGlyph.draw().radius = " + radius);
    }

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph().radius = " + radius);
    }
}


public class PolyConstructors {

    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}