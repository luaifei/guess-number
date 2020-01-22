package com.thoughtworks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InputParserTest {
    @Test
    void should_return_list_with_four_number_given_all_numbers() {
        InputParser parser = new InputParser();
        List<Integer> inputNumbers = parser.parse("1 2 3 4");
        assertIterableEquals(inputNumbers, Arrays.asList(1, 2, 3, 4));
    }

    @Test
    void should_raise_input_error_exception_given_input_contains_not_number() {
        InputParser parser = new InputParser();
        assertThrows(InputErrorException.class, () -> parser.parse("1 2 3 一"));
    }
}
