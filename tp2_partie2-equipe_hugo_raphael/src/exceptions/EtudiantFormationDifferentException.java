package exceptions;

/**
 * Classe d'exception lancee lorsqu'un etudiant a une formation differente d'un autre
 * @author Hugo COLLIN
 */
public class EtudiantFormationDifferentException extends Exception
{
    /**
     * Constructeur avec un message par defaut
     */
    public EtudiantFormationDifferentException ()
    {
        super("L'étudiant a une formation differente des autres etudiants du groupe.");
    }

    /**
     * Constructeur avec un message specifique
     * @param message message specifique
     */
    public EtudiantFormationDifferentException (String message)
    {
        super(message);
    }
}
