package com.thoughtworks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessResultOutputTest {
    GuessResult bothRight = new GuessResult(true, true);
    GuessResult onlyPositionRight = new GuessResult(true, false);
    GuessResult notRight = new GuessResult(false, false);

    @Test
    void should_return_4A0B_given_all_correct() {
        List<GuessResult> guessResults = Arrays.asList(bothRight, bothRight, bothRight, bothRight);
        GuessResultOutput summary = new GuessResultOutput(guessResults);
        String output = summary.getOutput();
        assertEquals("4A0B", output);
    }

    @Test
    void should_return_0A4B_given_all_only_number_right() {
        List<GuessResult> guessResults = Arrays.asList(onlyPositionRight, onlyPositionRight,
                onlyPositionRight, onlyPositionRight);
        GuessResultOutput summary = new GuessResultOutput(guessResults);
        String output = summary.getOutput();
        assertEquals("0A4B", output);
    }

    @Test
    void should_return_1A0B_given_only_one_guess_is_both_right() {
        List<GuessResult> guessResults = Arrays.asList(bothRight, notRight, notRight, notRight);
        GuessResultOutput summary = new GuessResultOutput(guessResults);
        String output = summary.getOutput();
        assertEquals("1A0B", output);
    }
}
