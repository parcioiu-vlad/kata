package com.daily.programmer.worddistance;

import com.daily.programmer.util.DictionaryFileUtil;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class WordDistanceCalculatorTest {

  @Test
  public void getShortestDistanceTest() {
    DictionaryFileUtil dictionaryFileUtil = new DictionaryFileUtil();
    Set<String> dictionary = dictionaryFileUtil.getWords();

    WordDistanceCalculator wordDistanceCalculator = new WordDistanceCalculator(dictionary);
    List<String> shortestPath = wordDistanceCalculator
        .getShortestDistance("cat", "dog");

    Assert.assertEquals("dog", shortestPath.get(0));
    Assert.assertEquals("bog", shortestPath.get(1));
    Assert.assertEquals("bot", shortestPath.get(2));
    Assert.assertEquals("bat", shortestPath.get(3));
  }

}
