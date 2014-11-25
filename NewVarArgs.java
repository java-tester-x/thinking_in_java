
public class NewVarArgs {

    public static void main(String[] args) {        
        int[] b = new int[12];
        printArray(b);

        // Integer[] a = new Integer[] {1, 5, 9,};
        // printArray(a);
        
        // NewVarArgs x = new NewVarArgs[5];
        // printArray(x);
        
        printArray(1,2,3,4,5);
    }
    

    private static void printArray(Object... args)
    {
        // System.out.print("[");
        for (Object obj : args) {
            System.out.print(obj + ", ");
        }
        // System.out.print("]");
        System.out.println();
    }
}