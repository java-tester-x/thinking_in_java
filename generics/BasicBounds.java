package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/BasicBounds.java && java generics.BasicBounds
 * OUTPUT:
 *        
 */

public class BasicBounds {

    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}

// --------------------------------------------------------------------

interface HasColor { java.awt.Color  getColor(); }


class Colored<T extends HasColor> {

    T item;

    Colored(T item) { this.item = item; }

    T getItem() { return item; }

    // HERE WE INVOKE method of concreet type:
    java.awt.Color color() { return item.getColor(); }
}

// --------------------------------------------------------------------

class Dimension { public int x, y, z; }


// --------------------------------------------------------------------
// 
// error: interface expected here
// class ColoredDimension<T extends HasColor & Dimension> {}
//                                             ^
//                                              
// class ColoredDimension<T extends HasColor & Dimension> {}


class ColoredDimension<T extends Dimension & HasColor> {

    T item;

    ColoredDimension(T iten) { this.item = item; }

    T getItem() { return item; }

    java.awt.Color color() { return item.getColor(); }

    int getX() { return item.x; }
    
    int getY() { return item.y; }

    int getZ() { return item.z; }
}

// --------------------------------------------------------------------

interface Weight { int weight(); }

// --------------------------------------------------------------------

class Solid<T extends Dimension & HasColor & Weight> {

    T item;

    Solid(T item) { this.item = item; }

    T getItem() { return item; }

    java.awt.Color color() { return item.getColor(); }

    int getX() { return item.x; }
    
    int getY() { return item.y; }

    int getZ() { return item.z; }

    int weight() { return item.weight(); }
}

// --------------------------------------------------------------------

class Bounded extends Dimension implements HasColor, Weight {
    
    public java.awt.Color getColor() { return null; }

    public int weight() { return 0; }
}