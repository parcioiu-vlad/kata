package com.daily.programmer.ladderlogic;

import com.daily.programmer.ladderlogic.interpreter.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parci on 6/11/2017.
 */
public class Interpreter {

    public List<List<String>> interpret(String input) {
        Context context = new Context(input);

        List<List<String>> output = context.getOutput();

        String[] mnemonics = input.split("\\s+");

        Expression rootExpression = getExpression(mnemonics[0], mnemonics[1]);

        int lineIndex = 0;

        output.add(new ArrayList<>());
        output.get(lineIndex).addAll(rootExpression.getSymbol());

        int i=2;
        context.setCurrentMnemonicIndex(i);
        while (i < mnemonics.length) {

            String mnemonicCommand = mnemonics[i];
            String mnemonicValue = (i + 1) >= mnemonics.length ? null : mnemonics[i+1];
            Expression expression = getExpression(mnemonicCommand, mnemonicValue);

            if (expression == null) {
                i++;
                continue;
            }

            expression.draw(context);
            context.setCurrentMnemonicIndex(i++);
        }

        return context.getOutput();
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
