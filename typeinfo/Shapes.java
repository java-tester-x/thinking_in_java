package typeinfo;

/**
 * RUN:
 *         javac typeinfo/Shapes.java && java typeinfo.Shapes
 * OUTPUT:
 *         Circle.draw()
 *         Square.draw()
 *         Triangle.draw()
 */

// import java.util.logging.*;
import java.util.*;


public class Shapes {

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
            new Circle(), new Square(), new Triangle()
        );
        for (Shape shape: shapeList) {
            shape.draw();
        }
    }
}

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return getClass().getSimpleName();
    }    
}

class Square extends Shape {
    public String toString() {
        return getClass().getSimpleName();
    }    
}

class Triangle extends Shape {
    public String toString() {
        return getClass().getSimpleName();
    }    
}