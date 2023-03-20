import exceptions.EtudiantFormationDifferentException;
import exceptions.EtudiantInconnuException;
import exceptions.MatiereInconnueException;
import exceptions.WithoutNoteException;

import java.util.*;

/**
 * Classe representant un groupe d'etudiants dans une meme formation
 * @author Hugo COLLIN
 */
public class Groupe
{
    /**
     * Objet de type MoyenneMatiere permettant de faire des moyennes par matiere
     */
    public static final Moyenne MATIERE = new MoyenneMatiere();

    /**
     * Objet de type MoyenneGenerale permettant de faire des moyennes generales
     */
    public static final Moyenne GENERAL = new MoyenneGenerale();

    /**
     * Liste des etudiants du groupe
     */
    private List<Etudiant> etudiants;

    /**
     * Formation a laquelle appartient les etudiants
     */
    private Formation formation;

    /**
     * Constructeur qui initialise la liste d'etudiants
     */
    public Groupe ()
    {
        this.etudiants = new ArrayList<Etudiant>();
    }

    /**
     * Methode qui permet d'ajouter un etudiant au groupe s'il a la meme formation que les autre etudiants du groupe
     * @param e Etudiant
     * @throws EtudiantFormationDifferentException
     */
    public void ajouterEtudiant (Etudiant e) throws EtudiantFormationDifferentException {
        Formation eFormation = e.getFormation();

        if (this.etudiants.isEmpty())
            this.formation = eFormation;

        if (this.formation.equals(eFormation))
            this.etudiants.add(e);
        else
            throw new EtudiantFormationDifferentException();
    }

    /**
     * Methode qui supprime un etudiant du groupe
     * @param e
     * @throws EtudiantInconnuException
     */
    public void supprimerEtudiant (Etudiant e) throws EtudiantInconnuException
    {
        if (!this.etudiants.removeIf(eG -> eG.equals(e)))
            throw new EtudiantInconnuException();
    }

    /**
     * Methode qui renvoie le nombre d'etudiants dans le groupe
     * @return taille de la liste etudiants
     */
    public int getNbEtudiants ()
    {
        return this.etudiants.size();
    }

    /**
     * Getter de etudiants
     * @return etudiants
     */
    protected List<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * Getter de formation
     * @return formation
     */
    protected Formation getFormation() {
        return formation;
    }

    /**
     * Methode qui renvoie la moyenne souhaitee
     * @param m type de moyenne effectuee
     * @param matiere matiere utilisee pour la moyenneMatiere
     * @return la moyenne
     * @throws MatiereInconnueException
     * @throws EtudiantInconnuException
     * @throws WithoutNoteException
     */
    public float moyenne (Moyenne m, String matiere) throws MatiereInconnueException, EtudiantInconnuException, WithoutNoteException {
        float res = 0;
        int count = 0;

        for (Etudiant e : this.etudiants)
        {
            res += m.calculMoyenne(e, matiere);
            count ++;
        }

        if (count == 0) throw new EtudiantInconnuException();
        return res / count;
    }

    /**
     * Methode qui retourne la moyenne generale
     * @return moyenne generale
     * @throws MatiereInconnueException
     * @throws WithoutNoteException
     * @throws EtudiantInconnuException
     */
    public float moyenneG() throws MatiereInconnueException, WithoutNoteException, EtudiantInconnuException {
        return this.moyenne(GENERAL, "");
    }

    /**
     * Methode triAlpha qui trie la liste d'etudiants en fonction de leurs noms dans l'ordre alphabetique
     */
    public void triAlpha(){
        this.etudiants.sort(new EtudiantAlphaComparator());
    }

    /**
     * Methode triAntiAlpha qui tri la liste d'etudiants en fonction de leurs noms dans l'ordre antialphabetique
     */
    public void triAntiAlpha(){
        this.etudiants.sort(new EtudiantAntiAlphaComparator());
    }

    public void triParMerite () throws WithoutNoteException, MatiereInconnueException {
        this.etudiants.sort(new EtudiantMeriteComparator());
    }

    /**
     * Methode toString qui renvoie l'affichage du groupe
     * @return la chaine de caractere correspondant a l'affichage du groupe
     */
    @Override
    public String toString() {
        return "Groupe{" +
                "etudiants=" + etudiants +
                ", formation=" + formation +
                '}';
    }
}
