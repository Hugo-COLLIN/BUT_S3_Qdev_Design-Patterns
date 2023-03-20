package exceptions;

/**
 * Classe d'exception lancee lorsqu'une matiere demandee n'existe pas dans une formation
 * @author Raphael MANGIN, Hugo COLLIN
 */
public class MatiereInconnueException extends Exception
{
    /**
     * Constructeur avec un message par defaut
     */
    public MatiereInconnueException(){
        super("La matière n'existe pas");
    }

    /**
     * Constructeur avec un message specifique
     * @param message message specifique
     */
    public MatiereInconnueException(String message){
        super(message);
    }
}
