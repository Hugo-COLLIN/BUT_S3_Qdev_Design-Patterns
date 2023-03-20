package com.company.tpSAE_composite.Exo1_tp9.com.company.tpSAE_composite.Exo1_tp9;

public class Utilisateur
{

  public static void main(String[] args)
  {
    Societe societe1 = new SocieteSansFiliale();
    societe1.ajouteVehicule();
    Societe societe2 = new SocieteSansFiliale();
    societe2.ajouteVehicule();
    societe2.ajouteVehicule();
    Societe groupe = new SocieteMere();
    groupe.ajouteFiliale(societe1);
    groupe.ajouteFiliale(societe2);
    groupe.ajouteVehicule();
    System.out.println(
      " Cout d'entretien total du groupe : " + groupe.calculeCoutEntretien());

    Societe sB = new SocieteMere();
    Societe sF = new SocieteMere();
    Societe sG = new SocieteSansFiliale();

    sB.ajouteFiliale(sF);
    sF.ajouteFiliale(sG);
    sB.ajouteVehicule();
    sF.ajouteVehicule();
    sG.ajouteVehicule();
    sG.ajouteVehicule();
    System.out.println(sB.calculeCoutEntretien());
  }
}
