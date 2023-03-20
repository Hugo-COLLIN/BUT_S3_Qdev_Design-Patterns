package Application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.ModeleCommande;
import vue.VuePrincipale;

/**
 * Classe principale permettant de lancer l'application
 * @author Hugo COLLIN
 */
public class Principale_IGTP7 extends Application {

    /**
     * Methode main qui appelle la methode de lancement d'application
     * @param args arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Methode qui demarre l'application
     * @param stage element racine de l'affichage graphique
     */
    @Override
    public void start(Stage stage)
    {
        ModeleCommande model = new ModeleCommande();
        VuePrincipale vue = new VuePrincipale(model);

        Scene scene = new Scene(vue,935,670);
        stage.setTitle("Commande de pizzas");
        stage.setScene(scene);
        stage.show();
    }
}
