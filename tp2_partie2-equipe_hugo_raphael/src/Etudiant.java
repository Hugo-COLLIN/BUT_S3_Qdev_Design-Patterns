import exceptions.MatiereInconnueException;
import exceptions.ValueOutOfBoundsException;
import exceptions.WithoutNoteException;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe representant un etudiant
 * @author Hugo COLLIN, Raphael Mangin
 */
public class Etudiant
{
    /**
     * Attribut id correspondant a l'identite de l'etudiant
     */
    private Identite id;

    /**
     * Attribut formation correspondant a la formation de l'etudiant
     */
    private Formation formation;

    /**
     * Attribut resultats correspondant aux notes obtenues par l'etudiant dans chaque matiere de sa formation
     */
    private Map<String, Notes> resultats;

    /**
     * Constructeur a deux parametres, une identite et une formation
     * @param i identite de l'etudiant
     * @param f formation de l'etudiant
     */
    public Etudiant (Identite i, Formation f)
    {
        this.id = i;
        this.formation = f;
        this.formation.setModifiable(false);
        this.resultats = new HashMap<String, Notes>();
        for (String nomMatiere : this.formation.getMatieres().keySet())
            this.resultats.put(nomMatiere, new Notes());

    }

    /**
     * Methode ajouterNote prenant en paramtre la matiere pour laquelle la note note a ete obtenue
     * @param matiere matiere dans laquelle on ajoute la note passee en parametre
     * @param note note a ajouter
     * @throws ValueOutOfBoundsException lorsque la note n'est pas valide
     * @throws MatiereInconnueException lorsque la matiere ne fait pas partie de la formation de l'etudiant
     */
    public void ajouterNote(String matiere, float note) throws ValueOutOfBoundsException, MatiereInconnueException {
        if (note < 0 || note > 20)
            throw new ValueOutOfBoundsException();

        //test si matiere est dans formation
        boolean trouve = false;
        for (String nomMatiere : this.formation.getMatieres().keySet())
            if (nomMatiere.equals(matiere)) {
                trouve = true;
                break;
            }
        if (!matiereInFormation(matiere))
            throw new MatiereInconnueException();

        this.resultats.get(matiere).addNote(note);
    }

    /**
     * Methode matiereInFormation qui permet de savoir si la matiere passee en parametre fait partie de la formation de l'etudiant
     * @param matiere la matiere dont on veut verifier la presence
     * @return true si la matiere fait partie de la formation de l'etudiant, false sinon
     */
    public boolean matiereInFormation (String matiere)
    {
        boolean trouve = false;
        for (String nomMatiere : this.formation.getMatieres().keySet())
            if (nomMatiere.equals(matiere)) {
                trouve = true;
                break;
            }
        return trouve;
    }

    /**
     * Methode moyenneMatiere qui permet de calculer la moyenne de l'etudiant pour la matiere passee en parametre
     * @param matiere matiere pour laquelle on veut connaitre la moyenne de l'etudiant
     * @return la moyenne de l'etudiant dans la matiere passee en parametre
     * @throws MatiereInconnueException lorsque la matiere passee en parametre ne fait pas partie de la formation de l'etudiant
     * @throws WithoutNoteException lorsque l'etudiant n'a pas de note dans la matiere passee en parametre
     */
    public float moyenneMatiere (String matiere) throws MatiereInconnueException, WithoutNoteException {
        if (!matiereInFormation(matiere))
            throw new MatiereInconnueException();

        if (this.resultats.get(matiere).nbNotes() == 0)
            throw new WithoutNoteException();

        return this.resultats.get(matiere).getMoyenne();
    }

    /**
     * getter du coefficient de la matiere passee en parametre
     * @param matiere matiere dont on veut connaitre le coefficient
     * @return le coefficient de la matiere passee en parametre
     * @throws MatiereInconnueException lorsque la matiere passee en parametre ne fait pas partie de la formation de l'etudiant
     */
    private float getCoeffM(String matiere) throws MatiereInconnueException {
        return this.formation.getCoeff(matiere);
    }

    /**
     * Methode moyenneGenerale permettant de calculer la moyenne generale de l'etudiant
     * @return la moyenne generale de l'etudiant
     * @throws MatiereInconnueException lorsque la matiere ne fait pas partie de la formation de l'etudiant (n'est pas cense pouvoir arrive)
     * @throws WithoutNoteException lorsque l'etudiant n'a de note dans aucune matiere
     */
    public float moyenneGenerale () throws MatiereInconnueException, WithoutNoteException {
        float res = 0;
        float coeff, nbCoeffs = 0;
        for (String matiere : resultats.keySet())
            if (this.resultats.get(matiere).nbNotes() > 0)
            {
                coeff = this.getCoeffM(matiere);
                nbCoeffs += coeff;
                res += this.moyenneMatiere(matiere) * coeff;
            }

        if (nbCoeffs == 0) throw new WithoutNoteException();
        return res / nbCoeffs;
    }

    /**
     * Getter de la formation de l'etudiant
     * @return la formation de l'etudiant
     */
    public Formation getFormation() {
        return formation;
    }

    /**
     * Getter de l'identite de l'etudiant
     * @return l'identite de l'etudiant
     */
    public Identite getId() {
        return id;
    }

    /**
     * Getter des resultats de l'etudiant
     * @return les resultats de l'etudiant dans chaque matiere de sa formation
     */
    public Map<String, Notes> getResultats() {
        return resultats;
    }

    /**
     * Methode toString permettant d'afficher l'identifiant d'un etudiant
     * @return une chaine correspondant a l'affichage
     */
    @Override
    public String toString() {
        return id.toString();
    }
}
