package vue;

import exceptions.NaturePizzaInvalideException;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import modele.ModeleCommande;
import modele.Pizza;
import modele.Sujet;

import java.util.List;

/**
 * Vue qui affiche le prix total de la commande
 */
public class VuePrix extends Label implements Observateur
{
    /**
     * Modele de commande
     */
    ModeleCommande model;

    /**
     * Constructeur qui parametre la vue
     * @param model Modele de commande
     */
    public VuePrix(ModeleCommande model) {
        super("Pas de commande en cours");
        this.model = model;
        this.model.enregistrerObservateur(this);

        this.setFont(new Font("Times", 16));
        this.setTextAlignment(TextAlignment.CENTER);

    }

    /**
     * Methode qui actualise l'affichage du prix de la commande
     * @param s Modele de commande
     */
    @Override
    public void actualiser(Sujet s) {
        this.setText("Prix de la commande : " + String.format("%.2f", this.model.getPrixCommande()) + "€");
    }
}
