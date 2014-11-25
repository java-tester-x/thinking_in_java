import java.util.*;

public class Task176 {
    
    public static void main(String[] args) {
        Task176 t = new Task176();

        Object o1 = Task176.get(new LinkedList());    
        // Object o2 = Task176.get(new LinkedList<?>());
        // String s1 = Task176.get(new LinkedList<String>());    
        Integer i1 = Task176.get(new LinkedList<Integer>());    
        Object o3 = Task176.get(new LinkedList<Object>());    
        String s2 = (String) Task176.get(new LinkedList<String>());        
    }

    public static Object get(List list) {
        return list.get(0);
    }

}