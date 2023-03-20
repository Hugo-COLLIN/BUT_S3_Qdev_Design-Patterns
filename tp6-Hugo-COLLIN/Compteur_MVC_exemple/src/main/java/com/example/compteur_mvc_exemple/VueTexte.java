
package com.example.compteur_mvc_exemple;


import javafx.scene.control.Label;

/**
 * Une Vue du MVC - correspond au JLabel contenant la valeur du compteur
 *
 */
public class VueTexte implements Observateur{
	private ModelCompteur mod;
	/**
	 * Constructeur - positionne la valeur 0 au centre du JLabel
	 */
	public VueTexte(ModelCompteur m) {
		this.mod=m;
	}

	/**
	 * Actualisation du Label avec la nouvelle valeur du compteur obtenue grace au modele mod
	 * Methode lancee a chaque modification du modele
	 */
	public void actualiser(Sujet s) {
		System.out.println("Compteur : "+ ((ModelCompteur)s).getCompteur() + "\t Nb clics : " + ((ModelCompteur) s).getNbClics());
	}
}
