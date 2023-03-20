public class TableauEntier
{
    private int[][] val;
    private int largeur, hauteur;

    public TableauEntier(int[][] t) // encapsule le tableau passé en paramètre.
    {
        this.val = t;
        this.largeur = t[0].length;
        this.hauteur = t.length;
    }

    int retourne(int l, int c) {
        return val[l][c];
    }

    public int getLargeur()  // retourne le nombre de colonnes du tableau.
    {
        return this.largeur;
    }

    public int getHauteur() {
        return 0;
    }

    Parcours iterateurLigne()
    {
        return new ParcoursLigne(this);
    }

    Parcours iterateurColonne()
    {
        return new ParcoursLigne(this);
    }

    Parcours iterateurZigzag()
    {
        return new ParcoursLigne(this);
    }
}
