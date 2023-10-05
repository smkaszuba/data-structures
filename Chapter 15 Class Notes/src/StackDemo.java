import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Insert: 'Hello'");
        stack.push("Insert: ','");
        stack.push("Insert: ' '");
        stack.push("Insert: 'World'");
        stack.push("Insert: '?'");
        stack.push("Delete: '?'");
        stack.push("Insert: '!'");

        System.out.print(stack);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.print(stack);
    }
}
