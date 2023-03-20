package station_meteo;

/**
 * Classe permettant l'affichage de statistiques meteo en fonction des elements
 * fournis par la classe DonneesMeteo selon le patron Observateur
 *
 */
public class AffichageStats implements Observateur {

	/**
	 * Temperature maximale
	 */
	private float tempMax = 0.0f;

	/**
	 * Temperature minimale
	 */
	private float tempMin = 200;

	/**
	 * Somme des temperature
	 */
	private float somTemp = 0.0f;

	/**
	 * Nombre des valeurs lues
	 */
	private int nbLectures;

	/**
	 * Nombre des valeurs lues
	 */
	DonneesMeteo donnees;

	/**
	 * Constructeur
	 * 
	 * @param objet de DonneesMeteo
	 */
	public AffichageStats(DonneesMeteo donneesMeteo) {
		this.donnees = donneesMeteo;
		donneesMeteo.enregistrerObservateur(this); // enregistrement de l'instance courante comme Observateur de
													// DonneesMeteo
	}

	/**
	 * Mise a jour des attributs en fonction des parametres transmis par
	 * DonneesMeteo
	 */
	public void actualiser(Sujet s) {
		float temp = this.donnees.getTemperature();
		this.somTemp += temp;
		this.nbLectures++;

		if (temp > this.tempMax) {
			this.tempMax = temp;
		}

		if (temp < this.tempMin) {
			this.tempMin = temp;
		}

		this.afficher();
	}

	/**
	 * Affichage specifique visualisant les statistiques meteo sur plusieurs
	 * lectures
	 */
	public void afficher() {
		System.out.println("Nbre de lectures : " + this.nbLectures + " Temperature Moy/Max/Min = "
				+ (this.somTemp / this.nbLectures) + "/" + this.tempMax + "/" + this.tempMin);
	}
}
