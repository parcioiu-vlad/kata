package com.daily.programmer.ladderlogic;

import org.junit.Test;

import java.util.List;

/**
 * Created by parci on 6/11/2017.
 */
public class InterpreterTest {

    @Test
    public void interpretTest() {
        Interpreter interpreter = new Interpreter();
        List<List<String>> ladder = interpreter.interpret("XIC I1 BST XIC I2 XIC I5 NXB BST XIC I3 NXB XIC I4 BND XIO I5 NXB XIC O1 BND");
        for(List<String> branch : ladder) {
            for(String mnemonic : branch) {
                System.out.print(mnemonic);
            }
            System.out.println();
        }

        System.out.println();

        ladder = interpreter.interpret("XIC I1 BST XIC I2 NXB XIC O1 BND");
        for(List<String> branch : ladder) {
            for(String mnemonic : branch) {
                System.out.print(mnemonic);
            }
            System.out.println();
        }
    }
}
