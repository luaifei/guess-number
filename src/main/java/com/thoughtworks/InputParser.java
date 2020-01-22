package com.thoughtworks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String REGEX = "\\s+";

    public List<Integer> parse(String input) {
        String[] numStr = input.split(REGEX);

        List<Integer> inputNums;
        try {
            inputNums = Arrays.stream(numStr)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ignored) {
            throw new InputErrorException();
        }

        return inputNums;
    }
}
