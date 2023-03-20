package Drawer;

public class Principale
{
    public static void main(String[] args) {
        Rectangle rect;
        AdaptateurText at;
        AdaptateurTexte2 at2;

        rect = new Rectangle();
        rect.dessine();

        at = new AdaptateurText("Je suis un texte");
        at.dessine();

        at2 = new AdaptateurTexte2("Je suis un texte");
        at2.dessine();
    }
}
