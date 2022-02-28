package Controlers;

import Calculations.Calculate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BasicLayoutControler {

    private static Calculate cal = new Calculate();

    @FXML
    TextField field;
    @FXML
    Button N1, N2, N3, N4, N5, N6, N7, N8, N9;

    public void getNumber(ActionEvent e){
        if(e.getSource() == N1) field.appendText("1");
        if(e.getSource() == N2) field.appendText("2");
        if(e.getSource() == N3) field.appendText("3");
        if(e.getSource() == N4) field.appendText("4");
        if(e.getSource() == N5) field.appendText("5");
        if(e.getSource() == N6) field.appendText("6");
        if(e.getSource() == N7) field.appendText("7");
        if(e.getSource() == N8) field.appendText("8");
        if(e.getSource() == N9) field.appendText("9");
    }

}
