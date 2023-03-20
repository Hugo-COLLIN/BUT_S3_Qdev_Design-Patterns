
import exceptions.MatiereInconnueException;
import exceptions.NegativeCoeffException;
import exceptions.UnmodifiableFormationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe representant une formation
 * @author Raphael Mangin
 */
public class Formation {
    /**
     * Identifiant de la formation
     */
    private String identifiant;

    /**
     * Ensemble qui associe un nom de matiere a son coefficient
     */
    private Map<String, Float> matieres;

    /**
     * Booleen decrivant si la formation est modifiable
     */
    private boolean modifiable;

    /**
     * Constructeur qui initialise les attributs
     * @param identifiant
     */
    public Formation(String identifiant){
        this.identifiant = identifiant;
        matieres = new HashMap<String, Float>();
        modifiable = true;
    }

    /**
     * Methode qui ajoute une matiere a une formation modifiable
     * @param nom nom de la matiere
     * @param coeff coefficient de la matiere
     * @throws UnmodifiableFormationException
     */
    public void ajouterMatiere(String nom, float coeff) throws UnmodifiableFormationException, NegativeCoeffException {
        if (coeff < 1) throw new NegativeCoeffException();
        if (modifiable) {
            Set<String> mat = matieres.keySet();
            if (!mat.contains(nom))
                matieres.put(nom, coeff);
        }
        else throw new UnmodifiableFormationException();
    }

    /**
     * Methode qui supprime une matiere de la formation
     * @param nom nom de la matiere a supprimer
     * @throws UnmodifiableFormationException
     */
    public void supprimerMatiere(String nom) throws UnmodifiableFormationException {
        if (modifiable) {
            Set<String> cle = matieres.keySet();
            if (cle.contains(nom))
                matieres.remove(nom);
        }else throw new UnmodifiableFormationException();
    }

    /**
     * Methode permettant d'obtenir le coefficient d'une matiere
     * @param matiere matiere dont on souhaite recuperer le coefficient
     * @return coefficient de la matiere
     * @throws MatiereInconnueException
     */
    public float getCoeff(String matiere) throws MatiereInconnueException {
        float coeff = 0;
        Set<String> mat = matieres.keySet();
        if (mat.contains(matiere))
            coeff = matieres.get(matiere);
        else
            throw new MatiereInconnueException("La matiere n'existe pas, impossible de recuperer son coefficient");
        return coeff;
    }

    /**
     * Getter de matieres
     * @return matieres
     */
    protected Map<String, Float> getMatieres() {
        return matieres;
    }

    /**
     * Setter de modifiable
     * @param modifiable etat de modifiabilite
     */
    protected void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

    /**
     * Methode toString permettant l'affichage de l'identifiant de la formation
     * @return une chaine correspondant a l'affichage de l'identifiant de la formation
     */
    @Override
    public String toString() {
        return identifiant;
    }
}
