package com.daily.programmer.ladderlogic.interpreter;

/**
 * Created by parci on 6/11/2017.
 */
public class BND implements Expression {
    @Override
    public String getName() {
        return MnemonicEnum.BND.name();
    }

    @Override
    public String getSymbol() {
        return MnemonicEnum.BND.getSymbol();
    }

    @Override
    public String toString() {
        return "BND{}";
    }
}
