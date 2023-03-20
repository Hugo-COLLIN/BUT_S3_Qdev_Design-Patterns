package TP3.Canard;

public class Main {
    public static void main(String[] args) {
        Canard colvert=new Colvert();
        Canard rouen=new DeRouen();
        colvert.afficher();
        colvert.effectuerVol();
        rouen.afficher();
        rouen.effectuerVol();
    }
}