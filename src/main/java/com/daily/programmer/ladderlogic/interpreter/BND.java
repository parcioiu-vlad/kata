package com.daily.programmer.ladderlogic.interpreter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by parci on 6/11/2017.
 */
public class BND implements Expression {

    @Override
    public String getName() {
        return MnemonicEnum.BND.name();
    }

    @Override
    public List<String> getSymbol() {
        return Arrays.asList(MnemonicEnum.BND.getSymbol().split(""));
    }

    @Override
    public void draw(Context context) {
        List<List<String>> output = context.getOutput();
        int lineIndex = context.getLineIndex();

        output.get(lineIndex).addAll(this.getSymbol());

        int currentLineIndex = lineIndex;
        context.setLineIndex(context.getLineNumberStack().pop());

        int currentLineSize = output.get(currentLineIndex).size();
        int lineSize = output.get(context.getLineIndex()).size();

        if (currentLineIndex - context.getLineIndex()  <= 2) {
            //TODO close directly to upper
            if (currentLineSize < lineSize) {
            }
            else if (currentLineSize > lineSize) {
                int noWhiteSpaces = currentLineSize - output.get(currentLineIndex -1).size() - 1;
                context.addWhiteSpaces(noWhiteSpaces, currentLineIndex -1);
                output.get(currentLineIndex - 1).add("|");
                output.get(context.getLineIndex()).add("+");
            }
        }
        else {
            //TODO close all to lineIndex, ignoring the ones that ends in '+' or '|'
            if (currentLineSize < lineSize) {

            } else if (currentLineSize > lineSize) {

            }
        }
    }

    @Override
    public String toString() {
        return "BND{}";
    }
}
