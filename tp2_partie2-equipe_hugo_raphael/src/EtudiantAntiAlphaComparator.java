import java.util.Comparator;

/**
 * Classe EtudiantAntiAlphaComparator implementant l'interface Comparator de l'api java.util
 * Elle permet de comparer deux etudiants dans l'ordre antialphabetique
 * @author Raphael MANGIN
 */
public class EtudiantAntiAlphaComparator implements Comparator<Etudiant> {

    /**
     * Methode compare permettant de comparer deux etudiants a partir de leur nom dans l'ordre antialphabetique
     * @param etudiant_1 le premier etudiant a comparer
     * @param etudiant_2 le second etudiant a comparer
     * @return -> un entier > 0 lorsque le premier etudiant est plus grand que le second etudiant
     *         -> un entier = 0 lorsque le premier etudiant et le second etudiant sont identiques
     *         -> un entier < 0 lorsque le premier etudiant est plus petit que le second etudiant
     */
    @Override
    public int compare(Etudiant etudiant_1, Etudiant etudiant_2) {
        String nom_etudiant_1 = etudiant_1.getId().getNom();
        String nom_etudiant_2 = etudiant_2.getId().getNom();
        return (nom_etudiant_1.compareTo(nom_etudiant_2) * -1);
    }
}
