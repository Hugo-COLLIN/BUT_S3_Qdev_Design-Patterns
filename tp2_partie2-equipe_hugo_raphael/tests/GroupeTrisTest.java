import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe de test servant a tester les methodes de tri triAlpha et triAntialpha de la classe groupe
 * @author Raphael MANGIN
 */
public class GroupeTrisTest {

    /**
     * Attribut groupe correspondant au groupe par défaut sur lequel nous allons appliquer nos tests
     */
    private Groupe groupe_aleatoire, groupe_alpha, groupe_antialpha, groupe_merite, groupe_merite_pire;

    /**
     * Methode init permettant d'initialiser l'attribut groupe avant chaque test
     * @throws UnmodifiableFormationException lorsque que l'on essaie de modifier la formation alors qu'au moins un etudiant suit celle-ci
     * @throws NegativeCoeffException lorsque l'on essaie d'ajouter une matiere avec un coefficient negatif
     * @throws EtudiantFormationDifferentException lorsque l'etudiant que l'on veut ajouter au groupe suit une formation differente
     */
    @BeforeEach
    public void init() throws UnmodifiableFormationException, NegativeCoeffException, EtudiantFormationDifferentException, ValueOutOfBoundsException, MatiereInconnueException {
        // Création de la formation des etudiants du groupe
        Formation formation = new Formation("BUT Info");
        formation.ajouterMatiere("Qualite de developpement", 35.0f);
        formation.ajouterMatiere("Cryptographie", 5.0f);
        formation.ajouterMatiere("Anglais", 12.0f);

        // Création des identités des eleves du groupe
        Identite identite1 = new Identite("01", "Dupont", "Toto");
        Identite identite2 = new Identite("02", "Bertrand", "Tata");
        Identite identite3 = new Identite("03", "Zorah", "Magdaros");
        Identite identite4 = new Identite("04", "Rathian", "Rathalow");


        // Création des étudiants
        Etudiant etudiant1 = new Etudiant(identite1, formation);
        Etudiant etudiant2 = new Etudiant(identite2, formation);
        Etudiant etudiant3 = new Etudiant(identite3, formation);
        Etudiant etudiant4 = new Etudiant(identite4, formation);

        // Création des groupes
        // Groupe dans un ordre aleatoire
        groupe_aleatoire = new Groupe();
        groupe_aleatoire.ajouterEtudiant(etudiant1);
        groupe_aleatoire.ajouterEtudiant(etudiant2);
        groupe_aleatoire.ajouterEtudiant(etudiant3);
        groupe_aleatoire.ajouterEtudiant(etudiant4);

        // Groupe dans l'ordre alphabétique
        groupe_alpha = new Groupe();
        groupe_alpha.ajouterEtudiant(etudiant2);
        groupe_alpha.ajouterEtudiant(etudiant1);
        groupe_alpha.ajouterEtudiant(etudiant4);
        groupe_alpha.ajouterEtudiant(etudiant3);

        // Groupe dans l'ordre antialphabetique
        groupe_antialpha = new Groupe();
        groupe_antialpha.ajouterEtudiant(etudiant3);
        groupe_antialpha.ajouterEtudiant(etudiant4);
        groupe_antialpha.ajouterEtudiant(etudiant1);
        groupe_antialpha.ajouterEtudiant(etudiant2);

        // Groupe dans l'ordre par mérite
        groupe_merite = new Groupe();
        groupe_merite.ajouterEtudiant(etudiant2);
        groupe_merite.ajouterEtudiant(etudiant4);
        groupe_merite.ajouterEtudiant(etudiant3);
        groupe_merite.ajouterEtudiant(etudiant1);

        // Groupe merite pire des cas
        groupe_merite_pire = new Groupe();
        groupe_merite_pire.ajouterEtudiant(etudiant1);
        groupe_merite_pire.ajouterEtudiant(etudiant3);
        groupe_merite_pire.ajouterEtudiant(etudiant4);
        groupe_merite_pire.ajouterEtudiant(etudiant2);

        //Ajout de notes pour le tri par merite
        etudiant1.ajouterNote("Qualite de developpement", 8);
        etudiant2.ajouterNote("Qualite de developpement", 16);
        etudiant3.ajouterNote("Qualite de developpement", 13);
        etudiant4.ajouterNote("Qualite de developpement", 15);
    }

    /////// TESTS DE LA METHODE triAlpha ///////

    /**
     * Test de la methode triAlpha dans le cas ou le groupe est deja trie
     */
    @Test
    public void test_triAlpha_deja_trie(){
        assertEquals("Groupe{etudiants=[02, 01, 04, 03], formation=BUT Info}", groupe_alpha.toString(),
                "le groupe doit être trié avant d'utiliser la methode de tri");

        groupe_alpha.triAlpha();

        assertEquals("Groupe{etudiants=[02, 01, 04, 03], formation=BUT Info}", groupe_alpha.toString(),
                "le groupe doit toujours être trié apres l'utilisation la methode de tri");
    }

