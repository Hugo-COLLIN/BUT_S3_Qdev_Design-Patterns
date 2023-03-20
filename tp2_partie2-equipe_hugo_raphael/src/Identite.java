/**
 * Classe representant l'identite d'un etudiant
 * @author Hugo COLLIN
 */
public class Identite
{
    /**
     * Attributs correspondant au numero d'identification, au nom, au prenom
     */
    private String nip, nom, prenom;

    /**
     * Constructeur a trois parametres
     * @param nip le numero d'identification
     * @param nom le nom
     * @param prenom le prenom
     */
    public Identite (String nip, String nom, String prenom)
    {
        this.nip = nip;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Getter de nom
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Methode permettant d'afficher l'identifiant de l'etudiant
     * @return chaine correspondant a l'affichage de l'etudiant
     */
    @Override
    public String toString() {
        return nip;
    }
}