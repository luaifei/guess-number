package com.thoughtworks;

public class InputErrorException extends RuntimeException {
    public InputErrorException() {
        super("Wrong Input, input again");
    }
}
