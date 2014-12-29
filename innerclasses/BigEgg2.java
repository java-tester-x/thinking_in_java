package innerclasses;

/**
 * RUN:
 *         javac innerclasses/BigEgg2.java && java innerclasses.BigEgg2
 * OUTPUT:
 *         Egg2.Yolk()
 *         new Egg2()
 *         Egg2.Yolk()
 *         BigEgg2.Yolk()
 *         BigEgg2.Yolk.f()
 */

public class BigEgg2 extends Egg2 {

    public class Yolk extends Egg2.Yolk {

        public Yolk() { System.out.println("BigEgg2.Yolk()"); }

        public void f() { System.out.println("BigEgg2.Yolk.f()"); }
    }

    public BigEgg2() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}

class Egg2 {

    private Yolk y = new Yolk();

    protected class Yolk {

        public Yolk() { System.out.println("Egg2.Yolk()"); }

        public void f() { System.out.println("Egg2.Yolk.f()"); }
    }

    public Egg2() {
        System.out.println("new Egg2()");
    }

    public void insertYolk(Yolk yy) { y = yy; }

    public void g() { y.f(); }
}