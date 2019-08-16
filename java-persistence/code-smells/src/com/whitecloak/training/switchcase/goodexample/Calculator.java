package com.whitecloak.training.switchcase.goodexample;

public class Calculator {

    public int calculate(String symbol, int a, int b) {
        Operator operator = Operator.fromSymbol(symbol);

        if (operator != null) {
            return operator.operate(a, b);
        } else {
            throw new IllegalArgumentException("Invalid symbol: " + symbol);
        }
    }
}
