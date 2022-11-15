package edu.ucdenver.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <p>
 * HelloApplication driver for the app.
 * This class holds and sets up the fxml for the app.
 * </p>
 */
public class HelloApplication extends Application {

    /**
     * <p>
     * start method to run the application
     * </p>
     * @param stage parameter sent to this method to set up the title and scene
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 500);
        stage.setTitle("World Cup!");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e-> {
            Platform.exit();
            System.exit(0);
        });

    }

    /**
     * <p>
     * main method of the program. Will just launch the application and start running everything
     * </p>
     * @param args takes in any arguments if needed
     */
    public static void main(String[] args) {
        launch();
    }
}