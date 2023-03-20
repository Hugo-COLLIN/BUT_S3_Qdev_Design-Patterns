package fabrique;

/**
 * represente un vehicule
 */
public abstract class Vehicule {

	/**
	 * attribut vitesse
	 */
	private double vitesse;
	
	/**
	 * attribut vitessemax
	 */
	private double vitesseMax;
	
	/**
	 * le type de v�hicule
	 */
	private String type;
	
	
	/**
	 *
	 * @param vmax vitessemax
	 * @param typeVehicule
	 */
	protected Vehicule(double vmax, String typeVehicule)
	{
		this.vitesseMax=vmax;
		this.type=typeVehicule;
	}
	
	/**
	 * getter 
	 * @return vitesse
	 */
	public double getVitesse()
	{
		return(vitesse);
	}
	
	/**
	 * getter 
	 * @return type de v�hicule
	 */
	public String getType()
	{
		return(type);
	}
	
	public void accelerer(double deltaV)
	{
		this.vitesse+=deltaV;
		if (this.vitesse>this.vitesseMax)
		{
			this.vitesse=this.vitesseMax;
		}
	}
	
	public void decelerer(double deltaV)
	{
		this.vitesse-=deltaV;
		if (this.vitesse<0)
		{
			this.vitesse=0;
		}
	}
	
	
	/**
	 * si besoin, mais retir� du sujet
	 */
	public String toString()
	{
		return(type+" : v:"+vitesse);
	}
	
}
