package com.example.compteur_mvc_exemple;

public interface Sujet {
	public void enregistrerObservateur(Observateur o);
	public void supprimerObservateur(Observateur o);
	public void notifierObservateurs();
}
