package tp1.src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe MoneyList
 * @author Hugo COLLIN
 */
class MoneyListTest
{
    //Attributes
    /**
     * Objets Money
     */
    Money m, m2;

    /**
     * Objet MoneyList
     */
    MoneyList mL;

    /**
     * Liste de verification
     */
    List<Money> testList;

    //Methods
    /**
     * Initialisation avant chaque test
     */
    @BeforeEach
    void setUp()
    {
        m = new Money(50, "EUR");
        mL = new MoneyList();
        testList = new ArrayList<>();
    }

    /**
     * Teste que la methode ajouterSomme ajoute bien l'objet Money comme nouvel element de la liste lorsque la devise
     * ne correspond pas a une devise deja dans la liste
     */
    @Test
    void test_ajouterSomme_nouvelleDevise() throws DeviseException
    {
        //Init
        mL.ajouterSomme(m);
        m2 = new Money(100, "USD");
        testList.add(m);
        testList.add(m2);

        //purpose
        mL.ajouterSomme(m2);
        int res = mL.getList().size();

        //tests
        assertEquals(2, res, "doit avoir une taille de 2");
        assertEquals(testList, mL.getList(), "doivent etre egaux");
    }

    /**
     * Teste que la methode ajouterSomme ajoute bien la somme de l'objet Money a l'element Money de meme devise
     * deja existant dans la liste
     */
    @Test
    void test_ajouterSomme_ajoutMemeDevise() throws DeviseException
    {
        //Init
        mL.ajouterSomme(m);
        m2 = new Money(200, "EUR");
        testList.add(new Money(250, "EUR"));

        //purpose
        mL.ajouterSomme(m2);
        int res = mL.getList().size();
        Money elt = mL.getList().get(0);

        //tests
        assertEquals(1, res, "doit avoir une taille de 1");
        assertEquals(250, elt.getMontant(), "doit valoir 250");
        assertEquals(testList, mL.getList(), "doivent etre egaux");
    }

    /**
     * Teste que la methode triMontant trie la liste selon l'attribut montant de chaque objet Money de la liste
     * @throws DeviseException
     */
    @Test
    void test_triMontant_ok () throws DeviseException
    {
        //Init
        m2 = new Money(25, "USD");
        Money m3 = new Money(100, "CHF");
        mL.ajouterSomme(m);
        mL.ajouterSomme(m2);
        mL.ajouterSomme(m3);
        testList.add(m2);
        testList.add(m);
        testList.add(m3);

        //purpose
        mL.triMontant();

        //tests
        assertEquals(testList, mL.getList(), "les listes doivent etre identiques");
    }

    /**
     * Teste que la methode triMontant trie la liste selon l'attribut devise de chaque objet Money de la liste
     * @throws DeviseException
     */
    @Test
    void test_triDevise_ok () throws DeviseException
    {
        //Init
        m2 = new Money(25, "USD");
        Money m3 = new Money(100, "CHF");
        mL.ajouterSomme(m);
        mL.ajouterSomme(m2);
        mL.ajouterSomme(m3);
        testList.add(m3);
        testList.add(m);
        testList.add(m2);

        //purpose
        mL.triDevise();

        //tests
        assertEquals(testList, mL.getList(), "les listes doivent etre identiques");
    }
}