package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightTest {

  @Test
  public void test() {
    assertEquals("2000 103 123 4444 99", Weight.orderWeight("103 123 4444 99 2000"));
    assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", Weight.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
  }

}
