package vue;

import controleurs.ControlPizzaCour;
import exceptions.NaturePizzaInvalideException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.*;

import java.util.List;


/**
 * Vue qui affiche visuellment les pizzas commandees
 * @author Hugo COLLIN
 */
public class VueCommIm extends GridPane implements Observateur
{
	/**
	 * Modele de commande
	 */
	ModeleCommande model;

	/**
	 * Rectangle designant la pizza actuellement selectionnee
	 */
	Rectangle rect;

	/**
	 * Constructeur qui parametre la vue
	 * @param model Modele de commande
	 */
	public VueCommIm(ModeleCommande model) {
		super();
		this.model = model;
		this.model.enregistrerObservateur(this);

		this.setPadding(new Insets(15));
		this.setHgap(25);
		this.setAlignment(Pos.CENTER);
		this.rect = new Rectangle(200,200, Color.rgb(255,255,255,0.2));
		this.setOnMouseClicked(new ControlPizzaCour(this.model));
	}

	/**
	 * Met a jout l'affichage des pizzas commandees selon les donnees du modele
	 * @param s Modele de commande
	 */
	@Override
	public void actualiser(Sujet s) {
		List<Pizza> listP = this.model.getListPizza();
		for (int i = 0 ; i < listP.size() ; i ++)
		{
			MyImage myIm;
			Pizza pizza = listP.get(i);

			try {
				if (pizza instanceof PizzaCreme) myIm = new MyImage("/fond_creme.png", null);
				else if (pizza instanceof PizzaTomate) myIm = new MyImage("/fond_tomate.png", null);
				else throw new NaturePizzaInvalideException();

				this.add(myIm.getSp(),i,1);

				if (this.model.getNumPizzaCourante() == i)
				{
					rect.setStroke(Color.BLACK);
					myIm.getSp().getChildren().add(rect);
				}
			}
			catch (NaturePizzaInvalideException e)
			{
				e.printStackTrace();
			}
		}
	}
}
