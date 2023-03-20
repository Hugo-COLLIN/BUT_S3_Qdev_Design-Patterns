package exceptions;

/**
 * Classe d'exception lancee lorsqu'un etudiant ne fait pas partie du groupe
 * @author Hugo COLLIN
 */
public class EtudiantInconnuException extends Exception
{
    /**
     * Constructeur avec un message par defaut
     */
    public EtudiantInconnuException() {
        super("L'étudiant ne fait pas partie du groupe.");
    }

    /**
     * Constructeur avec un message specifique
     *
     * @param message message specifique
     */
    public EtudiantInconnuException(String message) {
        super(message);
    }
}