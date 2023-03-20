package exceptions;

/**
 * Classe d'exception lancee lorsqu'une valeur depasse les bornes demandees
 * @author Hugo COLLIN
 */
public class ValueOutOfBoundsException extends Exception
{
    /**
     * Constructeur avec un message par defaut
     */
    public ValueOutOfBoundsException ()
    {
        super("Valeur en-dehors des bornes.");
    }

    /**
     * Constructeur avec un message specifique
     * @param message message specifique
     */
    public ValueOutOfBoundsException (String message)
    {
        super(message);
    }
}
