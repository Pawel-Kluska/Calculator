package Controlers;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {

    public void startGui(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BasicLayout.fxml"));
        Parent root = loader.load();
        BasicLayoutController controller = loader.getController();

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new KeyHandler(controller));


        scene.getStylesheets().add(getClass().getResource("StyleBasic.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
