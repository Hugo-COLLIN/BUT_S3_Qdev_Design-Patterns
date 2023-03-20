import java.util.Iterator;

public abstract class Parcours implements Iterator<Integer>
{
    protected TableauEntier tab;
    protected int ligneCour, colonneCour;
    private int nbParcourus;

    public Parcours (TableauEntier t)
    {
        this.tab = t;
        this.ligneCour = 0;
        this.colonneCour = 0;
        this.nbParcourus = 0;
    }

    @Override
    public boolean hasNext() {
        return tab.getHauteur() * tab.getLargeur() > nbParcourus;
    }

    @Override
    public Integer next() {
        int v = tab.retourne(ligneCour, colonneCour);
        suivant(); //appel à la liaison dynamique
        nbParcourus ++;
        return v;
    }

    public abstract void suivant();
}
