package TP4_4.Boisson;

import TP4_3.Boisson.Boisson;
import TP4_3.Boisson.Colombia;

//Tant que ingredient, rajoute des appels, des que TP4.cafe, fin des appels
public class Main
{
    public static void main(String[] args) {
        Boisson boisson3 = new Colombia();
        //boisson3 = new BoissonChantilly(new BoissonChantilly( new BoissonChocolat(boisson3)));
        System.out.println( boisson3.getDescription() + " €" + boisson3.cout());

    }
}
