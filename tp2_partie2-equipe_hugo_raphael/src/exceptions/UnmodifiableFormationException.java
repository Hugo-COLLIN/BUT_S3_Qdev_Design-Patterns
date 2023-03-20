package exceptions;

/**
 * Classe d'exception lancee lorsqu'on tente de modifier une formation initialisée
 * @author Raphael MANGIN, Hugo COLLIN
 */
public class UnmodifiableFormationException extends Exception
{
    /**
     * Constructeur avec un message par defaut
     */
    public UnmodifiableFormationException(){
        super("La formation ne peut plus etre modifiee");
    }

    /**
     * Constructeur avec un message specifique
     * @param message message specifique
     */
    public UnmodifiableFormationException(String message)
    {
        super(message);
    }
}
