public class SimpleConstructor {
    
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new Rock();
        }
    }
}

class Rock {
    Rock() {
        System.out.println("Rock");
    }
}