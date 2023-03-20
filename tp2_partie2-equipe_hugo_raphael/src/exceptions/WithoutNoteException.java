package exceptions;

/**
 * Classe d'exception lancee lorsqu'il n'y a aucune note dans le calcul de la moyenne
 * @author Hugo COLLIN
 */
public class WithoutNoteException extends Exception
{
    /**
     * Constructeur avec un message par defaut
     */
    public WithoutNoteException(){
        super("Aucune note dans la moyenne.");
    }

    /**
     * Constructeur avec un message specifique
     * @param message message specifique
     */
    public WithoutNoteException(String message){
        super(message);
    }
}
