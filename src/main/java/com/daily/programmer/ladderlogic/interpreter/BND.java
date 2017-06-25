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
    public void draw(Context context) {
        List<List<String>> output = context.getOutput();
        int lineIndex = context.getLineIndex();

        int currentLineIndex = lineIndex;
        context.setLineIndex(context.getLineNumberStack().pop());

        int currentLineSize = output.get(currentLineIndex).size();
        int lineSize = output.get(context.getLineIndex()).size();

        if (currentLineIndex - context.getLineIndex()  <= 2) {
            //TODO close directly to upper
            output.get(lineIndex).addAll(this.getSymbol());
            if (currentLineSize < lineSize) {
            }
            else if (currentLineSize > lineSize) {
                int noWhiteSpaces = currentLineSize - output.get(currentLineIndex -1).size() - 1;
                context.addWhiteSpaces(noWhiteSpaces, currentLineIndex -1);
                output.get(currentLineIndex - 1).add("|");
                output.get(context.getLineIndex()).add("+");
            }
            else {

            }
        }
        else {
            //TODO close all to lineIndex, ignoring the ones that ends in '+' or '|'
            int i = 0;
            int maxListSize = getMaxListIndex(context);
            while (i <= currentLineIndex) {
                if (i % 2 == 0 && lineClosed(output, i)) {
                    i++;
                    continue;
                }
                else if (i % 2 != 0) {
                    //TODO add '|'
                    i++;
                    continue;
                }
                if (output.get(i).size() < maxListSize) {
                    //add '-'
                    addBlank(output.get(i), maxListSize - output.get(i).size());
                }
                output.get(i).add("+");
                i++;
            }
            if (currentLineSize < lineSize) {

            }
            else if (currentLineSize > lineSize) {

            }

        }
    }

    @Override
    public String toString() {
        return "BND{}";
    }

    private int getMaxListIndex(Context context) {
        int max = 0;

        for (List<String> line : context.getOutput()) {
            if (line.size() > max) {
                max = line.size();
            }
        }

        return max;
    }

    private boolean lineClosed(List<List<String>> output, int index) {
        return output.get(index).get(output.get(index).size() - 1).equals("+");
    }

    private void addBlank(List<String> output, int noBlanks) {
        for (int i=0;i<noBlanks;i++) {
            output.add("-");
        }
    }
}
