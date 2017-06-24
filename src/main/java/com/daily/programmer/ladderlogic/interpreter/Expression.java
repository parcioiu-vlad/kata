package com.daily.programmer.ladderlogic.interpreter;

import java.util.List;

/**
 * Created by parci on 6/11/2017.
 */
public interface Expression {

    public String getName();
    public List<String> getSymbol();
    public default void draw(Context context) {
        context.getOutput().get(context.getLineIndex()).addAll(this.getSymbol());
    }
}
