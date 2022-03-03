package Controlers;

import Calculations.OnpAlgorithm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class WriteModeController extends ParentController{

    @FXML
    private TextField field;

    @FXML
    private Button O1, O2, O3, O4, O5, O6, O7;

    boolean isEvaluated=false;


    public void getNumber(ActionEvent e){
        if(isEvaluated) field.setText(""); isEvaluated=false;
        printNumber(e);
    }

    public void getOperator(ActionEvent e){
        if(isEvaluated) field.setText(""); isEvaluated=false;
        if(e.getSource() == O1) field.appendText("+");
        else if(e.getSource() == O2) field.appendText("-");
        else if(e.getSource() == O3) field.appendText("*");
        else if(e.getSource() == O4) field.appendText("/");
        else if(e.getSource() == O5) field.appendText("(");
        else if(e.getSource() == O6) field.appendText(")");
        else if(e.getSource() == O7) field.appendText("^");
    }

    public void evaluate() {
        try {
            double result = OnpAlgorithm.count(field.getText());
            setNormalized(result);
        }catch (IllegalArgumentException | UnsupportedOperationException u){
            field.setText("Syntax Error");
        }
        catch (Exception e){
            field.setText("Unknown Error");
        }
        finally {
            isEvaluated=true;
        }

    }

    public void allClear() {
        field.setText("");
    }

    public void oneDigitRemove() {
        String string = field.getText();
        StringBuilder sb= new StringBuilder(string);
        sb.deleteCharAt(sb.length()-1);
        field.setText(sb.toString());
    }

    public void addComma(){
        field.appendText(".");
    }

    public void changeSceneToBasic(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/FXML/BasicLayout.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Resources/Styles/StyleBasic.css").toExternalForm());
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

}
