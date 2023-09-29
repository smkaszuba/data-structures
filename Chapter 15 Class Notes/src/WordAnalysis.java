import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
 */
public class WordAnalysis {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
            throws FileNotFoundException {
        Set<String> dictionaryWords = readWords("words");
        Set<String> readWords = (dictionaryWords);

        /* words that are less than 3 letters */
        /* when the words is used, it does the thing yea */
        
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     *         word is a sequence of upper- and lowercase letters.
     */
    public static Set<String> readWords(String filename)
            throws FileNotFoundException {
        Set<String> words = new HashSet<>();

        Scanner in = new Scanner(new File(Filename), "UTF-8");

        while (iterator.hasNext())
                if (iterator.next().length() > 3)
                    iterator.remove();

        return words;
    }
}