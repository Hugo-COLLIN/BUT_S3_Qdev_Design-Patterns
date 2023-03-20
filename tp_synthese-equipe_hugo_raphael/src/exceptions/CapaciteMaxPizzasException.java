package exceptions;

public class CapaciteMaxPizzasException extends Exception
{
    public CapaciteMaxPizzasException(){
        super("Le nombre maximal de pizzas a été atteint");
    }
}