public class Task221 {
    
    public static void main(String[] args){
        Task221 t = new Task221();
        t.methodA();
    }

    public Integer startingI;

    public void methodA()
    {
        Integer i = new Integer(25);
        System.out.println(System.identityHashCode(i));

        System.out.println(System.identityHashCode(startingI));
        startingI = i;
        System.out.println(System.identityHashCode(startingI));
        
        methodB(i);
    }

    private void methodB(Integer i2)
    {
        System.out.println(System.identityHashCode(i2));
        i2 = i2.intValue();
        System.out.println(System.identityHashCode(i2));

        System.out.println("i2 == startingI: "+(i2 == startingI));
        System.out.println("i2 == startingI: "+i2.equals(startingI));
    }
} 