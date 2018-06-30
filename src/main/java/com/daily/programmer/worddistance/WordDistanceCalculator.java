package com.daily.programmer.worddistance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordDistanceCalculator {

  private final Set<String> dictionary;

  public WordDistanceCalculator(Set<String> dictionary) {
    this.dictionary = dictionary;
  }

  public List<String> getShortestDistance(String wordStart, String wordEnd) {
    int treeLevel = 0;

    Tree root = new Tree();
    root.setNodes(new ArrayList<>());
    root.setValue(wordStart);
    createTree(wordStart, root, treeLevel);

    return find(root, wordEnd, new ArrayList<>());
  }

  /**
   * Creates a tree where the root is the word
   * and the next levels are words with changed the letter corresponding to the tree level
   * @param word
   * @param tree
   * @param treeDepth
   */
  private void createTree(String word, Tree tree, int treeDepth) {

    if (treeDepth > word.length()) {
      return;
    }

    List<String> words = getWords(word, treeDepth);

    treeDepth++;

    for (String value : words) {
      Tree child = new Tree();
      child.setValue(value);
      child.setNodes(new ArrayList<>());
      tree.getNodes().add(child);

      createTree(value, child, treeDepth);
    }
  }

  /**
   * Creates a list of words by replacing the letter
   * at index in startWord with letters from a to z.
   * @param startWord
   * @param index
   * @return
   */
  private List<String> getWords(String startWord, int index) {
    List<String> words = new ArrayList<>();

    if (index > startWord.length()-1) {
      index = 0;
    }

    StringBuilder stringBuilder = new StringBuilder(startWord);

    for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
      stringBuilder.setCharAt(index, alphabet);
      String word = stringBuilder.toString();
      if (word.equals(startWord)) {
        continue;
      }
      if (dictionary.contains(stringBuilder.toString())) {
        words.add(word);
      }
    }

    return words;
  }

  private List<String> find(Tree tree, String word, List<String> path) {
    if (tree.getValue().equals(word)) {
      return path;
    }

    for (Tree node: tree.getNodes()) {
      if (find(node, word, path) != null) {
        path.add(node.getValue());
        return path;
      }
    }

    return null;
  }

  private class Tree {
    private String value;
    private List<Tree> nodes;

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public List<Tree> getNodes() {
      return nodes;
    }

    public void setNodes(List<Tree> nodes) {
      this.nodes = nodes;
    }
  }

}
