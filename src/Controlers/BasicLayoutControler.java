package Controlers;

import Calculations.Calculate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BasicLayoutControler {

    private final static Calculate cal = new Calculate();

    @FXML
    private TextField field;
    @FXML
    private Button N0, N1, N2, N3, N4, N5, N6, N7, N8, N9;
    @FXML
    private Label operationImage, memorySign;

    boolean isOperation = false;
    boolean pipe = false;
    boolean isComma = false;

    public void getNumber(ActionEvent e){
        if(field.getText().equals("0")) field.setText("");
        if(isOperation) field.setText(""); isOperation=false;
        if(e.getSource() == N1) field.appendText("1");
        else if(e.getSource() == N2) field.appendText("2");
        else if(e.getSource() == N3) field.appendText("3");
        else if(e.getSource() == N4) field.appendText("4");
        else if(e.getSource() == N5) field.appendText("5");
        else if(e.getSource() == N6) field.appendText("6");
        else if(e.getSource() == N7) field.appendText("7");
        else if(e.getSource() == N8) field.appendText("8");
        else if(e.getSource() == N9) field.appendText("9");
        else if(e.getSource() == N0) field.appendText("0");
    }

    private void setNumberCalculator() {
        if (pipe) {
            cal.setSecondNumber(Double.parseDouble(field.getText()));
            cal.setFirstNumber(cal.ev());
            if(cal.getFirstNumber() == (int) cal.getFirstNumber()) field.setText("" + (int) cal.getFirstNumber());
            else field.setText("" + cal.getFirstNumber());

        } else {
            if (field.getText().equals("")) cal.setFirstNumber(0);
            else cal.setFirstNumber(Double.parseDouble(field.getText()));
            pipe = true;
        }
        cal.setOperation('!');
    }

    public void add(){
        setNumberCalculator();
        cal.setOperation('+');
        isOperation=true;
        isComma = false;
        operationImage.setText("+");

    }

    public void sub() {
        setNumberCalculator();
        cal.setOperation('-');
        isOperation=true;
        isComma = false;
        operationImage.setText("-");
    }

    public void mul() {
        setNumberCalculator();
        cal.setOperation('X');
        isOperation=true;
        isComma = false;
        operationImage.setText("*");
    }


    public void div() {
        setNumberCalculator();
        cal.setOperation('/');
        isOperation=true;
        isComma = false;
        operationImage.setText("/");
    }

    public void evaluate() {
        cal.setSecondNumber(Double.parseDouble(field.getText()));

        double num = cal.ev();

        if(num == (int) num) {
            field.setText(""+((int) num));
            isComma = false;
        }
        else {
            field.setText("" + num);
            isComma = true;
        }

        isOperation=true;
        pipe=false;

    }

    public void comma() {
        if(!isComma) field.appendText(".");
        isComma = true;
    }

    public void aclear() {
        field.setText("0");
        cal.setFirstNumber(0);
        cal.setSecondNumber(0);
        operationImage.setText("");
        isOperation = false;
        pipe = false;
        isComma = false;
    }

    public void clear() {
        if(!isOperation) field.setText("0");
        operationImage.setText("");
    }

    public void oneDigitRemove() {
        String string = field.getText();
        StringBuilder sb= new StringBuilder(string);
        sb.deleteCharAt(sb.length()-1);
        field.setText(sb.toString());
    }

    public void changeSign(){
        double number = Double.parseDouble(field.getText());
        number = cal.negate(number);
        field.setText(""+number);
    }

    public void sqrt() {
        double number = Double.parseDouble(field.getText());
        number = cal.sqrt(number);
        field.setText(""+number);
    }

    //Memory

    public void addM(){
        double number = Double.parseDouble(field.getText());
        cal.addM(number);
        memorySign.setText("M");
    }

    public void subM(){
        double number = Double.parseDouble(field.getText());
        cal.subM(number);
        memorySign.setText("M");
    }

    public void readM(){
        double num = cal.getM();

        if(num == (int) num) {
            field.setText(""+((int) num));
            isComma = false;
        }
        else {
            field.setText("" + num);
            isComma = true;
        }
    }

    public void clearM() {
        cal.clearM();
        memorySign.setText("");
    }
}
