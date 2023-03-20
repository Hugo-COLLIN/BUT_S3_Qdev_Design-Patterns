import java.util.ArrayList;
import java.util.List;

/**
 * Classe representant les notes d'un etudiant
 * @author Hugo COLLIN
 */
public class Notes
{
    /**
     * Moyenne des notes
     */
    private float moyenne;

    /**
     * Ensemble des notes de l'etudiant
     */
    private List<Float> listNotes;

    /**
     * Constructeur vide qui initialise moyenne et listNotes
     */
    public Notes ()
    {
        this.moyenne = 0;
        this.listNotes = new ArrayList<>();
    }

    /**
     * Getter de moyenne
     * @return moyenne
     */
    public float getMoyenne() {
        return moyenne;
    }

    /**
     * Methode permettant d'ajouter une note et de recalculer la moyenne
     * @param note note a ajouter
     */
    public void addNote (float note)
    {
        this.listNotes.add(note);
        this.calculerMoyenne();
    }

    /**
     * Methode qui calcule la moyenne des notes dans la liste listNotes
     */
    public void calculerMoyenne ()
    {
        float res = 0;
        for (float f : listNotes)
            res += f;
        res /= listNotes.size();
        this.moyenne = res;
    }

    /**
     * Affiche le nombre de notes dans la liste
     * @return taille de listNotes
     */
    public int nbNotes ()
    {
        return this.listNotes.size();
    }
}
