import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
 */
public class SentenceReverser {
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
     */
    public static String reverse(String sentence) {
        Scanner scanner = new Scanner(sentence);

        // Complete this method. Use a Stack.
        Stack<String> sentenceStack = new Stack<>();
        Stack<String> sentenceStack2 = new Stack<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            sentenceStack.push(word);
            if (word.endsWith("."))
                while (sentenceStack.size() > 0)
                    sentenceStack2.push(sentenceStack.pop());
        }

        return sentenceStack2.toString();
    }
}
