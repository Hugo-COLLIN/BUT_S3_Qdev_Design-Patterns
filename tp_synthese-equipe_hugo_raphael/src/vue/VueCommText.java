package vue;

import exceptions.NaturePizzaInvalideException;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import modele.*;

import java.util.List;

/**
 * Vue de la liste des pizzas commandees
 * @author Hugo COLLIN
 */
public class VueCommText extends Label implements Observateur
{
    /**
     * Modele de commande
     */
    ModeleCommande model;

    /**
     * Constructeur qui parametre la vue
     * @param model Modele de commande
     */
    public VueCommText (ModeleCommande model) {
        super("Aucune commande en cours");
        this.model = model;
        this.model.enregistrerObservateur(this);

        this.setFont(new Font("Times", 14));
    }

    /**
     * Methode qui met a jour la liste des pizzas commandees a partir du modele
     * @param s Modele de commande
     */
    @Override
    public void actualiser(Sujet s) {
        List<Pizza> listP = this.model.getListPizza();
        StringBuilder affichage = new StringBuilder("\tCommande :\n");
        for (Pizza pizza : listP) {
            //Afficher le prix
            affichage.append(String.format("%.2f", pizza.cout())).append("€\t");
            //Afficher la description de la pizza
            affichage.append(pizza.getDescription()).append("\n");
            //Rendre l'affichage
            this.setText(affichage.toString());
        }
    }
}
