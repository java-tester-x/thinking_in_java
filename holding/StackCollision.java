package holding;

/**
 * RUN:
 *         javac holding/StackCollision.java && java holding.StackCollision
 * OUTPUT:
 *         stack: holding.Stack [fleas, has, dog, My]
 *         fleas has dog My
 *         stack2: java.util.Stack [My, dog, has, fleas]
 *         fleas has dog My
 */

public class StackCollision {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();        
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        System.out.println("stack: " + stack.getClass().getName()+" "+stack);
        while ( ! stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();


        java.util.Stack<String> stack2 = new java.util.Stack<String>();
        for (String s : "My dog has fleas".split(" ")) {
            stack2.push(s);
        }
        System.out.println("stack2: " + stack2.getClass().getName()+ " "+stack2);
        while ( ! stack2.empty()) {
            System.out.print(stack2.pop() + " ");
        }
        System.out.println();
    }
}