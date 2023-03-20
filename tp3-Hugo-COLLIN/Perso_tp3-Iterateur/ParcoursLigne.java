public class ParcoursLigne extends Parcours
{
    public ParcoursLigne (TableauEntier tableauEntier)
    {
        super(tableauEntier);
    }

    @Override
    public void suivant()
    {
        if (this.colonneCour < tab.getLargeur() - 1)
        {
            //System.out.println(tab.retourne(this.ligneCour, this.colonneCour));
            System.out.print(colonneCour);
            this.colonneCour ++;
        }
        else if (this.colonneCour < tab.getHauteur() - 1)
        {
            //System.out.println(tab.retourne(this.ligneCour, this.colonneCour));
            System.out.print(colonneCour);
            this.ligneCour ++;
            this.colonneCour = 0;
            System.out.println();
        }
    }
}
