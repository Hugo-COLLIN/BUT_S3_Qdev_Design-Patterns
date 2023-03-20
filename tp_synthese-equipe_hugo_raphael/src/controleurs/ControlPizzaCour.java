package controleurs;

import exceptions.NumPizzaInvalideException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modele.ModeleCommande;

/**
 * Controleur qui met a jour la pizza actuellement selectionnee (attribut numPizzaCourante) en fonction
 * de l'endroit ou l'utilisateur effectue un clic de souris
 * @author Hugo COLLIN
 */
public class ControlPizzaCour implements EventHandler<MouseEvent>
{
    /**
     * Modele de commande
     */
    private ModeleCommande model;

    /**
     * Constructeur avec parametres
     * @param m modele de commande
     */
    public ControlPizzaCour(ModeleCommande m)
    {
        this.model = m;
    }

    /**
     * Determine la pizza selectionnee par l'utilisateur, la modifie dans le modele (attribut numPizzaCourante)
     * et notifie les observteurs du changement dans le modele
     * @param mouseEvent Evenement de clic de souris sur la zone
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        if (this.model.getNbPizzas() != 0)
        {
            double gap = 260 * (ModeleCommande.MAX_PIZZA - this.model.getNbPizzas()) / 2.0;
            int numPizzaSelec = (int)Math.floor((mouseEvent.getScreenX() - gap) / 260) - 1;

            if (numPizzaSelec < 0) numPizzaSelec = 0;
            else if (numPizzaSelec >= this.model.getNbPizzas()) numPizzaSelec = this.model.getNbPizzas() - 1;

            try {
                this.model.setNumPizzaCourante(numPizzaSelec);
            } catch (NumPizzaInvalideException e) {
                e.printStackTrace();
            }

            this.model.notifierObservateurs();
        }
    }
}
