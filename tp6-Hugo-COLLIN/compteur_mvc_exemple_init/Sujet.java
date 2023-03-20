package com.example.qualite_devpt_javafx.tp6.compteur_mvc_exemple;

public interface Sujet {
	public void enregistrerObservateur(Observateur o);
	public void supprimerObservateur(Observateur o);
	public void notifierObservateurs();
}
