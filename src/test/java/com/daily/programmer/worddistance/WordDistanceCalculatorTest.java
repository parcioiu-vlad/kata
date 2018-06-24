package com.daily.programmer.worddistance;

import com.daily.programmer.util.DictionaryFileUtil;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class WordDistanceCalculatorTest {

  @Test
  public void getShortestDistanceTest() {
    DictionaryFileUtil dictionaryFileUtil = new DictionaryFileUtil();
    Set<String> dictionary = dictionaryFileUtil.getWords();

    WordDistanceCalculator wordDistanceCalculator = new WordDistanceCalculator(dictionary);
    List<String> shorttestPath = wordDistanceCalculator
        .getShortestDistance("cat", "dog");
  }

}
