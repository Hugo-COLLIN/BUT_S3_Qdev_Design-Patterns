package com.company.tpSAE_composite.Exo1_tp9.com.company.tpSAE_composite.Exo1_tp9;

public class SocieteSansFiliale extends Societe
{
  public SocieteSansFiliale()
  {
    this.coutUnitVehicule = 5.0;
  }

  public boolean ajouteFiliale(Societe filiale)
  {
    return false;
  }

  public double calculeCoutEntretien()
  {
    return nbrVehicules * coutUnitVehicule;
  }
}
