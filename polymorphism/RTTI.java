package polymorphism;


class Useful {

    public void f() {}
    public void g() {}
}


class MoreUseful extends Useful {

    public void f() {}
    public void g() {}
    public void u() {}
    public void v() {}
    public void w() {}
}


class RTTI {

    public static void main(String[] args) {
        Useful[] x = {new Useful(), new MoreUseful()};

        x[0].f();
        x[1].g();

        // x[1].u(); // compilation error!

        ((MoreUseful)x[1]).u(); // RTTI work fine!

        // ((MoreUseful)x[0]).u(); // RTTI error!
    }
}