package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HighestWordTest {

  @Test
  public void test() {
    assertEquals("taxi", HighestWord.getHighestWord("man i need a taxi up to ubud"));
    assertEquals("volcano", HighestWord.getHighestWord("what time are we climbing up to the volcano"));
    assertEquals("semynak", HighestWord.getHighestWord("take me to semynak"));
  }

}
