package com.thoughtworks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessResultCheckerTest {
    @Test
    void should_return_number_right_and_position_right_given_input_correct() {
        GuessResultChecker checker = new GuessResultChecker();
        GuessResult result = checker.check(Arrays.asList(1, 2, 3, 4), 1, 0);
        assertTrue(result.isNumberRight());
        assertTrue(result.isPositionRight());
    }
}
