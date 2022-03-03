package Calculations;

public class OnpAlgorithm {

    public static double count(String equation) throws IllegalArgumentException, UnsupportedOperationException{
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        String postfixExpWithUnderscore = infixToPostfix.convertToPostfix(equation);
        return PostfixCalculator.calculate(postfixExpWithUnderscore);
    }
}
