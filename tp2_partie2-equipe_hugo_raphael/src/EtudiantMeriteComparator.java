import exceptions.MatiereInconnueException;
import exceptions.WithoutNoteException;

import java.util.Comparator;

/**
 * Classe EtudiantMeriteComparator implementant Comparator de l'api java.util
 * Elle permet de comparer deux etudiants dans l'ordre alphabetique
 * @author Hugo COLLIN, Raphael MANGIN
 */
public class EtudiantMeriteComparator implements Comparator<Etudiant> {

    /**
     * Methode compare permettant de comparer deux etudiants a partir de leur nom dans l'ordre alphabetique
     * @param etudiant_1 le premier etudiant a comparer
     * @param etudiant_2 le second etudiant a comparer
     * @return -> un entier > 0 lorsque le premier etudiant est plus grand que le second etudiant
     *         -> un entier = 0 lorsque le premier etudiant et le second etudiant sont identiques
     *         -> un entier < 0 lorsque le premier etudiant est plus petit que le second etudiant
     */
    @Override
    public int compare(Etudiant etudiant_1, Etudiant etudiant_2) {
        float note_etudiant_1, note_etudiant_2;
        try {
            note_etudiant_1 = etudiant_1.moyenneGenerale();
            note_etudiant_2 = etudiant_2.moyenneGenerale();
        }
        catch (MatiereInconnueException | WithoutNoteException e) {
            throw new RuntimeException(e);
        }

        if (note_etudiant_1 < note_etudiant_2)
            return 1;
        else if (note_etudiant_1 > note_etudiant_2)
            return -1;
        return 0;
    }
}
