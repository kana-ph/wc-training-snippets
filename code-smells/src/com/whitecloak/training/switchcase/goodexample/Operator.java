package com.whitecloak.training.switchcase.goodexample;

import java.util.function.BinaryOperator;

public enum Operator {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b)
    ;

    private final String symbol;
    private final BinaryOperator<Integer> action;

    Operator(String symbol, BinaryOperator<Integer> action) {
        this.symbol = symbol;
        this.action = action;
    }

    public int operate(int a, int b) {
        return action.apply(a, b);
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        return null;
    }
}
