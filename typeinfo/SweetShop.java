package typeinfo;

/**
 * RUN:
 *         javac typeinfo/SweetShop.java && java typeinfo.SweetShop
 * OUTPUT:
 *         inside method main()
 *         Loading class Candy
 *         after creation Candy
 *         Loading class Gum
 *         after invocation of Class.forName("Gum")
 *         Loading class Cookie
 *         after creation Cookie
 */

// import java.util.logging.*;
// import java.util.*;


public class SweetShop {

    public static void main(String[] args)
    {
        // Candy
        System.out.println("inside method main()");
        new Candy();
        System.out.println("after creation Candy");

        // Gum
        try {
            Class.forName("typeinfo.Gum");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class Gum not found");
        }
        System.out.println("after invocation of Class.forName(\"Gum\")");

        // Cookie
        new Cookie();
        System.out.println("after creation Cookie");

        // Class Gum already loaded !!!
        // Java skip reloading this class !!!
        try {
            Class.forName("typeinfo.Gum");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class Gum not found");
        }
    }
}

class Candy {
    static { System.out.println("Loading class Candy"); }
}

class Gum {
    static { System.out.println("Loading class Gum"); }
}

class Cookie {
    static { System.out.println("Loading class Cookie"); }
}
