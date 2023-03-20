package vue;

import controleurs.ControlDebutCommande;
import exceptions.NaturePizzaInvalideException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.ModeleCommande;

/**
 * Vue principale qui regroupe tous les elements de l'interface
 * @author Hugo COLLIN, Raphael MANGIN
 */
public class VuePrincipale extends BorderPane
{
    /**
     * Constructeur avec parametres qui cree la vue de l'application
     * @param model Modele de commande
     */
    public VuePrincipale(ModeleCommande model)
    {
        String [] ingredients={"Fromage","Champignons","Chorizo","Oeuf","Oignons","Olives noires","Olives vertes","Roquette"};
        // String[] fidelite = {"Nouveau client", "Cliente avec carte", "Client adhérent"};
        Button[] bIngr;
        this.setPadding(new Insets(10));


        // Panneau situe au nord de l'IG contenant les 2 boutons
        // permettant le choix de la base des pizzas et le niveau de fidelite du client
        HBox pnord = new HBox(20);
        pnord.setPadding(new Insets(10));
        pnord.setAlignment(Pos.CENTER);

        ComboBox<String> choixFidelite = new ComboBox<String>( );
        choixFidelite .getItems().add("Nouveau client");
        choixFidelite .getItems().add("Client adhérent");
        choixFidelite .getItems().add("Cliente avec carte");
        choixFidelite.setValue("Nouveau client");

        Button  addPizzaCreme= new Button(" Ajouter une pizza fond creme ");
        Button addPizzaTomate= new Button(" Ajouter une pizza fond tomate ");
        pnord.getChildren().addAll(choixFidelite, addPizzaCreme, addPizzaTomate);
        this.setTop(pnord); //place pnord en haut de l'IG

        //Controllers
        addPizzaTomate.setOnAction(new ControlDebutCommande(model, ModeleCommande.P_TOMATE));
        addPizzaCreme.setOnAction(new ControlDebutCommande(model, ModeleCommande.P_CREME));

        // Panneau au centre de l'IG contenant la vision du choix des pizzas
        // ainsi que les boutons pour ajouter des ingredients
        BorderPane pcentral= new BorderPane();
        pcentral.setMaxHeight(300);


        //--> Le panneau avec la vision des images des pizzas
        VueCommIm visionComm = new VueCommIm(model);
        pcentral.setCenter(visionComm);

        //--> Le panneau contenant les boutons des ingredrients
        GridPane pingr= new GridPane();
        pingr.setAlignment(Pos.CENTER);
        pingr.setHgap(10);
        bIngr= new Button[8];
        for(int i=0;i<ingredients.length;i++){
            bIngr[i]=new Button(ingredients[i]);
            bIngr[i].setMinSize(100,40);
            pingr.add(bIngr[i],i,0);
        }
        // pingr.setPreferredSize(new Dimension(935,50));
        pcentral.setBottom(pingr);
        this.setCenter(pcentral); //place pcentral au centre de l'IG

        // Panneau au sud de l'IG dans lequel se trouve l'affichage
        // du contenu de la commande et son prix
        BorderPane psud= new BorderPane();
        psud.setMinHeight(300);

        VueCommText commtxt = new VueCommText(model);
        psud.setCenter(commtxt);

        //Mettre un panneau VBox
        VBox vb= new VBox();
        vb.setAlignment(Pos.CENTER);
        VuePrix vueP = new VuePrix(model);

        vb.getChildren().add(vueP);
        psud.setBottom(vb);
        this.setBottom(psud);
    }
}
