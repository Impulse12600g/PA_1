package edu.ucdenver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * <p>
 * HelloController class
 * </p>
 */
public class HelloController {

    /**
     * <p>
     * welcomeText label variable
     * </p>
     */
    @FXML
    private Label welcomeText;

    /**
     * <p>
     * onHelloButtonClick method to set the welcome text for the app
     * </p>
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to our PA1!");
    }
}