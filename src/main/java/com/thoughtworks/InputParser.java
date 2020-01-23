package com.thoughtworks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public List<Integer> parse(String input) {
        return Arrays.stream(input.split("\\s+"))
                .map(numStr -> {
                    try {
                        return Integer.valueOf(numStr);
                    } catch (NumberFormatException exception) {
                        throw new InputErrorException();
                    }
                }).collect(Collectors.toList());
    }
}
