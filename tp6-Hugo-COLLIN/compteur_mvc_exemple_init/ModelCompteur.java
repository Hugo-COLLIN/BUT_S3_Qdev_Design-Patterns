
package com.example.qualite_devpt_javafx.tp6.compteur_mvc_exemple;
import java.util.ArrayList;

/**
 * Classe correspondant au modele de l'architecture MVC 
 * de l'exemple compteur_MVC
 *
 */
public class ModelCompteur implements Sujet {

	/**
	 * compteur 
	 */
	private int compteur;
	/**
	 * Liste des observateurs
	 */
	private ArrayList<Observateur> observateurs;

	/**
	 * Constructeur - met le compteur a 0
	 */
	public ModelCompteur(){
		this.observateurs = new ArrayList<Observateur> ();
		this.compteur=0;
	}
	
	/**
	 * modifie la valeur de compteur en fonction du parametre
	 * 
	 * @param incr entiere a ajouter au compteur
	 */
	public void modifier(int incr){

		this.compteur+=incr;
		notifierObservateurs();
	}

	/**
	 * @return the compteur
	 */
	public int getCompteur() {
		return compteur;
	}



	/**
	 * Ajoute un observateur a la liste
	 */
	public void enregistrerObservateur(Observateur o) {

		this.observateurs.add(o);
	}


	/**
	 * Supprime un observateur a la liste
	 */
	public void supprimerObservateur(Observateur o) {
		int i = this.observateurs.indexOf(o);
		if (i >= 0) {
			this.observateurs.remove(i);
		}
	}


	/**
	 * Informe tous les observateurs de la liste des
	 * modifications des mesures meteo en appelant leurs methodes actualiser
	 */
	public void notifierObservateurs() {
		for (int i = 0; i < this.observateurs.size(); i++) {
			Observateur observer = this.observateurs.get(i);
			observer.actualiser(this);
		}
	}
}
