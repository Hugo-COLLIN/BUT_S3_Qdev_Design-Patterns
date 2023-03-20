package ex2.src;

public class Main
{
   
    public static void main(String args[])
    {
        ReneLaTaupe l = new ReneLaTaupe();
        MyImage i = l.getLogo();
        
        i.paintOver("ex2/img/Chapeau.png", 280,42);
        i.paintOver("ex2/img/Sunglasses.png", 255, 76);
        
        i.display();  // Permet l'affichage dans une fenetre de l'image associee
        
        
    }
        
}
