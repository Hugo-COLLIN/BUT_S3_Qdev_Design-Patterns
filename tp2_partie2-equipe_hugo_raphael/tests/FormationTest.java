import exceptions.MatiereInconnueException;
import exceptions.NegativeCoeffException;
import exceptions.UnmodifiableFormationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe Formation
 */
class FormationTest
{
    /**
     * Attribut formation utilise dans les tests
     */
    Formation f;

    /**
     * Initialise l'attribut Formation f avant chaque test
     */
    @BeforeEach
    void setUp()
    {
        f = new Formation("Noa");
    }

    /**
     * Teste que l'ajout de matiere dans une formation fonctionne
     */
    @Test
    void test_ajouterMatiere_ok() throws UnmodifiableFormationException, NegativeCoeffException {
        //Method
        f.ajouterMatiere("Mathématiques", 16);

        //Tests
        assertEquals(1, f.getMatieres().size(), "doit avoir une taille de 1");
        assertEquals(16, f.getMatieres().get("Mathématiques"), "coefficient doit etre 16");
    }

    /**
     * Teste que l'ajout d'une matiere avec le meme nom ne fonctionne pas
     */
    @Test
    void test_ajouterMatiere_matiereExiste() throws UnmodifiableFormationException, NegativeCoeffException {
        //Init
        f.ajouterMatiere("Mathématiques", 16);

        //Method
        f.ajouterMatiere("Mathématiques", 10);

        //Tests
        assertEquals(1, f.getMatieres().size(), "doit avoir une taille de 1");
        assertEquals(16, f.getMatieres().get("Mathématiques"), "coefficient doit etre 16");
    }

    /**
     * Teste que la suppression d'une matiere de la liste fonctionne
     */
    @Test
    void test_supprimerMatiere_matiereExiste() throws UnmodifiableFormationException, NegativeCoeffException {
        //Init
        f.ajouterMatiere("Mathématiques", 16);

        //Method
        f.supprimerMatiere("Mathématiques");

        //Tests
        assertEquals(0, f.getMatieres().size(), "doit avoir une taille de 0");
    }

    /**
     * Teste que rien ne se passe lorsqu'on tente de supprimer une matiere qui n'est pas dans la Formation
     */
    @Test
    void test_supprimerMatiere_matiereAbsente()
    {
        //Tests
        assertDoesNotThrow(() -> {
            f.supprimerMatiere("Mathématiques");
        });
        assertEquals(0, f.getMatieres().size(), "doit avoir une taille de 0");
    }

    /**
     * Teste que la methode getCoeff renvoie le coefficient de la matiere souhaitee
     * @throws MatiereInconnueException
     */
    @Test
    void test_getCoeff_ok() throws MatiereInconnueException, UnmodifiableFormationException, NegativeCoeffException {
        //Init
        f.ajouterMatiere("Mathématiques", 16);

        //Tests
        assertDoesNotThrow(() -> {
            f.getCoeff("Mathématiques");
        });

        assertEquals(16, f.getCoeff("Mathématiques"), "doit retourner 16");
    }

    /**
     * Teste que getMatieres renvoie bien la liste des matieres
     */
    @Test
    void test_getMatieres_ok() throws UnmodifiableFormationException, NegativeCoeffException {
        //Init
        Map<String, Float> map = new HashMap<>();
        map.put("Mathématiques", 16F);
        map.put("Anglais", 5F);

        f.ajouterMatiere("Mathématiques", 16F);
        f.ajouterMatiere("Anglais", 5F);
        Map<String, Float> res = f.getMatieres();

        //Tests
        assertEquals(map.keySet(), f.getMatieres().keySet(), "doivent avoir les memes clés");
        for (String matiere : map.keySet())
            assertEquals(f.getMatieres().get(matiere), map.get(matiere), "doivent avoir le meme coefficient");
    }
}