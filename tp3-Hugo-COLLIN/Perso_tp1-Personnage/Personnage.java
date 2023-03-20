
public abstract class Personnage
{
    TechniqueCombat tech;

    public Personnage ()
    {
        this.tech = new TechniqueCombat();
    }

    public abstract void armer(TechniqueCombat t);

    public void combattre()
    {

    }
}
