package com.thoughtworks;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerGeneratorTest {
    @Test
    public void should_return_list_with_four_different_numbers_and_range_0_to_9(){
        AnswerGenerator generator = new AnswerGenerator();
        List<Integer> answer = generator.generate();
        assertEquals(4, answer.size());
        Set<Integer> answerSet = new HashSet<>(answer);
        assertEquals(4, answerSet.size());
    }
}
