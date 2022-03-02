package Controlers;

import Calculations.CalculateBasic;
import Calculations.OnpAlgorithm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class WriteModeController {

    private final static CalculateBasic cal = new CalculateBasic();

    @FXML
    private TextField field;
    @FXML
    private Button N0, N1, N2, N3, N4, N5, N6, N7, N8, N9;
    @FXML
    private Button O1, O2, O3, O4, O5, O6, O7;


    public void getNumber(ActionEvent e){
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

    public void getOperator(ActionEvent e){
        if(e.getSource() == O1) field.appendText("+");
        else if(e.getSource() == O2) field.appendText("-");
        else if(e.getSource() == O3) field.appendText("*");
        else if(e.getSource() == O4) field.appendText("/");
        else if(e.getSource() == O5) field.appendText("(");
        else if(e.getSource() == O6) field.appendText(")");
        else if(e.getSource() == O7) field.appendText("^");
    }

    public void evaluate() {
        Double result = OnpAlgorithm.count(field.getText());
        field.setText(""+result);
    }

    public void allClear() {
        field.setText("");
    }

    public void oneSignRemove() {
        String string = field.getText();
        StringBuilder sb= new StringBuilder(string);
        sb.deleteCharAt(sb.length()-1);
        field.setText(sb.toString());
    }

    public void addComma(){
        field.appendText(".");
    }

}
