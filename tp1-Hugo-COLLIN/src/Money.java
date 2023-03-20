package tp1.src;

import java.util.Objects;

/**
 * Classe Money représentant une somme d'argent et sa devise
 */
public class Money
{
    //Attributes
    /**
     * Somme d'argent
     */
    private int montant;

    /**
     * Devise du montant d'argent
     */
    private String devise;

    //Constructors
    /**
     * Construit un objet Money avec 2 attributs
     * @param mon somme d'argent
     * @param dev devise de la somme d'argent
     */
    public Money(int mon, String dev) {
        this.montant = mon;
        this.devise = dev;
    }

    //Methods

    /**
     * Getter de l'attribut montant
     * @return l'attribut montant
     */
    public int getMontant() {
        return this.montant;
    }

    /**
     * Getter de l'attribut devise
     * @return l'attribut devise
     */
    public String getDevise() {
        return this.devise;
    }

    /**
     * Ajoute une somme d'argent à l'attribut montant
     * @param m montant a ajouter sous forme d'un objet Money
     * @return Un nouvel objet Money avec la nouvelle somme d'argent et la meme devise
     */
    public Money add(Money m) throws DeviseException {
        if (!this.devise.equals(m.getDevise()))
            throw new DeviseException();

        return new Money(this.getMontant()+m.getMontant(), this.getDevise());
    }

    /**
     * Redéfinition de equals
     * @param o objet
     * @return si les 2 objets sont égaux
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return montant == money.montant && Objects.equals(devise, money.devise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(montant, devise);
    }

    /**
     * Redefinition de toString
     * @return chaine representant l'objet Money
     */
    public String toString ()
    {
        return montant + " " + devise;
    }
}
