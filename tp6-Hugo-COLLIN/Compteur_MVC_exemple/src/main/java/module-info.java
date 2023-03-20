module com.example.compteur_mvc_exemple {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.compteur_mvc_exemple to javafx.fxml;
    exports com.example.compteur_mvc_exemple;
}