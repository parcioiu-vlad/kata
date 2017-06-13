package com.daily.programmer.ladderlogic.interpreter;

/**
 * Created by parci on 6/11/2017.
 */
public enum MnemonicEnum {
    XIC("-| |-"), XIO("-|/|-"), BST("+"), NXB("|"), BND("");

    private String symbol;

    MnemonicEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
