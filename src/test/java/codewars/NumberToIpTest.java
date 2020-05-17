package codewars;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class NumberToIpTest {

  @Test
  public void test() {
    assertEquals("128.114.17.104", NumberToIp.longToIP(2154959208L));
    assertEquals("0.0.0.0", NumberToIp.longToIP(0));
    assertEquals("128.32.10.1", NumberToIp.longToIP(2149583361L));
  }

}
