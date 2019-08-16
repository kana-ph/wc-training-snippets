package com.whitecloak.training.switchcase.badexample;

public class Calculator {

    public int calculate(String symbol, int a, int b) {
        switch (symbol) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid symbol: " + symbol);
        }
    }
}
