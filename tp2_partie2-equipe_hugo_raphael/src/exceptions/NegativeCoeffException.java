package exceptions;

/**
 * Classe d'exception lancee lorsque l'on tente d'ajouter une matiere dans une formation avec un coefficient negatif
 * @author Raphael MANGIN
 */
public class NegativeCoeffException extends Exception{
    /**
     * Constructeur par defaut avec le message "Le coefficient de la matiere ne peut pas etre inferieur a 1"
     */
    public NegativeCoeffException(){
        super("Le coefficient de la matiere ne peut pas etre inferieur a 1");
    }
}
