package com.daily.programmer.ladderlogic.interpreter;

/**
 * Created by parci on 6/11/2017.
 */
public class XIC implements Expression {

    private String value;

    public XIC(String mnemonicValue) {
        this.value = mnemonicValue;
    }

    public XIC() {

    }

    @Override
    public String getName() {
        return MnemonicEnum.XIC.name();
    }

    @Override
    public String getSymbol() {
        return "-| |-";
    }

    @Override
    public String toString() {
        return "XIC{" +
                "value='" + value + '\'' +
                '}';
    }
}
