package codewars;

import java.util.HashMap;
import java.util.Map;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line.
 * Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.
 * <p>
 * Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 * <p>
 * Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly
 * in the order people queue?
 * <p>
 * Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment.
 * Otherwise return NO.
 * <p>
 * Examples:
 * <p>
 * Line.Tickets(new int[] {25, 25, 50}) // => YES
 * Line.Tickets(new int[]{25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
 * Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO.
 * 25 25 25 25 50 100
 */
public class Line {

  public static String Tickets(int[] peopleInLine) {
    int ticketPrice = 25;

    Map<Integer, Integer> bills = new HashMap<>();
    bills.put(peopleInLine[0], 1);

    for (int i=1;i<peopleInLine.length;i++) {
      int change = peopleInLine[i] - ticketPrice;

      if (change == 0) {
        bills.merge(peopleInLine[i], 1, Integer::sum);
        continue;
      }

      Integer billNo = bills.get(change);

      if (billNo != null && bills.get(change) > 0) {
        bills.put(change, billNo - 1);
        bills.merge(peopleInLine[i], 1, Integer::sum);
        continue;
      }

      if (change == 25) {
        Integer bill25Count = bills.get(25);
        if (bill25Count == null || bill25Count == 0) {
          return "NO";
        } else {
          bills.put(25, bill25Count - 1);
        }
      } else if (change == 75) {
        Integer bill25Count = bills.get(25);
        Integer bill50Count = bills.get(50);

        if (bill25Count != null && bill25Count != 0 && bill50Count != null && bill50Count != 0) {
          bills.put(25, bill25Count - 1);
          bills.put(50, bill50Count - 1);
        } else if (bill25Count != null && bill25Count != 0 && bill25Count >= 3) {
          bills.put(25, bill25Count - 3);
        } else {
          return "NO";
        }
      }

      bills.merge(peopleInLine[i], 1, Integer::sum);
    }

    return "YES";
  }

}
