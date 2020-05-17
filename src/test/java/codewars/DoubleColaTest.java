package codewars;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class DoubleColaTest {

  @Test
  public void test1() {
    String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
    int n = 1;
    assertEquals("Sheldon", DoubleCola.whoIsNext(names, n));
  }
  @Test
  public void test2() {
    String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
    int n = 6;
    assertEquals("Sheldon", DoubleCola.whoIsNext(names, n));
  }

  @Test
  public void test() {
    String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };

    Assert.assertEquals("Penny", DoubleCola.whoIsNext(names, 52));
  }

}
