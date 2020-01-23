package com.thoughtworks;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessHistoryPrinterTest {
    @Test
    void should_return_history_str() {
        GuessHistory guessHistory = new GuessHistory("1 2 3 4", "3A1B");
        GuessHistoryPrinter printer = new GuessHistoryPrinter(Collections.singletonList(guessHistory));
        String printerOutput = printer.getOutput();
        String lineSeparator = System.lineSeparator();
        assertEquals("Input\t\tOutput" + lineSeparator + "1 2 3 4\t\t3A1B" + lineSeparator, printerOutput);
    }
}
