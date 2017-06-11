package com.daily.programmer.ladderlogic;

import com.daily.programmer.ladderlogic.interpreter.Expression;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private Expression data;
    private Node parent;
    private List<Node> children;

    public Node(Expression expression) {
        this.data = expression;
        this.children = new LinkedList<>();
    }

    public Node(Expression expression, Node parent) {
        this.data = expression;
        this.children = new LinkedList<>();
        this.parent = parent;
    }

    public Node addChild(Node childNode) {
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }
    
    public Expression getData() {
        return data;
    }

    public void setData(Expression data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
