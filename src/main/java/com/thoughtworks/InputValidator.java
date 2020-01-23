package com.thoughtworks;

import lombok.NonNull;

import java.util.List;

public class InputValidator {
    public void validate(@NonNull List<Integer> inputNums) {
        if (inputNums.size() != 4
                || inputNums.stream().distinct().count() != 4
                || inputNums.stream().anyMatch(num -> num > 9 || num < 0)) {
            throw new InputErrorException();
        }
    }
}
