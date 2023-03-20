package com.example.exo2_MVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class PrincipaleIG extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        TextField control, vMin,vMax;
        TextArea vListe;

        // Panel principal
        BorderPane bp= new BorderPane();
        bp.setPadding(new Insets(10));

        //Panel haut
        GridPane gpHaut = new GridPane();
        gpHaut.setPadding(new Insets(10));
        gpHaut.setHgap(25);
        gpHaut.setVgap(15);
        control= new TextField();
        gpHaut.add(new Label(" Donner une chaîne "),0,0,1,1);
        gpHaut.add(control, 1,0,1,1);

        bp.setTop(gpHaut); //place gpHaut en haut de l'IG

        // Panel au centre
        vListe = new TextArea();
        bp.setCenter(vListe);  //place vListe au centre de l'IG

        // Panel en bas
        GridPane gpBas = new GridPane();
        gpBas.setPadding(new Insets(10));
        gpBas.setHgap(25);
        gpBas.setVgap(15);
        vMin = new TextField();
        //vMin.setMaxWidth(225.0);
        vMax = new TextField();
        //vMax.setMaxWidth(225.0);
        gpBas.add(new Label("     Plus grand mot     "), 0,0,1,1);
        gpBas.add(vMax, 1,0,1,1);
        gpBas.add(new Label("     Plus petit mot     "),0,1,1,1);
        gpBas.add(vMin, 1,1,1,1);

        // gpBas.setGridLinesVisible(true);

        bp.setBottom(gpBas); //place gpBas en bas de l'IG

        Scene scene = new Scene(bp, 350, 350);
        stage.setScene(scene);
        stage.setTitle("MVC et observateur");
        stage.show();
    }
}
