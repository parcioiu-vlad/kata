package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTests {

  @Test
  public void test1() {
    assertEquals("YES", Line.Tickets(new int[]{25, 25, 50}));
  }

  @Test
  public void test2() {
    assertEquals("NO", Line.Tickets(new int[]{25, 100}));
  }

  @Test
  public void test3() {
    assertEquals("NO", Line.Tickets(new int[]{100, 50, 25, 25}));
  }

  @Test
  public void test4() {
    assertEquals("YES", Line.Tickets(new int[]{25, 25, 25, 100}));
  }

  @Test
  public void test5() {
    assertEquals("YES", Line.Tickets(new int[]{25, 25, 50, 100}));
  }

  @Test
  public void test6() {
    assertEquals("YES", Line.Tickets(new int[]{25, 25, 25, 25, 50, 100, 50}));
  }
}
