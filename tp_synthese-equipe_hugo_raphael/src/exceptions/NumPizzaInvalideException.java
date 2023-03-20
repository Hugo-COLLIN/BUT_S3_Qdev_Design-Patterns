package exceptions;

public class NumPizzaInvalideException extends Exception{
    public NumPizzaInvalideException(){
        super("le numero de la pizza n'est pas valide");
    }
}
