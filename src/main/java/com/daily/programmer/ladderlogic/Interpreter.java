package com.daily.programmer.ladderlogic;

import com.daily.programmer.ladderlogic.interpreter.*;

import java.util.Stack;

/**
 * Created by parci on 6/11/2017.
 */
public class Interpreter {

    public Tree interpret(String input) {
        String[] mnemonics = input.split("\\s+");

        Expression rootExpression = getExpression(mnemonics[0], mnemonics[1]);

        Tree tree = new Tree(rootExpression);
        Node node = tree.getRoot();

        Stack<Node> nodeStack = new Stack();

        int i=2;
        while (i < mnemonics.length) {

            String mnemonicCommand = mnemonics[i];
            String mnemonicValue = (i + 1) >= mnemonics.length ? null : mnemonics[i+1];
            Expression expression = getExpression(mnemonicCommand, mnemonicValue);

            if (expression == null) {
                i++;
                continue;
            }

            if (expression.getName().equals(MnemonicEnum.NXB.name())) {
                node = nodeStack.peek();
            } else if (expression.getName().equals(MnemonicEnum.BND)) {
                node = nodeStack.pop();
                i++;
                continue;
            }

            Node childNode = new Node(expression);

            node.addChild(childNode);

            if (expression.getName().equals(MnemonicEnum.BST.name())) {
                nodeStack.push(childNode);
            }

            node = childNode;
            i++;
        }

        return tree;
    }

    private Expression getExpression(String mnemonicCommand, String mnemonicValue) {
        switch (mnemonicCommand) {
            case "BST":
                return new BST();
            case "NXB":
                return new NXB();
            case "XIC":
                return new XIC(mnemonicValue);
            case "BND":
                return new BND();
            case "XIO":
                return new XIO(mnemonicValue);
            default:
                return null;
        }
    }

}
