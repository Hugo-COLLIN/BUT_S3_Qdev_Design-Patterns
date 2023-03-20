package com.example.exo2_MVC;

import com.example.exo2_MVC.model.ModeleDeListe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

//Traiter la chaine en appuyant sur Entrée
public class Controleur implements EventHandler<ActionEvent>
{
    ModeleDeListe model;

    public Controleur ()
    {
        this.model = m;
    }



    @Override
    public void handle(ActionEvent e)
    {
        TextField jt = (TextField) e.getSource();

        System.out.println("Source : " + e.getSource());

        model.ajouter(jt.getText());
        jt.setText();
    }
}
