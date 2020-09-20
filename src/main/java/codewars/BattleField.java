package codewars;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7
 */
public class BattleField {

  private final int[] dx = {+1, 0, +1, 1};
  private final int[] dy = {0, +1, +1, -1};
  private int[][] visited;

  public static boolean fieldValidator(int[][] battleField) {
    BattleField bt = new BattleField();
    return bt.parse(battleField);
  }

  /**
   * https://en.wikipedia.org/wiki/Connected-component_labeling
   *
   * @param field
   */
  public boolean parse(int[][] field) {

    int maxNoBattleships = 1;
    int maxNoCruisers = 2;
    int maxNoDestroyers = 3;
    int maxNoSubmarines = 4;
    visited = new int[field.length][field[0].length];

    for (int i=0;i<field.length;i++) {
      for (int j=0;j<field[0].length;j++) {

        if (visited[i][j] == 1) {
          continue;
        }

        List<Index> indices = new ArrayList<>();
        getIndices(i, j, field, indices);

        if (indices.isEmpty()) {
          continue;
        }

        if (indices.size() > 4) {
          return false;
        }

        if (indices.size() == 4) {
          maxNoBattleships--;
        } else if (indices.size() == 3) {
          maxNoCruisers--;
        } else if (indices.size() == 2) {
          maxNoDestroyers--;
        } else {
          maxNoSubmarines--;
        }
      }
    }

    return maxNoBattleships == 0 && maxNoCruisers == 0 && maxNoDestroyers == 0 && maxNoSubmarines == 0;
  }

  private void getIndices(int i, int j, int[][] field, List<Index> indices) {

    if (i < 0 || i == field.length) {
      return;
    }
    if (j < 0 || j == field[0].length) {
      return;
    }
    if (field[i][j] == 0) {
      return;
    }

    visited[i][j] = 1;
    indices.add(new Index(i, j));

    for (int dir=0;dir<4;dir++) {
      getIndices(i + dx[dir], j+ dy[dir], field, indices);
    }
  }

  private static class Index {
    int row;
    int col;

    public Index(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public static void main(String[] args) {
    int[][] field = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    BattleField battleField = new BattleField();
    battleField.parse(field);
  }

}
