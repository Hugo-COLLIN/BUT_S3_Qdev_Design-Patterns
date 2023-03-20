package tp1.src;

public class DeviseException extends Exception
{
    public DeviseException ()
    {
        super("Les montants sont de 2 devises différentes : impossible de les ajouter...");
    }
}
