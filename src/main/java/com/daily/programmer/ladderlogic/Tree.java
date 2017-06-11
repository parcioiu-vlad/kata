package com.daily.programmer.ladderlogic;

import com.daily.programmer.ladderlogic.interpreter.Expression;

/**
 * Created by parci on 6/11/2017.
 */
public class Tree {

    private Node root;

    public Tree(Expression rootData) {
        root = new Node(rootData);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void parseTree(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getData().toString());
        node.getChildren().forEach(this::parseTree);

    }
}
