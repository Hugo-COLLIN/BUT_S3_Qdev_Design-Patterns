package station_meteo;

/**
 * Classe permettant l'affichage des conditions meteo courantes fournies par la
 * classe DonneesMeteo selon le patron Observateur
 *
 */
public class AffichageConditions implements Observateur/*, Affichage*/ {

	/**
	 * donneesMeteo observee
	 */
	DonneesMeteo donnees;

	/**
	 * Constructeur
	 * 
	 * @param objet de Sujet
	 */
	public AffichageConditions(DonneesMeteo donneesMeteo) {
		this.donnees = donneesMeteo;
		donneesMeteo.enregistrerObservateur(this); // enregistrement de l'instance courante comme Observateur de Sujet
	}

	@Override
	public void actualiser(Sujet s) {
		System.out.println("\nConditions actuelles: " + this.donnees.getTemperature() + " degres C et "
				+ this.donnees.getHumidite() + "% d'humidite");
	}
}
