package com.thoughtworks;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GuessHistoryPrinter {
    private List<GuessHistory> histories;

    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        builder.append("Input").append("\t\t").append("Output").append(separator);
        histories.forEach(history ->
                builder.append(history.getInput()).append("\t\t").append(history.getOutput()).append(separator));
        return builder.toString();
    }
}
