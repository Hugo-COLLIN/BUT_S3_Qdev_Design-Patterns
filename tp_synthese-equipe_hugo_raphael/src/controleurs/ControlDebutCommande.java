package controleurs;

import exceptions.CapaciteMaxPizzasException;
import exceptions.NaturePizzaInvalideException;
import exceptions.NumPizzaInvalideException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modele.ModeleCommande;

/**
 * Conroleur qui met a jour le modele en modifiant la liste des pizzas selon le bouton cliqué parl'utilisateur
 * @author Hugo COLLIN
 */
public class ControlDebutCommande implements EventHandler<ActionEvent>
{
    /**
     * Modele de commande
     */
    private ModeleCommande model;

    /**
     * Action effectuee par l'utilisateur
     */
    private String action;

    /**
     * Constructeur avec parametres
     * @param model modele de commande
     * @param action action effectuee
     */
    public ControlDebutCommande (ModeleCommande model, String action)
    {
        this.model = model;
        this.action = action;
    }

    /**
     * Ajoute la pizza du type correspondant a this.action et notifie les observteurs du changement dans le modele
     * @param actionEvent evenement du clic sur le bouton
     */
    @Override
    public void handle(ActionEvent actionEvent)
    {
        try {
            this.model.ajouterPizza(this.action);
        }
        catch (NaturePizzaInvalideException | CapaciteMaxPizzasException | NumPizzaInvalideException e) {
            e.printStackTrace();
        }

        this.model.notifierObservateurs();
    }
}
