package com.daily.programmer.ladderlogic.interpreter;

import java.util.Arrays;
import java.util.List;

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
    public List<String> getSymbol() {
        return Arrays.asList(MnemonicEnum.XIO.getSymbol().split(""));
    }

    @Override
    public String toString() {
        return "XIO{" +
                "value='" + value + '\'' +
                '}';
    }
}
