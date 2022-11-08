module edu.ucdenver.pa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.ucdenver.app to javafx.fxml;
    exports edu.ucdenver.app;

}