package codewars.morse;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder {

  private static final Map<String, String> MORSE_CODES = new HashMap<>();

  static {
    MORSE_CODES.put(".-", "A");
    MORSE_CODES.put("-...", "B");
    MORSE_CODES.put("-.-.", "C");
    MORSE_CODES.put("-..", "D");
    MORSE_CODES.put(".", "E");
    MORSE_CODES.put("..-.", "F");
    MORSE_CODES.put("--.", "G");
    MORSE_CODES.put("....", "H");
    MORSE_CODES.put("..", "I");
    MORSE_CODES.put(".---", "J");
    MORSE_CODES.put("-.-", "K");
    MORSE_CODES.put(".-..", "L");
    MORSE_CODES.put("--", "M");
    MORSE_CODES.put("-.", "N");
    MORSE_CODES.put("---", "O");
    MORSE_CODES.put(".--.", "P");
    MORSE_CODES.put("--.-", "Q");
    MORSE_CODES.put(".-.", "R");
    MORSE_CODES.put("...", "S");
    MORSE_CODES.put("-", "T");
    MORSE_CODES.put("..-", "U");
    MORSE_CODES.put("...-", "V");
    MORSE_CODES.put(".--", "W");
    MORSE_CODES.put("-..-", "X");
    MORSE_CODES.put("-.--", "Y");
    MORSE_CODES.put("--..", "Z");

    MORSE_CODES.put(".----", "1");
    MORSE_CODES.put("..---", "2");
    MORSE_CODES.put("...--", "3");
    MORSE_CODES.put("....-", "4");
    MORSE_CODES.put(".....", "5");
    MORSE_CODES.put("-....", "6");
    MORSE_CODES.put("--...", "7");
    MORSE_CODES.put("---..", "8");
    MORSE_CODES.put("----.", "9");
    MORSE_CODES.put("-----", "0");
  }

  public static String decode(String morseCode) {

    StringBuilder result = new StringBuilder();
    for (String word : morseCode.trim().split("   ")) {
      for (String letter : word.split("\\s+")) {
        result.append(MORSE_CODES.get(letter));
      }
      result.append(' ');
    }
    return result.toString().trim();
  }

}
