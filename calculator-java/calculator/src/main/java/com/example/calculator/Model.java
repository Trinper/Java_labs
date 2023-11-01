package com.example.calculator;
public class Model {
    public long calculation(long a, long b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> (b == 0 ? 0 : a / b);
            default -> 0;
        };

    }
}
