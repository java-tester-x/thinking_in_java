class Gizmo {
    
    public void spin() {
        System.out.println("Gizmo.spin()");
    }
}

public class FinalArguments {
    
    void with(final Gizmo g) {
        // final parameter g may not be assigned
        // g = new Gizmo();
    }

    void without(Gizmo g) {
        // it's OK cause g is not final
        g = new Gizmo();
        g.spin();
    }
    
    int f(final int i) {
        // final parameter i may not be assigned
        // i++;
        return i;
    }

    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments x = new FinalArguments();
        x.without(null);
        x.with(null);
    }
}