package com.thoughtworks;

import java.util.Scanner;

public class GuessNumberInput {
    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
