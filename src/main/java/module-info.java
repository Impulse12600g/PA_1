module edu.ucdenver.pa1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.ucdenver.pa1 to javafx.fxml;
    exports edu.ucdenver.pa1;
    exports edu.ucdenver;
    opens edu.ucdenver to javafx.fxml;
}