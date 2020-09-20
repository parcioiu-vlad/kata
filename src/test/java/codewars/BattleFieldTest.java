package codewars;

import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BattleFieldTest {

  private static int[][] battleField = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
      {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
      {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
      {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
      {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
      {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

  private static int[][] contacts = {
      {1, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
      {1, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
      {1, 0, 1, 0, 1, 1, 1, 0, 1, 0 },
      {1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      {0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
      {0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
      {0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      {0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

  };


  @Test
  public void test() {
    assertTrue(BattleField.fieldValidator(battleField));
  }

  @Test
  public void contactTest() {
    assertFalse(BattleField.fieldValidator(contacts));
  }

}
