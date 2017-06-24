package com.daily.programmer.ladderlogic.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parci on 6/11/2017.
 */
public class NXB implements Expression {
    @Override
    public String getName() {
        return MnemonicEnum.NXB.name();
    }

    @Override
    public List<String> getSymbol() {
        return Arrays.asList(MnemonicEnum.NXB.getSymbol().split(""));
    }

    @Override
    public void draw(Context context) {
        List<List<String>> output = context.getOutput();

        output.add(new ArrayList<>());
        context.setLineIndex(output.size() - 1);
        int previousLineIndex = context.getLineNumberStack().peek();
        int bstIndex = output.get(previousLineIndex).lastIndexOf(MnemonicEnum.BST.getSymbol());
        context.addWhiteSpaces(bstIndex, context.getLineIndex());
        output.get(context.getLineIndex()).addAll(this.getSymbol());

        output.add(new ArrayList<>());
        context.setLineIndex(output.size() - 1);
        context.addWhiteSpaces(bstIndex, context.getLineIndex());

        //if previous mnemoic is different from BST add BST symbol before
        if (!context.getMnemonics()[context.getCurrentMnemonicIndex()].equals(MnemonicEnum.BST.getSymbol())) {
            output.get(context.getLineIndex()).add(MnemonicEnum.BST.getSymbol());
        }
    }

    @Override
    public String toString() {
        return "NXB{}";
    }
}
