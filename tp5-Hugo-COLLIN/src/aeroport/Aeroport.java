package aeroport;

public class Aeroport
{
    private boolean piste_libre;

    private static Aeroport aeroport;

    private Aeroport() //Controler qu'on a 1 seule instance
    {
        this.piste_libre = true;
    }

    public synchronized static Aeroport getAeroport()
    {
        if (aeroport == null)
        {
            try
            {
                Thread.sleep(500); //Attente avant creation
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            aeroport = new Aeroport();
        }
        return aeroport;
    }

    public synchronized boolean autoriserADecoller()
    {
        if (!piste_libre)
            return false;
        else
        {
            piste_libre = false;
            return true;
        }
    }

    public synchronized boolean liberer_piste() //Meth ne doit s'executer que par 1 seul thread
    {
        if (!piste_libre) piste_libre = true;
        else
        {
            System.out.println("Problem");
            return false;
        }
        return true;
    }


}
