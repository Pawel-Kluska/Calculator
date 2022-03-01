package Calculations;

public class Calculate {

    private char operation;
    private double firstNumber;
    private double secondNumber;
    private double memory;

    public Calculate(){

    }

    public char getOperation() {
        return operation;
    }

    public double ev(){
        double val = 0;
        if(operation == '+') val = firstNumber + secondNumber;
        if(operation == '-') val = firstNumber - secondNumber;
        if(operation == 'X') val = firstNumber * secondNumber;
        if(operation == '/') val = firstNumber / secondNumber;
        firstNumber = 0;
        secondNumber = 0;
        return val;
    }

    public double negate(double d){
        return(-d);
    }

    public double sqrt(double d){
        return(Math.sqrt(d));
    }

    public double getM(){
        return memory;
    }

    public void addM(double m){
        memory+=m;
    }

    public void subM(double m){
        memory-=m;
    }

    public void clearM(){
        memory = 0;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }
}
