package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoSumTest {

  @Test
  public void test() {
    doTest(new int[]{1, 2, 3}, new int[]{0, 2});
    doTest(new int[]{1234, 5678, 9012}, new int[]{1, 2});
    doTest(new int[]{2, 2, 3}, new int[]{0, 1});
  }

  private void doTest(int[] numbers, int[] expected) {
    int target = numbers[expected[0]] + numbers[expected[1]];
    int[] actual = TwoSum.twoSum(numbers, target);
    int received = numbers[actual[0]] + numbers[actual[1]];
    assertEquals(target, received);
  }

}
