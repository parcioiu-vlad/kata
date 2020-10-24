package codewars;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * https://www.codewars.com/kata/52bef5e3588c56132c0003bc
 */
public class Tree {

  public static List<Integer> treeByLevels(Node node) {
    if (node == null) {
      return Collections.emptyList();
    }

    List<Integer> elements = new ArrayList<>();
    Queue<Node> queue = new ArrayDeque<>();

    elements.add(node.value);
    queue.add(node);

    while (!queue.isEmpty()) {
      Node currentNode = queue.remove();

      if (currentNode.left != null) {
        elements.add(currentNode.left.value);
        queue.add(currentNode.left);
      }
      if (currentNode.right != null) {
        elements.add(currentNode.right.value);
        queue.add(currentNode.right);

      }
    }

    return elements;
  }

  static class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(Node l, Node r, int v) {
      left = l;
      right = r;
      value = v;
    }
  }

}
