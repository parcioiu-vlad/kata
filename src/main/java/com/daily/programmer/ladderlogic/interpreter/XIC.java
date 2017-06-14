package com.daily.programmer.ladderlogic.interpreter;

import java.util.Arrays;
import java.util.List;

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
    public List<String> getSymbol() {
        return Arrays.asList(MnemonicEnum.XIC.getSymbol().split(""));
    }

    @Override
    public String toString() {
        return "XIC{" +
                "value='" + value + '\'' +
                '}';
    }
}
