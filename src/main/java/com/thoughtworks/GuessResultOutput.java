package com.thoughtworks;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GuessResultOutput {
    private List<GuessResult> guessResults;

    public String getOutput() {
        return countNumberAndPositionRight() + "A" + countNumberRightNotPosition() + "B";
    }

    private long countNumberAndPositionRight() {
        return guessResults.stream()
                .filter(result -> result.isNumberRight() && result.isPositionRight())
                .count();
    }

    private long countNumberRightNotPosition() {
        return guessResults.stream()
                .filter(result -> result.isNumberRight() && !result.isPositionRight())
                .count();
    }
}
