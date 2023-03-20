public class Principale
{
    public static void main(String[] args) {
        Parcours p;
        TableauEntier te;
        int[][] tab = new int[5][5];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = j;
            }
        }

        te = new TableauEntier(tab);
        p = te.iterateurLigne();
        //p.next();
        while (p.hasNext())
        {
            p.next();
            //System.out.println(p);
        }
    }
}
