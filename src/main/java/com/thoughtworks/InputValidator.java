package com.thoughtworks;

import lombok.NonNull;

import java.util.List;

public class InputValidator {
    public boolean validate(@NonNull List<Integer> inputNums) {

        return inputNums.size() == 4
                && inputNums.stream().distinct().count() == 4
                && inputNums.stream().noneMatch(num -> num > 9 || num < 0);
    }
}
