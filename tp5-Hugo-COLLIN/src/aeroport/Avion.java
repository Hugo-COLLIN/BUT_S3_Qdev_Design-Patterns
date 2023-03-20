package aeroport;

public class Avion extends Thread
{
    private String nom;
    private Aeroport a;

    public Avion(String s)
    {
        this.nom = s;
    }

    public void run ()
    {
        this.a = Aeroport.getAeroport();
        System.out.println("Je suis l'avion " + this.nom + " sur l'aeroport " + this.a);

        while (!a.autoriserADecoller())
        {
            try
            {
                Thread.sleep(100);
            }
            catch (Exception e)
            {
                e.printStackTrace();;
            }
        }
        System.out.println("Avion : " + nom + " autorisé a decoller");
        try {
            Thread.sleep((long)(1000 * Math.random()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Avion : " + nom + " a fini de decoller");
        a.liberer_piste();
    }

}
