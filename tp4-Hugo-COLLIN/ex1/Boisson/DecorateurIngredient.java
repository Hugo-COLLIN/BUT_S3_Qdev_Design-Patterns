package TP4_4.Boisson;

import TP4_3.Boisson.Boisson;

//grâce à la "boucle" attribut + héritage
public abstract class DecorateurIngredient extends TP4_3.Boisson.Boisson {
    protected TP4_3.Boisson.Boisson composant;
    protected double prix;

    public DecorateurIngredient (double p, String d, Boisson b)
    {
        this.prix = p;
        this.description = d;
        this.composant = b; //b peut etre un café ou un ingrédient
    }
    public String getDescription()
    {
        return this.description + composant.getDescription();
    }

    @Override
    public double cout() {
        return this.prix + composant.cout();
    }
}