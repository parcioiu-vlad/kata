package com.daily.programmer.ladderlogic.interpreter;

/**
 * Created by parci on 6/11/2017.
 */
public class XIO implements Expression {

    String value;

    public XIO(String mnemonicValue) {
        this.value = mnemonicValue;
    }

    public XIO() {

    }

    @Override
    public String getName() {
        return MnemonicEnum.XIO.name();
    }

    @Override
    public String getSymbol() {
        return MnemonicEnum.XIO.getSymbol();
    }

    @Override
    public String toString() {
        return "XIO{" +
                "value='" + value + '\'' +
                '}';
    }
}
