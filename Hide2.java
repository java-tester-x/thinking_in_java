class Homer {

    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }    
}

class Milhouse {}

// 
// Won't compile... cause using @Override for method doh()
// 
class Lisa extends Homer {

    @Override void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }
}

public class Hide2 {
    
    public static void main(String[] args) {
        Lisa lisa = new Lisa();
        lisa.doh(1);
        lisa.doh('x');
        lisa.doh(1.0f);
        lisa.doh(new Milhouse());
    }
}