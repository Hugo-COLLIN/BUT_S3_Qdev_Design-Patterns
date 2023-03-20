package ex2.src;

public abstract class Image
{
    /**
     * Chemin d'acces au fichier
     * contenant l'image de fond du logo
     */
    protected String nomIm;

    public abstract void paint ();

    /**
     * @return le prix du logo
     */
    public abstract double combienCaCoute();

}
