package vue;


import modele.Sujet;

/**
 * Interface Observateur sur laquelle se basent les vues
 * @author Hugo COLLIN, Raphael MANGIN
 */
public interface Observateur
{
    /**
     * Methode qui permet de modifier l'affichage a partir des donnees du modele
     * @param s Modele de commande
     */
    public void actualiser(Sujet s);
}
