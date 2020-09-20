package codewars;

import java.util.HashMap;
import java.util.Map;

public class SnakesLadders {

  private final Map<Integer, Integer> map = new HashMap<>();
  private final Player player1;
  private final Player player2;

  private boolean gameFinished;
  private int playerTurn;

  public SnakesLadders() {
    map.put(2, 38);
    map.put(7, 14);
    map.put(8, 31);
    map.put(15, 26);
    map.put(16, 6);
    map.put(21, 42);
    map.put(28, 84);
    map.put(36, 44);
    map.put(46, 25);
    map.put(49, 11);
    map.put(51, 67);
    map.put(62, 19);
    map.put(64, 60);
    map.put(71, 91);
    map.put(74, 53);
    map.put(78, 98);
    map.put(87, 94);
    map.put(89, 68);
    map.put(92, 88);
    map.put(95, 75);
    map.put(99, 80);

    player1 = new Player(1);
    player2 = new Player(2);
    playerTurn = 1;
    gameFinished = false;
  }

  public String play(int die1, int die2) {

    if (gameFinished) {
      return "Game over!";
    }

    int total = die1 + die2;

    String message;

    if (playerTurn == 1) {
      message = movePlayer(player1, total);
    } else {
      message = movePlayer(player2, total);
    }

    setNextPLayer(die1, die2);

    return message;
  }

  private String movePlayer(Player player, int moves) {
    player.position = player.position + moves;

    if (player.position == 100) {
      this.gameFinished = true;
      return player.getWinMessage();
    }

    if (player.position > 100) {
      player.position = 100 - (player.position - 100);
    }

    if (map.containsKey(player.position)) {
      player.position = map.get(player.position);
    }

    return player.getPositionMessage();
  }

  private void setNextPLayer(int die1, int die2) {

    if (die1 == die2) {
      return;
    }

    if (playerTurn == 1) {
      playerTurn = 2;
    } else {
      playerTurn = 1;
    }
  }

  private static class Player {
    public int playerNumber;
    public int position = 0;

    Player(int playerNumber) {
      this.playerNumber = playerNumber;
    }

    public String getWinMessage() {
      return "Player " + playerNumber + " Wins!";
    }

    public String getPositionMessage() {
      return "Player " + playerNumber + " is on square " + position;
    }
  }

}
