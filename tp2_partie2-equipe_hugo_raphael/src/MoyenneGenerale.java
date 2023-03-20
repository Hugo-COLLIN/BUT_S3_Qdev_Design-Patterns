import exceptions.MatiereInconnueException;
import exceptions.WithoutNoteException;

/**
 * Classe qui implement Moyenne et permet de faire une moyenne generale
 * @author Hugo COLLIN
 */
public class MoyenneGenerale implements Moyenne
{
    /**
     * Methode qui calcule une moyenne
     * @param e Etudiant
     * @param matiere matiere utilise selon le type de moyenne
     * @return moyenne souhaitee
     * @throws MatiereInconnueException
     * @throws WithoutNoteException
     */
    @Override
    public float calculMoyenne(Etudiant e, String matiere) throws MatiereInconnueException, WithoutNoteException {
        return e.moyenneGenerale();
    }
}
