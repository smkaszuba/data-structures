import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Joe fffff");
        queue.add("Joe ffffafssdfdsa");
        queue.add("Joe ffeqewqewqwerqwerf");

        queue.remove();

        queue.add("Joe ffeqewqewqwefqwerrqwerf");

        System.out.print(queue);

    }
}
