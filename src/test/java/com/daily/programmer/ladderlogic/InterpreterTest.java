package com.daily.programmer.ladderlogic;

import org.junit.Test;

/**
 * Created by parci on 6/11/2017.
 */
public class InterpreterTest {

    @Test
    public void interpretTest() {
        Interpreter interpreter = new Interpreter();
        Tree tree = interpreter.interpret("XIC I1 BST XIC I2 XIC I5 NXB BST XIC I3 NXB XIC I4 BND XIO I5 NXB XIC O1");
        tree.parseTree(tree.getRoot());
    }
}
