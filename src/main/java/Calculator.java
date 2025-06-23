package main.java;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    static float finalResult;

    static class Operations {
        static final char ADDITION_SYMBOL = '+';
        static final char SUBTRACTION_SYMBOL = '-';
        static final char MULTIPLICATION_SYMBOL = '*';
        static final char DIVISION_SYMBOL = '/';

        private Operations() {
        }

        public static String ToString() {
            return "" + ADDITION_SYMBOL + MULTIPLICATION_SYMBOL + DIVISION_SYMBOL + SUBTRACTION_SYMBOL;
        }
    }

    public static String Run(String expression) {
        return evaluateExpression(expression);
    }

    private static String evaluateExpression(String expression) {
        if (expression.charAt(0) == Operations.ADDITION_SYMBOL || expression.charAt(0) == Operations.SUBTRACTION_SYMBOL) {
            expression = "0" + expression;
        }

        List<Float> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder numberBuffer = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Operations.ToString().indexOf(c) >= 0) {
                numbers.add(Float.parseFloat(numberBuffer.toString()));
                numberBuffer.setLength(0);
                operators.add(c);
            } else {
                numberBuffer.append(c);
            }
        }
        numbers.add(Float.parseFloat(numberBuffer.toString()));

        float result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            float next = numbers.get(i + 1);
            switch (operators.get(i)) {
                case Operations.ADDITION_SYMBOL:
                    result += next;
                    break;
                case Operations.SUBTRACTION_SYMBOL:
                    result -= next;
                    break;
                case Operations.MULTIPLICATION_SYMBOL:
                    result *= next;
                    break;
                case Operations.DIVISION_SYMBOL:
                    result /= next;
                    break;
            }
        }

        finalResult = result;
        return String.valueOf(result);
    }
}
