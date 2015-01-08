package holding;

/**
 * RUN:
 *         javac holding/TestStack.java && java holding.TestStack
 * OUTPUT:
 *         stack: [fleas, has, dog, My]
 *         fleas has dog My
 */

public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        System.out.println("stack: " + stack);

        while ( ! stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}