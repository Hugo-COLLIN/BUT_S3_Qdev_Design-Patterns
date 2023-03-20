package TP3.Canard;

public abstract class Canard {
    protected ComportementVol cVol;

    public Canard() {
    }

    public abstract void afficher();

    public void effectuerVol() {
        cVol.voler();
    }
    //Possibilité de changer le comportement dynamiquement
    public void setComportementVol(ComportementVol v){
        cVol=v;
    }
    public void cancaner(){
        System.out.println("Coincoin ");
    }

}