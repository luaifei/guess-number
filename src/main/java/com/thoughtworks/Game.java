package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private int guessTimes = 10;
    private List<Integer> answer;
    private List<GuessHistory> guessHistories = new ArrayList<>();
    private GuessNumberInput guessNumberInput = new GuessNumberInput();
    private InputParser parser =  new InputParser();
    private InputValidator validator = new InputValidator();
    private GuessResultChecker checker = new GuessResultChecker();
    private GuessHistoryPrinter historyPrinter = new GuessHistoryPrinter(guessHistories);

    public Game() {
        NumberGenerator generator = new NumberGenerator();
        this.answer = generator.generate();
    }

    public void guess() {
       for (int i = 0; i < guessTimes; i++) {
           System.out.println(historyPrinter.getOutput());
           System.out.println("Please Input your guess numbers: ");
           String input = guessNumberInput.input();
           String output = handleInput(input);
           if ("4A0B".equals(output)) {
               System.out.println("Win!");
               return;
           }
           guessHistories.add(new GuessHistory(input, output));
       }

       System.out.println(answer);
       System.out.println("Game Over");
    }

    private String handleInput(String input) {
        List<Integer> inputNums;
        try {
            inputNums = parser.parse(input);
        } catch (InputErrorException ignore) {
            return "Wrong Input, input again";
        }

        boolean validate = validator.validate(inputNums);
        if (! validate) {
            return "Wrong Input, input again";
        }

        List<GuessResult> guessResults = IntStream.range(0, inputNums.size()).boxed()
                .map(index -> checker.check(answer, inputNums.get(index), index))
                .collect(Collectors.toList());
        GuessResultOutput guessResultOutput = new GuessResultOutput(guessResults);
        return guessResultOutput.getOutput();
    }

    public static void main (String ... args) {
        Game game = new Game();
        game.guess();
    }
}
