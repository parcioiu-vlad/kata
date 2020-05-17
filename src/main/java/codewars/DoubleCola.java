package codewars;

/**
 * heldon, Leonard, Penny, Rajesh and Howard are in the queue for a "Double Cola" drink vending machine;
 * there are no other people in the queue. The first one in the queue (Sheldon) buys a can, drinks it and doubles!
 * The resulting two Sheldons go to the end of the queue.
 *
 * Then the next in the queue (Leonard) buys a can, drinks it and gets to the end of the queue as two Leonards, and so on.
 */
public class DoubleCola {

  public static String whoIsNext(String[] names, int number) {

    while (number > names.length) {
      number = (number - (names.length - 1)) / 2;
    }
    return names[number - 1];
  }

}
