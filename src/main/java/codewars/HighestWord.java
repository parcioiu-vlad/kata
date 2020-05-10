package codewars;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a string of words, you need to find the highest scoring word.
 *
 * Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
 *
 * You need to return the highest scoring word as a string.
 *
 * If two words score the same, return the word that appears earliest in the original string.
 */
public class HighestWord {

  public static String getHighestWord(String s) {
    return Arrays.stream(s.split(" "))
            .max(Comparator.comparingInt(
                    a -> a.chars().map(i -> i - 96).sum()
            )).get();
  }

}
