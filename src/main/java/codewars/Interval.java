package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Intervals are represented by a pair of integers in the form of an array.
 * The first value of the interval will always be less than the second value.
 * <p>
 * Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
 */
public class Interval {

  public static int sumIntervals(int[][] intervals) {
    return intervals == null ? 0 : (int) Arrays.stream(intervals)
        .flatMapToInt(interval -> IntStream.range(interval[0], interval[1]))
        .distinct()
        .count();
  }

}
