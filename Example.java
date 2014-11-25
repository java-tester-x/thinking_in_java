public class Example {

    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    public void methodX(int i) { /**/ }
    public String methodY(String s) { return ""; }
}

class B extends A {
    public void methodX(int i) { /**/ }
    public String methodX(String s) {  return "";  }
    public String methodY(String s) {  return ""; }
}