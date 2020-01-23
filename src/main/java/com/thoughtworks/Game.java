package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private List<Integer> answer;
    private AnswerGenerator generator;
    private List<GuessHistory> guessHistories = new ArrayList<>();
    private GuessNumberInput guessNumberInput = new GuessNumberInput();
    private InputParser parser =  new InputParser();
    private InputValidator validator = new InputValidator();
    private GuessResultChecker checker = new GuessResultChecker();
    private GuessHistoryPrinter historyPrinter = new GuessHistoryPrinter(guessHistories);

    public Game(AnswerGenerator generator) {
        this.generator = generator;

    }

    public void start() {
        this.answer = this.generator.generate();
        int guessTimes = 6;
        IntStream.range(0, guessTimes).forEach(index -> {
            System.out.println("Please Input your guess numbers: ");

            String input = guessNumberInput.input();
            String output = checkInput(input);

            guessHistories.add(new GuessHistory(input, output));
            System.out.println(historyPrinter.getOutput());
            if ("4A0B".equals(output)) {
                System.out.println("Win!");
                return;
            }
        });

       System.out.println("Answer is: " + answer);
       System.out.println("Game Over!");
    }

    private String checkInput(String input) {
        List<Integer> inputNums;
        try {
            inputNums = parser.parse(input);
            validator.validate(inputNums);
        } catch (InputErrorException ignore) {
            return "Wrong Input, input again";
        }

        List<GuessResult> guessResults = IntStream.range(0, inputNums.size()).boxed()
                .map(index -> checker.check(answer, inputNums.get(index), index))
                .collect(Collectors.toList());
        GuessResultOutput guessResultOutput = new GuessResultOutput(guessResults);
        return guessResultOutput.getOutput();
    }
}
