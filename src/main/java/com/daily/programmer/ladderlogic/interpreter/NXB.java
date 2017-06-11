package com.daily.programmer.ladderlogic.interpreter;

/**
 * Created by parci on 6/11/2017.
 */
public class NXB implements Expression {
    @Override
    public String getName() {
        return MnemonicEnum.NXB.name();
    }

    @Override
    public String toString() {
        return "NXB{}";
    }
}
