package com.company.tpSAE_composite.Exo1_tp9.com.company.tpSAE_composite.Exo1_tp9;

import java.util.*;
public class SocieteMere extends Societe {
  protected List<Societe> filiales =
    new ArrayList<Societe>();

  public SocieteMere ()
  {
    this.coutUnitVehicule = 10.0;
  }

  public boolean ajouteFiliale(Societe filiale) {
    return filiales.add(filiale);
  }

  public double calculeCoutEntretien() {
    double cout = 0.0;
    for (Societe filiale: filiales)
      cout = cout + filiale.calculeCoutEntretien();
    return cout + nbrVehicules * coutUnitVehicule;
  }
}
