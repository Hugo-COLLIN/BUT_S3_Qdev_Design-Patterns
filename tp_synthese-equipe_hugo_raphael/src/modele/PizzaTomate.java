package modele;

import javafx.scene.layout.StackPane;
import vue.MyImage;

public class PizzaTomate implements Pizza{

    // Attributs
    /**
     * prix de la pizza
     */
    private double prix;
    /**
     * chemin de l'image de la pizza
     */
    private String nomIm;
    /**
     * description de la pizza
     */
    private String description;

    //Construceur

    /**
     * Constructeur par défaut
     * Construit une pizza base tomate
     */
    public PizzaTomate(){
        prix = 5.0;
        nomIm = "/fond_tomate.png";
        description = "Pizza base tomate";
    }

    @Override
    /**
     * Methode getPizzaIm()
     * @return l'image correspondant a la pizza
     */
    public MyImage getPizzaIm() {
        return new MyImage(nomIm, new StackPane());
    }

    @Override
    /**
     * Methode cout()
     * @return le cout de la pizza
     */
    public double cout() {
        return prix;
    }

    @Override
    /**
     * Methode getDescription()
     * @return la description de la pizza
     */
    public String getDescription() {
        return description;
    }
}
