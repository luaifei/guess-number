package com.thoughtworks;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessNumberInputTest {
    @Test
    public void should_return_input_guess_number() {
        GuessNumberInput numInput = new GuessNumberInput();

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in);

        String guessNumStr = numInput.input();

        System.setIn(sysInBackup);

        assertEquals("1 2 3 4", guessNumStr);
    }
}
