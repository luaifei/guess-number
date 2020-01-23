package com.thoughtworks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {
    @Test
    public void should_return_true_given_input_four_different_number_and_range_from_0_to_9() {
        InputValidator validator = new InputValidator();
        assertDoesNotThrow(() -> validator.validate(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void should_return_false_given_input_four_numbers_but_some_numbers_are_same() {
        InputValidator validator = new InputValidator();
        assertThrows(InputErrorException.class, () -> validator.validate(Arrays.asList(1, 1, 3, 4)));
    }

    @Test
    void should_return_false_given_input_less_than_four_numbers() {
        InputValidator validator = new InputValidator();
        assertThrows(InputErrorException.class, () -> validator.validate(Arrays.asList(1, 1)));
    }

    @Test
    void should_return_false_given_input_four_numbers_but_out_of_range_0_to_9() {
        InputValidator validator = new InputValidator();
        assertThrows(InputErrorException.class, () -> validator.validate(Arrays.asList(1, 10, 3, 4)));
    }
}
