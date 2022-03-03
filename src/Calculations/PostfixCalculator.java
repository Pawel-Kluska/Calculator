package Calculations;

import java.util.Stack;

import static Calculations.InfixToPostfix.isOperator;


public class PostfixCalculator {


    public static double calculate(String postfixExpWithUnderscore) throws IllegalArgumentException{
        Stack<Double> operandStack = new Stack<>();

        boolean isUnderscore = false;
        StringBuilder numberString = new StringBuilder();

        for (int i=0; i<postfixExpWithUnderscore.length(); i++){
            if (postfixExpWithUnderscore.charAt(i)=='_') {
                isUnderscore = true;
                if (i> 0 && numberString.length()>0) operandStack.push(Double.parseDouble(numberString.toString()));
                numberString.delete(0, numberString.length());
                continue;
            }
            final boolean isOperator = isOperator(postfixExpWithUnderscore.charAt(i));
            if (isUnderscore){
                if (!isOperator) {
                    numberString.append(postfixExpWithUnderscore.charAt(i));
                    continue;
                } else {
                    operandStack.push(Double.parseDouble(numberString.toString()));
                    numberString.delete(0, numberString.length());
                    isUnderscore = false;
                }
            } if (isOperator) {
                final double res = evaluate(operandStack.pop(), operandStack.pop(), postfixExpWithUnderscore.charAt(i));
                operandStack.push(res);
            }
        }

        return operandStack.pop();
    }

    private static double evaluate(Double second, Double first, char operator) throws IllegalArgumentException {
        switch (operator){
            case '+':
                return first+second;
            case '-':
                return first-second;
            case '*':
                return first*second;
            case '/':
                return first/second;
            case '^':
                return Math.pow(first, second);
            default:
                throw new IllegalArgumentException("Operator not defined for " + operator);

        }
    }
}
