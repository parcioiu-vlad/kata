package com.daily.programmer.ladderlogic;

import com.daily.programmer.ladderlogic.interpreter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by parci on 6/11/2017.
 */
public class Interpreter {

    private List<List<String>> output;

    public List<List<String>> interpret(String input) {
        output = new ArrayList<List<String>>();

        String[] mnemonics = input.split("\\s+");

        Expression rootExpression = getExpression(mnemonics[0], mnemonics[1]);

        int lineIndex = 0;

        Stack<Integer> lineNumberStack = new Stack<>();

        output.add(new ArrayList<>());
        output.get(lineIndex).add(rootExpression.getSymbol());

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
                output.add(new ArrayList<>());
                lineIndex = output.size() - 1;
                int previousLineIndex = lineNumberStack.peek();
                int bstIndex = output.get(previousLineIndex).lastIndexOf(MnemonicEnum.BST.getSymbol());
                addWhiteSpaces(bstIndex, previousLineIndex, lineIndex);
                output.get(lineIndex).add(expression.getSymbol());

                output.add(new ArrayList<>());
                lineIndex = output.size() - 1;
                addWhiteSpaces(bstIndex, previousLineIndex, lineIndex);

                //if previous mnemoic is different from BST add BST symbol before
                if (!mnemonics[i].equals(MnemonicEnum.BST.getSymbol())) {
                    output.get(lineIndex).add(MnemonicEnum.BST.getSymbol());
                }
            } else if (expression.getName().equals(MnemonicEnum.BND.name())) {
                lineIndex = lineNumberStack.pop();
                //TODO add closing step
            } else if (expression.getName().equals(MnemonicEnum.BST.name())) {
                lineNumberStack.push(lineIndex);
                output.get(lineIndex).add(expression.getSymbol());
            }
            else {
                output.get(lineIndex).add(expression.getSymbol());
            }

            i++;
        }

        return output;
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

    private void addWhiteSpaces(int bstIndex, int previousLineIndex, int lineIndex) {
        for (int i=0;i<bstIndex;i++) {
            int noWhiteSpaces = output.get(previousLineIndex).get(i).length();
            for (int k=0;k<noWhiteSpaces;k++) {
                output.get(lineIndex).add(" ");
            }
        }
    }

}
