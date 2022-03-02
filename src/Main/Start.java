package Main;

import Controlers.BasicLayoutController;
import Controlers.KeyHandlerBasic;
import Controlers.WriteModeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {

    public void startGui(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/FXML/BasicLayout.fxml"));

        Parent root = loader.load();
        BasicLayoutController controller = loader.getController();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new KeyHandlerBasic(controller));

        scene.getStylesheets().add(getClass().getResource("../Resources/Styles/StyleBasic.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

}
