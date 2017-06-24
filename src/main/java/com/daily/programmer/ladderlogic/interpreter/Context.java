package com.daily.programmer.ladderlogic.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by parci on 6/24/2017.
 */
public class Context {

    private String input;
    private List<List<String>> output;
    private Stack<Integer> lineNumberStack;
    private String[] mnemonics;
    private int lineIndex;
    private int currentMnemonicIndex;

    public Context(String inputParam) {
        this.input = inputParam;
        this.mnemonics = input.split("\\s+");
        this.output = new ArrayList<List<String>>();
        this.lineNumberStack = new Stack<>();
    }

    public void addWhiteSpaces(int noWhiteSpaces, int lineIndex) {
        for (int i=0;i<noWhiteSpaces;i++) {
            output.get(lineIndex).add(" ");
        }
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<List<String>> getOutput() {
        return output;
    }

    public void setOutput(List<List<String>> output) {
        this.output = output;
    }

    public Stack<Integer> getLineNumberStack() {
        return lineNumberStack;
    }

    public void setLineNumberStack(Stack<Integer> lineNumberStack) {
        this.lineNumberStack = lineNumberStack;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public void setLineIndex(int lineIndex) {
        this.lineIndex = lineIndex;
    }

    public String[] getMnemonics() {
        return mnemonics;
    }

    public void setMnemonics(String[] mnemonics) {
        this.mnemonics = mnemonics;
    }

    public int getCurrentMnemonicIndex() {
        return currentMnemonicIndex;
    }

    public void setCurrentMnemonicIndex(int currentMnemonicIndex) {
        this.currentMnemonicIndex = currentMnemonicIndex;
    }
}
