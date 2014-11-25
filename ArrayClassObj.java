import java.util.*;

public class ArrayClassObj {

    public static void main(String[] args) {
        Random rand = new Random(47);

        int[] a = new int[rand.nextInt(20)];

        System.out.println(String.format("Length of array is %1$d", a.length));
        System.out.println("Elements of array: "+Arrays.toString(a));
    }
}