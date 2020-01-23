package com.thoughtworks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GuessNumberGameTest {
    @Test
    void should_return_win_and_end_game_when_guess_given_all_right() {
        AnswerGenerator generator = mock(AnswerGenerator.class);
        Game game = new Game(generator);
        GuessNumberInput input = spy(GuessNumberInput.class);
        when(input.input()).thenReturn("1 2 3 4");
    }
}
