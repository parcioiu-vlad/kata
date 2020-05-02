package codewars;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] twoSum(int[] numbers, int target) {

    Map<Integer, Integer> numberMap = new HashMap<>();

    for (int i=0;i<numbers.length;i++) {
      numberMap.put(numbers[i], i);
    }

    for (int i=0;i<numbers.length;i++) {
      int diff = target - numbers[i];
      Integer diffIndex = numberMap.get(diff);
      if (diffIndex != null) {
        return new int[]{i, diffIndex};
      }
    }

    return null;
  }

}
