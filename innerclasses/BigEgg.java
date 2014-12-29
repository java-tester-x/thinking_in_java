package innerclasses;

/**
 * RUN:
 *         javac innerclasses/BigEgg.java && java innerclasses.BigEgg
 * OUTPUT:
 *         new Egg()
 *         Egg.Yolk()
 */

public class BigEgg extends Egg {

    //
    // You cann't override then inner class Yolk here !
    // 
    public class Yolk {

        public Yolk() { System.out.println("BigEgg.Yolk()"); }
    }

    public static void main(String[] args) {
        new BigEgg();   
    }
}


class Egg {

    private Yolk y;

    protected class Yolk {

        public Yolk() { System.out.println("Egg.Yolk()"); }
    }

    public Egg() {
        System.out.println("new Egg()");
        y = new Yolk();    
    }
}