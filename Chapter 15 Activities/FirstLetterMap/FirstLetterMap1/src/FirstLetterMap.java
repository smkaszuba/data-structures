import java.util.*;
import java.io.*;

/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
 */
public class FirstLetterMap {
    public static void main(String[] args)
    {
        String filename = "src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<String, String> lengthMap = new HashMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);

                // Update the map here
                // Modify Worked Example 15.1
                if (lengthMap.containsKey(len))
                    lengthMap.put(len, lengthMap.get(len) + "," + word);
                else
                    lengthMap.put(len, word);

            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            for (Integer len : lengthMap.keySet())
                System.out.println(len + ": " + lengthMap.get(len));
            }

            // Print the map here in this form
            // a: [a, able, aardvark]
            . . .
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
