module com.example.exo2_MVC {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.example.exo2_MVC to javafx.fxml;
    exports com.example.exo2_MVC;
    exports com.example.exo2_MVC.model;
    opens com.example.exo2_MVC.model to javafx.fxml;
}