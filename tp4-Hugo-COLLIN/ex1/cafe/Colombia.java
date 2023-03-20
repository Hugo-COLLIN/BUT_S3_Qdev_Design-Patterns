package ex1.cafe;

/**
 * Classe correspondant a une boisson Colombia
 * 
 */
public class Colombia extends Boisson {
	
	public Colombia(){
		description = " Colombia";
	}
	
	/**
	 * @return prix de la boisson
	 */
	@Override
	public double cout() {
		return 1.3;
	}

}
