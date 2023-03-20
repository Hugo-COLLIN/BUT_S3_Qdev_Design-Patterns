package tp1.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe qui crée un objet avec une liste de montants dans des devises différentes
 */
public class MoneyList
{
    /**
     * Liste de sommes d'argent dans des devises differentes
     */
    private List<Money> list;

    /**
     * Constructeur vide qui crée une ArrayList vide pour l'attribut liste
     */
    public MoneyList()
    {
        list= new ArrayList<Money>();
    }

    /**
     * Getter de l'attribut list
     * @return l'element list
     */
    public List<Money> getList()
    {
        return list;
    }

    /**
     * Ajoute le montant m a une devise deja dans list, ou cree un nouvel element
     * pour la nouvelle devise dans list avec la somme correspondante.
     * @param m Montant a ajouter a la liste
     * @throws DeviseException
     */
    public void ajouterSomme (Money m) throws DeviseException
    {
        boolean ajoute = false;

        for (int i = 0 ; i < this.list.size() ; i ++) {
            Money elt = this.list.get(i);
            if (this.list.get(i).getDevise().equals(m.getDevise()) && !ajoute) {
                Money s = m.add(elt);
                this.list.set(i, s);
                ajoute = true;
            }
        }

        if (!ajoute)
            this.list.add(m);
    }

    /**
     * Redefinition de tOString
     * @return la chaine representant chaque element Money de list
     */
    public String toString ()
    {
        StringBuilder res = new StringBuilder("");
        for (Money m : this.list)
            res.append(m.toString());

        return res.toString();
    }

    /**
     * Redefinition de equals
     * @param o Objet a comparer
     * @return si les 2 objets et leurs elements sont identiques
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyList moneyList = (MoneyList) o;
        return Objects.equals(list, moneyList.list);
    }

    /**
     * Methode hashcode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    public void triMontant ()
    {
        for (int i = 0 ; i < this.list.size() ; i ++)
        {
            int minMIndex = i;

            for (int j = i + 1 ; j < this.list.size() ; j ++)
                if (this.list.get(j).getMontant() < this.list.get(minMIndex).getMontant())
                    minMIndex = j;

            Money minMontantElem = this.list.get(minMIndex);
            this.list.set(minMIndex, this.list.get(i));
            this.list.set(i, minMontantElem);
        }
    }

    public void triDevise ()
    {
        for (int i = 0 ; i < this.list.size() ; i ++)
        {
            int minDIndex = i;

            for (int j = i + 1 ; j < this.list.size() ; j ++)
                if (this.list.get(j).getDevise().compareTo(this.list.get(minDIndex).getDevise()) < 0)
                    minDIndex = j;

            Money minDeviseElem = this.list.get(minDIndex);
            this.list.set(minDIndex, this.list.get(i));
            this.list.set(i, minDeviseElem);
        }
    }
}
