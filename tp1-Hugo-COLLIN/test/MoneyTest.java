package tp1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp1.src.DeviseException;
import tp1.src.Money;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe Money
 */
class MoneyTest
{
    /**
     * Objet de type Money
     */
    Money m;

    /**
     * Affecte les valeurs initiales a m avant chaque test
     */
    @BeforeEach
    void beforeEach ()
    {
        m = new Money(100, "EUR");
    }

    /**
     * Teste que la methode add cumule bien la somme des 2 objets Money et retourne un nouvel objet Money.
     */
    @Test
    void test_add_ok() throws DeviseException
    {
        Money m2 = new Money(150, "EUR");
        Money res = m.add(m2);
        assertEquals(250, res.getMontant(), "doit valoir 250");
    }

    /**
     * Teste que la methode add renvoie une DeviseException lorsqu'on ajoute 2 somme de devises differentes.
     */
    @Test
    void test_add_devisesDifferentes() throws DeviseException
    {
        Money m2 = new Money(25, "USD");

        assertThrows(DeviseException.class, () -> {
            Money res = m.add(m2);
        });
    }

    /**
     * Teste que la methode equals renvoie true si tous les atributs des 2 objets sont egaux
     */
    @Test
    void test_equals()
    {
        Money m2 = new Money(100, "EUR");
        boolean res = m.equals(m2);
        assertTrue(res, "doit etre vrai");
    }
}