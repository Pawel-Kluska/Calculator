package Controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class ParentController {

    @FXML
    protected TextField field;

    @FXML
    private Button N0, N1, N2, N3, N4, N5, N6, N7, N8, N9;

        public abstract void getNumber(ActionEvent e);

        public abstract void evaluate();

        public abstract void addComma();

        public abstract void allClear();

        public abstract void oneDigitRemove();

        public void setNormalized(double number){
            if(number == (int) number) {
                field.setText(""+((int) number));
            }
            else {
                field.setText("" + number);
            }
        }

        public void printNumber(ActionEvent e){
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





}
