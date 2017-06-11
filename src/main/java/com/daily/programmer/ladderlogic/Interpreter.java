package com.daily.programmer.ladderlogic;

import com.daily.programmer.ladderlogic.interpreter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by parci on 6/11/2017.
 */
public class Interpreter {

    public List<List<String>> interpret(String input) {
        String[] mnemonics = input.split("\\s+");

        Expression rootExpression = getExpression(mnemonics[0], mnemonics[1]);

        Stack<Integer> nodeStack = new Stack();
        List<List<String>> output = new ArrayList<List<String>>();
        int lineIndex = 0;

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
            } else if (expression.getName().equals(MnemonicEnum.BND.name())) {
                lineIndex--;
            } else if (expression.getName().equals(MnemonicEnum.BST.name())) {
                i++;
                continue;
            } else {
                output.get(lineIndex).add(rootExpression.getSymbol());
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

}
