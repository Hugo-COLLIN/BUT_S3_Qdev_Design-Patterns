import exceptions.MatiereInconnueException;
import exceptions.WithoutNoteException;

/**
 * Interface Moyenne permettant d'implementer tout type de moyenne
 * @author Hugo COLLIN
 */
public interface Moyenne
{
    /**
     * Methode qui calcule une moyenne
     * @param e Etudiant
     * @param matiere matiere utilise selon le type de moyenne
     * @return moyenne souhaitee
     * @throws MatiereInconnueException
     * @throws WithoutNoteException
     */
    float calculMoyenne(Etudiant e, String matiere) throws MatiereInconnueException, WithoutNoteException;
}
