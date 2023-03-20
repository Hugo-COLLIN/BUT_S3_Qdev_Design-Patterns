package modele;

import vue.MyImage;

public interface Pizza {

    /**
     * Methode getPizzaIm()
     * @return l'image correspondant a la pizza
     */
    public MyImage getPizzaIm();

    /**
     * Methode cout()
     * @return le cout de la pizza
     */
    public double cout();

    /**
     * Methode getDescription()
     * @return la description de la pizza
     */
    public String getDescription();

}
