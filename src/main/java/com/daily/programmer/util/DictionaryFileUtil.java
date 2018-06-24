package com.daily.programmer.util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryFileUtil {

  private final static Logger LOG = Logger.getLogger(DictionaryFileUtil.class.getName());

  private static final String DICTIONARY_FILENAME = "dictionary";

  public Set<String> getWords() {
    Set<String> words = new TreeSet<>();

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(DICTIONARY_FILENAME).getFile());

    try (Scanner scanner = new Scanner(file)) {

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        words.add(line);
      }

    } catch (IOException e) {
      LOG.log(Level.SEVERE, e.getMessage(), e);
    }

    return words;
  }

}
