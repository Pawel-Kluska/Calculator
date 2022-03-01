package Controlers;

import Calculations.Calculate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BasicLayoutControler {

    private final static Calculate cal = new Calculate();

    @FXML
    private TextField field;
    @FXML
    private Button N1, N2, N3, N4, N5, N6, N7, N8, N9;
    boolean isOperation = false;
    boolean pipe = false;
    boolean isComma = false;

    public void getNumber(ActionEvent e){

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
    }

    public void add(ActionEvent e){
        if(pipe) {
            cal.setSecondNumber(Double.parseDouble(field.getText()));
            cal.setFirstNumber(cal.ev());
            field.setText("" + cal.getFirstNumber());
        }
        else {
            if (field.getText().equals("")) cal.setFirstNumber(0);
            else cal.setFirstNumber(Double.parseDouble(field.getText()));
            pipe = true;
        }
        cal.setOperation('+');
        isOperation=true;

    }

    public void sub(ActionEvent e) {
        if(pipe) {
            cal.setSecondNumber(Double.parseDouble(field.getText()));
            cal.setFirstNumber(cal.ev());
            field.setText("" + cal.getFirstNumber());
        }
        else {
            if (field.getText().equals("")) cal.setFirstNumber(0);
            else cal.setFirstNumber(Double.parseDouble(field.getText()));
            pipe = true;
        }
        cal.setOperation('-');
        isOperation=true;
    }

    public void mul(ActionEvent e) {
        if(pipe) {
            cal.setSecondNumber(Double.parseDouble(field.getText()));
            cal.setFirstNumber(cal.ev());
            field.setText("" + cal.getFirstNumber());
        }
        else {
            if (field.getText().equals("")) cal.setFirstNumber(0);
            else cal.setFirstNumber(Double.parseDouble(field.getText()));
            pipe = true;
        }
        cal.setOperation('X');
        isOperation=true;
    }


    public void div(ActionEvent e) {
        if(pipe) {
            cal.setSecondNumber(Double.parseDouble(field.getText()));
            cal.setFirstNumber(cal.ev());
            field.setText("" + cal.getFirstNumber());
        }
        else {
            if (field.getText().equals("")) cal.setFirstNumber(0);
            else cal.setFirstNumber(Double.parseDouble(field.getText()));
            pipe = true;
        }
        cal.setOperation('/');
        isOperation=true;
    }

    public void evaluate(ActionEvent e) {
        if (field.getText().equals("")) cal.setSecondNumber(0);
        else cal.setSecondNumber(Double.parseDouble(field.getText()));
        field.setText("" + cal.ev());
        isOperation=true;
        pipe=false;
    }

    public void comma(ActionEvent e) {
        if(!isComma) field.appendText(".");
        isComma = true;
    }

    public void aclear(ActionEvent e) {
        field.setText("");
        cal.setFirstNumber(0);
        cal.setSecondNumber(0);

        isOperation = false;
        pipe = false;
        isComma = false;
    }

    public void clear(ActionEvent e) {
        if(!isOperation) field.setText("");
    }

    public void oneDigitRemove(ActionEvent e) {
        String string = field.getText();
        StringBuffer sb= new StringBuffer(string);
        sb.deleteCharAt(sb.length()-1);
        field.setText(sb.toString());
    }

    public void changeSign(ActionEvent e){
        double number = Double.parseDouble(field.getText());
        number = cal.negate(number);
        field.setText(""+number);
    }

    public void sqrt(ActionEvent e) {
        double number = Double.parseDouble(field.getText());
        number = cal.sqrt(number);
        field.setText(""+number);
    }
}
