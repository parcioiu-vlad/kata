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
    public String toString() {
        return "BND{}";
    }
}
