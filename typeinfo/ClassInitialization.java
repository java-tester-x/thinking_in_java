package typeinfo;

/**
 * RUN:
 *         javac typeinfo/ClassInitialization.java && java typeinfo.ClassInitialization
 * OUTPUT:
 *         After creation link on Initable
 *         47
 *         Initialization of Initable
 *         258
 *         Initialization of Initable2
 *         147
 *         Initialization of Initable3
 *         After creation link on Initable3
 *         74
 */

// import java.util.logging.*;
import java.util.*;


public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After creation link on Initable");
        
        // no initialization
        System.out.println(Initable.staticFinal);

        // initialization
        System.out.println(Initable.staticFinal2);

        // initialization
        System.out.println(Initable2.staticNonFinal);

        // initialization
        Class initable3 = Class.forName("typeinfo.Initable3");
        System.out.println("After creation link on Initable3");
        System.out.println(Initable3.staticNonFinal);
    }
}

class Initable {
    static final int staticFinal  = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initialization of Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initialization of Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initialization of Initable3");
    }
}