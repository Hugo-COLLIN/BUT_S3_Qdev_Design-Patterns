package exceptions;

public class NaturePizzaInvalideException extends Exception
{
    public NaturePizzaInvalideException(){
        super("La nature de la pizza n'est pas valide : doit etre creme ou tomate");
    }
}