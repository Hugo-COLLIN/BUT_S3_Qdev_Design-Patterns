package ex1.cafe;

/**
 * Classe permettant l'ajout de chantilly à une boisson 
 */
public class BoissonChocolat extends DecorateurIngredient {

	/**
	 * Constructeur
	 *
	 *  @param boisson à décorer
	 */
	public BoissonChocolat(Boisson boisson) {
		super(0.5, " Chocolat", boisson);
	}
	
	
}
