package station_meteo;

/**
 * Classe permettant l'affichage des previsions meteo en fonction des elements
 * fournis par la classe DonneesMeteo selon le patron Observateur
 *
 */
public class AffichagePrevisions implements Observateur {

	/**
	 * Pression courante fournie par DonneesMeteo
	 */
	private float pressionCourante = 1012;

	/**
	 * Avant derniere pression courante fournie par DonneesMeteo
	 */
	private float dernierePression;

	private DonneesMeteo donnees;

	/**
	 * Constructeur
	 * 
	 * @param objet de DonneesMeteo
	 */
	public AffichagePrevisions(DonneesMeteo donneesMeteo) {
		this.donnees = donneesMeteo;
		donneesMeteo.enregistrerObservateur(this); // enregistrement de l'instance courante comme Observateur de
													// DonneesMeteo
	}

	/**
	 * Actualise les attributs methode appelee par le sujet � chaque modification
	 * 
	 * @param temperature
	 * @param humidite
	 * @pression pression
	 */
	public void actualiser(Sujet s) {
		this.dernierePression = pressionCourante;
		this.pressionCourante = this.donnees.getPression();
		this.afficher();
	}

	/**
	 * Affichage specifique visualisant les previsions meteo
	 */
	public void afficher() {
		System.out.print("Prevision : ");
		if (this.pressionCourante > this.dernierePression) {
			System.out.println("Amelioration en cours !");
		} else if (this.pressionCourante == this.dernierePression) {
			System.out.println("Le temps se rafraichit");
		} else if (this.pressionCourante < this.dernierePression) {
			System.out.println("Depression bien installee");
		}
	}
}
