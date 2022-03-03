package Controlers;

import Calculations.CalculateBasic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class BasicLayoutController extends ParentController {

    private final static CalculateBasic cal = new CalculateBasic();

    @FXML
    private TextField field;

    @FXML
    private Label operationImage, memorySign;

    private boolean isOperation = false;
    private boolean pipe = false;
    private boolean isComma = false;

    public boolean isOperation() {
        return isOperation;
    }

    public void setOperation(boolean operation) {
        isOperation = operation;
    }

    public TextField getField() {
        return field;
    }

    public void getNumber(ActionEvent e){
        if(field.getText().equals("0")) field.setText("");
        if(isOperation) field.setText(""); isOperation=false;
        printNumber(e);
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

        setNormalized(num);

        isOperation=true;
        pipe=false;

    }

    public void addComma() {
        if(!isComma && !isOperation) field.appendText(".");
        isComma = true;
    }

    public void allClear() {
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
    }

    public void oneDigitRemove() {
        String string = field.getText();
        StringBuilder sb= new StringBuilder(string);
        sb.deleteCharAt(sb.length()-1);
        if(sb.toString().equals("")) field.setText("0");
        else field.setText(sb.toString());
    }

    public void changeSign(){
        double number = Double.parseDouble(field.getText());
        number = cal.negate(number);

        setNormalized(number);
    }

    public void sqrt() {
        double number = Double.parseDouble(field.getText());
        number = cal.sqrt(number);
        setNormalized(number);
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

    public void changeSceneToWrite(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/FXML/WriteLayout.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Resources/Styles/StyleBasic.css").toExternalForm());
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
