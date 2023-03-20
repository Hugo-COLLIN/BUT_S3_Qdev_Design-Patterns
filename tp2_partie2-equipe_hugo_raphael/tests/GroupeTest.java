import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe Groupe
 * @author Hugo COLLIN
 */
class GroupeTest
{
    /**
     * Attribut Groupe utilise dans chaque test
     */
    Groupe g;

    /**
     * Cree un nouveau Groupe avant chaque test
     */
    @BeforeEach
    void setUp()
    {
        g = new Groupe();
    }

    /**
     * Teste que l'ajout d'un Etudiant dans un Groupe vide fonctionne
     * @throws EtudiantFormationDifferentException
     */
    @Test
    void test_ajouterEtudiant_premier() throws EtudiantFormationDifferentException {
        //Init
        Formation fMaths = new Formation("L1 Mathématiques");
        Etudiant e1 = new Etudiant(new Identite("NIP1234", "MALTERS", "Guillaume"), fMaths);

        //Method
        g.ajouterEtudiant(e1);

        //Tests
        assertEquals(1, g.getNbEtudiants(), "doit contenir 1 objet de type etudiant");
    }

    /**
     * Teste que l'ajout d'un étudiant dans un groupe contenant deja des Etudiant de meme Formation fonctionne
     * @throws EtudiantFormationDifferentException
     */
    @Test
    void test_ajouterEtudiant_formationOk() throws EtudiantFormationDifferentException {
        //Init
        Formation but = new Formation("BUT Informatique");
        Etudiant e1 = new Etudiant(new Identite("NIP1234", "MALTERS", "Guillaume"), but);
        Etudiant e2 = new Etudiant(new Identite("NIP5678", "DJANGO", "Sam"), but);
        g.ajouterEtudiant(e1);

        //Method
        g.ajouterEtudiant(e2);

        //Tests
        assertEquals(2, g.getNbEtudiants(), "doit contenir 2 objets de type etudiant");

        for (Etudiant e : g.getEtudiants())
            assertEquals(but, e.getFormation(), "doit etre la meme formation");
    }

    /**
     * Teste que l'ajout d'un étudiant dans un groupe contenant des Etudiant d'une Formation differente ne fonctionne pas
     * @throws EtudiantFormationDifferentException
     */
    @Test
    void test_ajouterEtudiant_formationDifferent() throws EtudiantFormationDifferentException {
        //Init
        Formation fMaths = new Formation("L1 Mathématiques");
        Formation fAnglais = new Formation("L1 Anglais");
        Etudiant e1 = new Etudiant(new Identite("NIP1234", "MALTERS", "Guillaume"), fMaths);
        Etudiant e2 = new Etudiant(new Identite("NIP5678", "DJANGO", "Sam"), fMaths);
        Etudiant e3 = new Etudiant(new Identite("NIP9012", "MAYERS", "Sarah"), fAnglais);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);

        //Method and tests
        assertThrows(EtudiantFormationDifferentException.class, () -> {
            g.ajouterEtudiant(e3);
        });

        assertEquals(2, g.getNbEtudiants(), "doit contenir 2 objet de type etudiant");

