package com.daily.programmer.ladderlogic.interpreter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by parci on 6/11/2017.
 */
public class BST implements Expression {

    @Override
    public String getName() {
        return MnemonicEnum.BST.name();
    }

    @Override
    public List<String> getSymbol() {
        return Arrays.asList(MnemonicEnum.BST.getSymbol().split(""));
    }

    @Override
    public void draw(Context context) {
        context.getLineNumberStack().push(context.getLineIndex());
        context.getOutput().get(context.getLineIndex()).addAll(this.getSymbol());
    }

    @Override
    public String toString() {
        return "BST{}";
    }
}
