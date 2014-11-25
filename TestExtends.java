class A {

    protected int x = 1;

    public A() {
        System.out.println("A(): x = " + x);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class B extends A {

    protected int x = 2;

    public int getX() {
        return x;
    }

    public B() {
        super();
        System.out.println("B(): x = " + x);
    }
}

public class TestExtends extends B {

    private int x = 0;    

    public TestExtends() {
        super();
        System.out.println("TestExtends(): x = " + x);
    }

    public static void main (String[] args)
    {
        TestExtends t = new TestExtends();        
        System.out.println("main(): x = " + t.x);
    }
}