package com.thoughtworks;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GuessHistory {
    private String guessInput;
    private String output;
}
