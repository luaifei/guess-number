package com.thoughtworks;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GuessHistoryPrinter {
    private List<GuessHistory> histories;

    public String getOutput() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Input")
                .append("\t")
                .append("Output")
                .append(System.lineSeparator());
        histories.forEach(history ->
                stringBuilder.append(history.getGuessInput())
                        .append("\t")
                        .append(history.getOutput())
                        .append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
