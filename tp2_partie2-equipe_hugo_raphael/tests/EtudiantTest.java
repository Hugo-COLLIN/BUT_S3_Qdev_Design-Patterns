import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe Etudiant
 * @author Raphael MANGIN
 */
class EtudiantTest {

    /**
     * Attribut identite_default utilise dans la creation d'un etudiant
     */
    private Identite identite_default;

    /**
     * Attribut formation_default utilise dans la creation d'un etudiant
     */
    private Formation formation_default;

    /**
     * Attribut etudiant_defautl utlise dans dans les tests
     */
    private Etudiant etudiant_default;

    /**
     * Initialise l'etudiant par defaut utilise dans les tests
     * @throws UnmodifiableFormationException
     */
    @BeforeEach
    public void init() throws UnmodifiableFormationException, NegativeCoeffException {
        identite_default = new Identite("01", "Dupont", "Toto");
        formation_default = new Formation("BUT Default");
        formation_default.ajouterMatiere("Info", 32.0f);
        formation_default.ajouterMatiere("Maths", 12.5f);
        formation_default.ajouterMatiere("Anglais", 5.0f);
        etudiant_default = new Etudiant(identite_default, formation_default);
    }

    /**
     * Teste l'ajout d'un note dans le cas d'utilisation sans probleme
     */
    @Test
    public void test_ajouterNote_OK() {
        try {

            assertEquals(0, etudiant_default.getResultats().get("Info").nbNotes(), "Il ne doit pas encore y avoir de notes pour la matiere info");

            etudiant_default.ajouterNote("Info", 15);

            assertEquals(1, etudiant_default.getResultats().get("Info").nbNotes(), "Il doit y avoir une note pour la matiere Info.");

        } catch (ValueOutOfBoundsException e) {
            System.err.println("La valeur doit etre correcte");;
        } catch (MatiereInconnueException e2){
            System.err.println("La matiere doit exister");
        }


    }

    /**
     * Teste l'ajout d'une note dans le cas ou la note n'est pas valide
     */
    @Test
    public void test_ajouterNote_note_invalide(){
        assertThrows(ValueOutOfBoundsException.class, () -> etudiant_default.ajouterNote("Info", -2),
                "La methode doit declencher une exception de type exceptions.ValueOutOfBoundsException, la valeur est trop petite.");

        assertThrows(ValueOutOfBoundsException.class, () -> etudiant_default.ajouterNote("Info", 25),
                "La methode doit declencher une exception de type exceptions.ValueOutOfBoundsException, la valeur est trop grande.");
    }


    /**
     * Teste l'ajout d'une note dans le cas ou la matiere est incorrecte
     */
    @Test
    public void test_ajouterNote_matiere_inexistante(){
        assertThrows(MatiereInconnueException.class, () -> etudiant_default.ajouterNote("kzdjvesfjvbs", 15),
                "La methode doit lever une exception de type exceptions.MatiereInconnueException, la matiere n'existe pas.");
    }


    /**
     * Teste le calcul de la moyenne d'une matiere dans le cas d'utilisation sans probleme
     */
    @Test
    public void test_moyenneMatiere_OK() {
        try {
            etudiant_default.ajouterNote("Info", 15);
            etudiant_default.ajouterNote("Info", 10);
            etudiant_default.ajouterNote("Maths", 17);

            double moyenne_info = etudiant_default.moyenneMatiere("Info");
            double moyenne_maths = etudiant_default.moyenneMatiere("Maths");

            assertEquals(12.5f, moyenne_info, "La moyenne en informatique doit etre de 12.5");
            assertEquals(17, moyenne_maths, "La moyenne en maths doit etre de 17");
        } catch (ValueOutOfBoundsException e) {
            System.err.println("La valeur doit etre correcte (comprise entre 0 et 20).");
        } catch (MatiereInconnueException e) {
            System.err.println("La matiere doit exister");
        } catch (WithoutNoteException e) {
            System.err.println("Impossible de faire une moyenne car il n'y a aucune note.");
        }


    }

    /**
     * Test du calcul de la moyenne d'une matiere dans le cas ou celle-ci ne possede pas de note
     */
    @Test
    public void test_moyenneMatiere_sans_note(){
        // Premiere version, avant l'ajout de l'exception exceptions.WithoutNoteException
        /**try {
            double moyenne = etudiant_default.moyenneMatiere("Info");
            assertEquals(0, moyenne, "La moyenne en info doit etre 0 car il n'y a pas note");
        }catch (exceptions.MatiereInconnueException e){
            System.out.println("La matiere doit exister");
        }*/

        // Deuxieme version avec l'exception exceptions.WithoutNoteException
        assertThrows(WithoutNoteException.class, () -> etudiant_default.moyenneMatiere("Info"),
                    "La méthode doit lever une exception de type exceptions.WithoutNoteException car la matière n'a pas de note");
    }

    /**
     * Test du calcul de la moyenne d'une matiere qui n'existe pas
     */
    @Test
    public void test_moyenneMatiere_matiere_inexistante(){
        assertThrows(MatiereInconnueException.class, () -> etudiant_default.moyenneMatiere("djfzdkjeb"),
                "La methode doit lever une exception de type exceptions.MatiereInconnueException car la matiere n'existe pas");
    }

    /**
     * Test du calcul de la moyenne générale dans le cas ou tout va bien
     */
    @Test
    public void test_moyenneGenerale_ok() {
        try{
            etudiant_default.ajouterNote("Info", 15);
            etudiant_default.ajouterNote("Info", 10);
            etudiant_default.ajouterNote("Maths", 17);

            float moyenne = etudiant_default.moyenneGenerale();
            moyenne = Math.round(moyenne * 100.0f) / 100.0f;
            //moyenne = Float.parseFloat(new DecimalFormat("###.##").format(moyenne));
            assertEquals(Math.round(612.5 / 44.5 * 100.0f) / 100.0f, moyenne);
        } catch (ValueOutOfBoundsException e) {
            System.err.println("La valeur doit etre correcte (comprise entre 0 et 20).");
        } catch (MatiereInconnueException e) {
            System.err.println("La matiere doit exister");
        } catch (WithoutNoteException e) {
            System.err.println("Impossible de faire une moyenne car il n'y a aucune note.");
        }
    }

    /**
     * Test du calcul de la moyenne générale dans le cas ou tout va bien
     */
    @Test
    public void test_moyenneGenerale_sansNote(){
        // Premiere version, avant l'ajout de l'exception exceptions.WithoutNoteException
        /**try{
            float moyenne = etudiant_default.moyenneGenerale();
            assertEquals(0, moyenne);
        } catch (exceptions.MatiereInconnueException e) {
            System.out.println("La matiere doit exister");
        }*/

        // Deuxieme version avec l'exception exceptions.WithoutNoteException
        assertThrows(WithoutNoteException.class, () -> etudiant_default.moyenneGenerale(),
                "La méthode doit lever une exception de type exceptions.WithoutNoteException car aucune des matieres ne possede de note");
    }

}