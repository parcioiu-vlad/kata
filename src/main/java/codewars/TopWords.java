package codewars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.groupingBy;

/**
 * https://www.codewars.com/kata/51e056fe544cf36c410000fb/train/java
 */
public class TopWords {

  public static List<String> top3(String s) {
    return Arrays.stream(s.toLowerCase().split("[^a-z*|']"))
        .filter(o -> !o.isEmpty() && !o.replace("'","").isEmpty())
        .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .map(Map.Entry::getKey)
        .limit(3)
        .collect(Collectors.toList());
  }

}
