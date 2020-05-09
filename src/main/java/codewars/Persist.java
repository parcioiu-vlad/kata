package codewars;

/**
 * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
 * which is the number of times you must multiply the digits in num until you reach a single digit.
 */
public class Persist {

  public static int persistence(long n) {
    int persistence = 0;

    while (n >= 10) {
      n = multiplyDigits(n);
      persistence++;
    }

    return persistence;
  }

  private static long multiplyDigits(long n) {
    long prod = 1;

    while (n > 0) {
      prod = prod * (n % 10);
      n /= 10;
    }

    return prod;
  }

}