    /**
     * Test de la methode triAlpha dans un cas d'utilisation classique
     */
    @Test
    public void test_triAlpha_normal(){
        assertEquals("Groupe{etudiants=[01, 02, 03, 04], formation=BUT Info}", groupe_aleatoire.toString(),
                "Le groupe ne doit pas etre trie avant l'utilisation de la methode de tri");

        groupe_aleatoire.triAlpha();

        assertEquals("Groupe{etudiants=[02, 01, 04, 03], formation=BUT Info}", groupe_aleatoire.toString(),
                "le groupe doit toujours être trié apres l'utilisation la methode de tri");
    }

    /**
     * Test de la methode triAplha dans le pire des cas
     */
    @Test
    public void test_triAlpha_pire_des_cas(){
        assertEquals("Groupe{etudiants=[03, 04, 01, 02], formation=BUT Info}", groupe_antialpha.toString(),
                "Le groupe ne doit pas etre trie avant l'utilisation de la mehtode de tri");

        groupe_antialpha.triAlpha();

        assertEquals("Groupe{etudiants=[02, 01, 04, 03], formation=BUT Info}", groupe_antialpha.toString(),
                "le groupe doit toujours être trié apres l'utilisation la methode de tri");
    }

    /////// TESTS DE LA METHODE triAntiAlpha ///////

    /**
     * Test de la methode triAntiAlpha lorsque le groupe est deja trie
     */
    @Test
    public void test_triAntiAlpha_deja_trie(){
        assertEquals("Groupe{etudiants=[03, 04, 01, 02], formation=BUT Info}", groupe_antialpha.toString(),
                "Le groupe devrait être trié avant l'utilisation de la methode de tri");

        groupe_antialpha.triAntiAlpha();

        assertEquals("Groupe{etudiants=[03, 04, 01, 02], formation=BUT Info}", groupe_antialpha.toString(),
                "Le groupe devrait toujours être trié apres l'utilisation de la methode de tri");
    }

    /**
     * Test de la methode triAntiAlpha dans le cas d'une utilisation normale
     */
    @Test
    public void test_triAntiAlpha_normal(){
        assertEquals("Groupe{etudiants=[01, 02, 03, 04], formation=BUT Info}", groupe_aleatoire.toString(),
                "Le groupe ne doit pas etre trie avant l'utilisation de la methode de tri");

        groupe_aleatoire.triAntiAlpha();

        assertEquals("Groupe{etudiants=[03, 04, 01, 02], formation=BUT Info}", groupe_aleatoire.toString(),
                "Le groupe devrait etre trie apres l'utilisation de la methode de tri");
    }

    /**
     * Test de la methode triAntiAlpha dans le pire des cas
     */
    @Test
    public void test_triAntiAlpha_pire_des_cas(){
        assertEquals("Groupe{etudiants=[02, 01, 04, 03], formation=BUT Info}", groupe_alpha.toString(),
                "Le groupe ne devrait pas etre trie avant l'utilisation de la methode de tri");

        groupe_alpha.triAntiAlpha();

        assertEquals("Groupe{etudiants=[03, 04, 01, 02], formation=BUT Info}", groupe_alpha.toString(),
                "Le groupe devrait etre trie apres l'utilisation de la methode de tri");
    }

    /////// TESTS DE LA METHODE triParMerite ///////

    /**
     * Test de la methode triParMerite dans le cas ou le groupe est deja trie
     */
    @Test
    public void test_triParMerite_deja_trie() throws WithoutNoteException, MatiereInconnueException {
        assertEquals("Groupe{etudiants=[02, 04, 03, 01], formation=BUT Info}", groupe_merite.toString(),
                "le groupe doit être trié avant d'utiliser la methode de tri");

        groupe_merite.triParMerite();

        assertEquals("Groupe{etudiants=[02, 04, 03, 01], formation=BUT Info}", groupe_merite.toString(),
                "le groupe doit toujours être trié apres l'utilisation la methode de tri");
    }

    /**
     * Test de la methode triParMerite dans un cas d'utilisation classique
     */
    @Test
    public void test_triParMerite_normal() throws WithoutNoteException, MatiereInconnueException {
        assertEquals("Groupe{etudiants=[01, 02, 03, 04], formation=BUT Info}", groupe_aleatoire.toString(),
                "Le groupe ne doit pas etre trie avant l'utilisation de la methode de tri");

        groupe_aleatoire.triParMerite();

        assertEquals("Groupe{etudiants=[02, 04, 03, 01], formation=BUT Info}", groupe_aleatoire.toString(),
                "le groupe doit toujours être trié apres l'utilisation la methode de tri");
    }

    /**
     * Test de la methode triParMerite dans le pire des cas
     */
    @Test
    public void test_triParMerite_pire_des_cas() throws WithoutNoteException, MatiereInconnueException {
        assertEquals("Groupe{etudiants=[01, 03, 04, 02], formation=BUT Info}", groupe_merite_pire.toString(),
                "Le groupe ne doit pas etre trie avant l'utilisation de la mehtode de tri");

        groupe_merite_pire.triParMerite();

        assertEquals("Groupe{etudiants=[02, 04, 03, 01], formation=BUT Info}", groupe_merite_pire.toString(),
                "le groupe doit toujours être trié apres l'utilisation la methode de tri");
    }

}
