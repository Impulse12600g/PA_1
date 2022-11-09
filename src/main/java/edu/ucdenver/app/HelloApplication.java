package edu.ucdenver.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 720);
        stage.setTitle("World Cup!");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e-> {
            Platform.exit();
            System.exit(0);
        });

    }

    public static void main(String[] args) {
        launch();
    }
}