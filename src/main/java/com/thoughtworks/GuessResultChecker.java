package com.thoughtworks;

import java.util.List;

public class GuessResultChecker {
    public GuessResult check(List<Integer> answer, int inputNumber, int position) {
        return new GuessResult(answer.contains(inputNumber), answer.get(position) == inputNumber);
    }
}
