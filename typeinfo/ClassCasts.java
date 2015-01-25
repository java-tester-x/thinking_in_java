package typeinfo;

/**
 * RUN:
 *         javac typeinfo/ClassCasts.java && java typeinfo.ClassCasts
 * OUTPUT:
 *         
 */

// import java.util.logging.*;
// import java.util.*;


public class ClassCasts {

    public static void main(String[] args) {
        Building b = new House();
        
        Class<House> houseType = House.class;
        
        House h = houseType.cast(b);
        h       = (House) b; // identical to cast() in above line
    }
}

class Building {}

class House extends Building {}