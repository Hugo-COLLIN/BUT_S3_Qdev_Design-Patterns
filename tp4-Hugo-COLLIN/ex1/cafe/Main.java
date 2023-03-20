package ex1.cafe;

//Tant que ingredient, rajoute des appels, des que TP4.cafe, fin des appels
public class Main
{
    public static void main(String[] args) {
        Boisson boisson3 = new Colombia();
        boisson3 = new BoissonChantilly(new BoissonChantilly( new BoissonChocolat(boisson3)));
        System.out.println( boisson3.getDescription() + " €" + boisson3.cout());
        System.out.println(boisson3);
    }
}
