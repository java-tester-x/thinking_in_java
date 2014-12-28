package innerclasses;

/**
 * RUN:
 *         javac innerclasses/InheritInner.java && java innerclasses.InheritInner
 * OUTPUT:
 *         
 */

public class InheritInner extends WithInner.Inner {

    //
    // Error: error: an enclosing instance that contains WithInner.Inner is required
    //
    // InheritInner() {} 

    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}

class WithInner {

    class Inner {

    }
}