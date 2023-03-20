package com.example.compteur_mvc_exemple;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo0_MVC extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ModelCompteur model = new ModelCompteur();			//Creation du modele

        VueGraphique vue = new VueGraphique(model);
        model.enregistrerObservateur(vue); //La vue s'enregistre comme vue du modele
        vue.setMinWidth(70);
        vue.setAlignment(Pos.CENTER);

        //ex1.1
        VueTexte vueT = new VueTexte(model);
        model.enregistrerObservateur(vueT);

        Controler control= new Controler(model);  //Creation du controleur - le modele en parametre

        VBox hb= new VBox(10);
        hb.setAlignment(Pos.CENTER);

        //ex1.2
        VueClics vueC = new VueClics(model);
        model.enregistrerObservateur(vueC);
        vueC.setMinWidth(70);
        vueC.setAlignment(Pos.CENTER);


        Button bplus 	= new Button("Plus");
        bplus.setMinWidth(120);
        bplus.setMinHeight(40);
        bplus.setOnAction (control);

        Button bmoins    = new Button("Moins");
        bmoins.setMinWidth(120);
        bmoins.setMinHeight(40);
        bmoins.setOnAction (control);

        hb.getChildren().addAll(vueC, bmoins, vue,bplus);

        Scene scene = new Scene(hb);
        stage.setTitle("MVC");
        stage.setScene(scene);
        stage.show();
    }

}
