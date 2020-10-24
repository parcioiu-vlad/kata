package codewars;

import java.util.Arrays;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TreeTest {

  @Test
  public void nullTest() {
    assertEquals(Arrays.asList(), Tree.treeByLevels(null));
  }

  @Test
  public void basicTest() {
    assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), Tree.treeByLevels(
        new Tree.Node(new Tree.Node(null, new Tree.Node(null, null, 4), 2),
            new Tree.Node(new Tree.Node(null, null, 5), new Tree.Node(null, null, 6), 3), 1)));
  }

}
