package com.thoughtworks;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnswerGenerator {

    public List<Integer> generate() {
        List<Integer> seeds = IntStream.range(0, 9).boxed().collect(Collectors.toList());
        Collections.shuffle(seeds);
        return seeds.subList(0, 4);
    }
}
