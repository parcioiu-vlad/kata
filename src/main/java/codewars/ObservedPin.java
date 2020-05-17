package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservedPin {

  private static final Map<Character,String> ADJACENTS = new HashMap<Character,String>() {{
    put('1', "124");
    put('2', "2135");
    put('3', "326");
    put('4', "4157");
    put('5', "54268");
    put('6', "6953");
    put('7', "748");
    put('8', "87590");
    put('9', "986");
    put('0', "08");
  }};

  public static List<String> getPINs(String observed) {

    List<String> ans = Collections.singletonList("");

    for (char c: observed.toCharArray()) {

      List<String> tmp = new ArrayList<>();
      for (char cc: ADJACENTS.get(c).toCharArray()) {
        for (String s: ans) {
          tmp.add(s+cc);
        }
      }
      ans = tmp;
    }
    return ans;
  }

}