        for (Etudiant e : g.getEtudiants())
            assertEquals(fMaths, e.getFormation(), "doit etre la meme formation");
    }

    /**
     * Teste que la suppression d'un etudiant dans la liste fonctionne
     * @throws EtudiantFormationDifferentException
     * @throws EtudiantInconnuException
     */
    @Test
    void test_supprimerEtudiant_present() throws EtudiantFormationDifferentException, EtudiantInconnuException {
        //Init
        Formation fMaths = new Formation("L1 Mathématiques");
        Etudiant e1 = new Etudiant(new Identite("NIP1234", "MALTERS", "Guillaume"), fMaths);
        Etudiant e2 = new Etudiant(new Identite("NIP5678", "DJANGO", "Sam"), fMaths);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);

        //Method and tests
        assertDoesNotThrow( () -> {
            g.supprimerEtudiant(e2);
        });

        assertEquals(1, g.getNbEtudiants(), "doit contenir 1 objet de type etudiant");
    }

    /**
     * Teste que la demande de suppression d'un etudiant qui n'est pas dans la liste ne change rien a la liste
     * @throws EtudiantFormationDifferentException
     * @throws EtudiantInconnuException
     */
    @Test
    void test_supprimerEtudiant_absent() throws EtudiantFormationDifferentException, EtudiantInconnuException {
        //Init
        Formation fMaths = new Formation("L1 Mathématiques");
        Formation fAnglais = new Formation("L1 Anglais");
        Etudiant e1 = new Etudiant(new Identite("NIP1234", "MALTERS", "Guillaume"), fMaths);
        Etudiant e2 = new Etudiant(new Identite("NIP5678", "DJANGO", "Sam"), fMaths);
        Etudiant e3 = new Etudiant(new Identite("NIP9012", "MAYERS", "Sarah"), fAnglais);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);

        //Method and tests
        assertThrows(EtudiantInconnuException.class, () -> {
            g.supprimerEtudiant(e3);
        });

        assertEquals(2, g.getNbEtudiants(), "doit contenir 2 objets de type etudiant");
    }


    /**
     * Teste que moyenne renvoie la moyenne pour une matiere correcte pour un groupe
     * @throws EtudiantFormationDifferentException
     * @throws ValueOutOfBoundsException
     * @throws MatiereInconnueException
     * @throws UnmodifiableFormationException
     * @throws WithoutNoteException
     * @throws EtudiantInconnuException
     * @throws NegativeCoeffException
     */
    @Test
    void test_moyMat_ok() throws EtudiantFormationDifferentException, ValueOutOfBoundsException, MatiereInconnueException, UnmodifiableFormationException, WithoutNoteException, EtudiantInconnuException, NegativeCoeffException {
        Formation fMaths = new Formation("L1 Mathématiques");
        fMaths.ajouterMatiere("Mathématiques avancées", 1);

        Etudiant e1 = new Etudiant(new Identite("NIP1234", "MALTERS", "Guillaume"), fMaths);
        Etudiant e2 = new Etudiant(new Identite("NIP5678", "DJANGO", "Sam"), fMaths);
        e1.ajouterNote("Mathématiques avancées", 15);
        e1.ajouterNote("Mathématiques avancées", 5);
        e2.ajouterNote("Mathématiques avancées", 10);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);

        float res = g.moyenne(Groupe.MATIERE, "Mathématiques avancées");
        //float res = g.moyMat("Mathématiques avancées");

        assertEquals(10, res, "moyenne doit etre de 10");
        
    }

    /**
     * Teste que la methode renvoie une exception lorsqu'il n'y a aucune note pour une matiere
     * @throws UnmodifiableFormationException
     * @throws ValueOutOfBoundsException
     * @throws MatiereInconnueException
     * @throws EtudiantFormationDifferentException
     */
    @Test
    void test_moyMat_sansNote() throws UnmodifiableFormationException, ValueOutOfBoundsException, MatiereInconnueException, EtudiantFormationDifferentException {
        assertThrows(EtudiantInconnuException.class, () -> {
            g.moyenne(Groupe.MATIERE, "Mathématiques avancées");
        });
    }

    /**
     *  Teste que moyenne renvoie la moyenne generale correcte pour un groupe
     * @throws EtudiantFormationDifferentException
     * @throws ValueOutOfBoundsException
     * @throws MatiereInconnueException
     * @throws UnmodifiableFormationException
     * @throws WithoutNoteException
     * @throws EtudiantInconnuException
     * @throws NegativeCoeffException
     */
    @Test
    void test_moyGen_ok() throws EtudiantFormationDifferentException, ValueOutOfBoundsException, MatiereInconnueException, UnmodifiableFormationException, WithoutNoteException, EtudiantInconnuException, NegativeCoeffException {
        Formation fMaths = new Formation("L1 Mathématiques");
        fMaths.ajouterMatiere("Mathématiques avancées", 1);
        fMaths.ajouterMatiere("Informatique", 1);

        Etudiant e1 = new Etudiant(new Identite("NIP1234", "MALTERS", "Guillaume"), fMaths);
        Etudiant e2 = new Etudiant(new Identite("NIP5678", "DJANGO", "Sam"), fMaths);
        e1.ajouterNote("Mathématiques avancées", 15);
        e1.ajouterNote("Mathématiques avancées", 5);
        e2.ajouterNote("Mathématiques avancées", 10);
        e2.ajouterNote("Informatique", 20);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);

        float res = g.moyenneG();

        assertEquals(12.5, res, "moyenne doit etre de 12.5");

    }

    /**
     * Teste que la methode renvoie une exception pour le tri Général lorsqu'il n'y a aucune note pour une matiere
     * @throws UnmodifiableFormationException
     * @throws ValueOutOfBoundsException
     * @throws MatiereInconnueException
     * @throws EtudiantFormationDifferentException
     */
    @Test
    void test_moyGen_sansNote() throws UnmodifiableFormationException, ValueOutOfBoundsException, MatiereInconnueException, EtudiantFormationDifferentException
    {
        assertThrows(EtudiantInconnuException.class, () -> {
            g.moyenneG();
        });
    }
}