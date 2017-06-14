package com.daily.programmer.ladderlogic.interpreter;

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
    public String toString() {
        return "NXB{}";
    }
}
