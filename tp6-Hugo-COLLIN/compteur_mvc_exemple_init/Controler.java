
package com.example.qualite_devpt_javafx.tp6.compteur_mvc_exemple;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Controleur du MVC - 
 * Apres un clic sur un des boutons 
 * le controleur demande au modele de
 * se modifier
 */
public class Controler implements EventHandler<ActionEvent> {
	/**
	 * Le modele est attribut du controleur
	 */
	private ModelCompteur model;

	/**
	 * Constructeur
	 * 
	 * @param m l'objet Model 
	 */
	public Controler(ModelCompteur m) {
		this.model=m;
	}

	/**
	 * Methode
	 * lancee quand un evenement a lieu sur un des 
	 * composants sous ecoute - ici les 2 boutons
	 * 
	 * @param e ActionEvent obtenu apres clic
	 * sur un des deux boutons
	 */
	public void handle (ActionEvent e) {
		Button b = (Button)e.getSource();
		if(b.getText().equals("Plus"))
			model.modifier(1);
		if(b.getText().equals("Moins"))
			model.modifier(-1);
	}
}
