package com.daily.programmer.ladderlogic.interpreter;

/**
 * Created by parci on 6/11/2017.
 */
public class BST implements Expression {
    @Override
    public String getName() {
        return MnemonicEnum.BST.name();
    }

    @Override
    public String getSymbol() {
        return MnemonicEnum.BST.getSymbol();
    }

    @Override
    public String toString() {
        return "BST{}";
    }
}
