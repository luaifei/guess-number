package com.thoughtworks;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GuessResult {
    private boolean numberRight;
    private boolean positionRight;
}
