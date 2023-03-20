package modele;

import vue.Observateur;

public interface Sujet {

    /**
     * Methode enregistrerObservateur
     * Cette methode ajoute un observateur a la liste des observateurs
     * @param observateur observateur a ajouter dans la liste
     */
    public void enregistrerObservateur(Observateur observateur);

    /**
     * Methode supprimerObservateur
     * Cette methode permet de supprimer un observateur de la liste des observateurs
     * @param observateur observateur a supprimer
     */
    public void supprimerObservateur(Observateur observateur);

    /**
     * Methode notifierObservateur
     * Cette methode permet de notifier les observateurs
     */
    public void notifierObservateurs();
}
