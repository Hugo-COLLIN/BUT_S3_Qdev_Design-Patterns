package ex2.src;

public class ReneLaTaupe extends Image
{
	/**
     * Chemin d'acces au fichier
     * contenant l'image de fond du logo
     */
    private String nomIm;
    
    /**
     * Prix du logo
     */
    private double prix;
    
    /**
     * Constructeur
     */
    public ReneLaTaupe() {
        nomIm = "ex2/img/Taupe.jpg";
        prix=3.65;
    }
    
    /**
     * @return l'objet de MyImage correspondant a nomIm
     */
    public MyImage getLogo(){
        return new MyImage(nomIm);
    }

    @Override
    public void paint() {
        i.paintOver("ex2/img/Chapeau.png", 280,42);
    }

    /**
     * @return le prix du logo
     */
    public double combienCaCoute(){
        return prix;
    }
}
