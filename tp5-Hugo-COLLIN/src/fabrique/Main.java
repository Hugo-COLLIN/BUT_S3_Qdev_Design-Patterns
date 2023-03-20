package fabrique;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FabriqueVehicule fv = new FabriquePieton();
		
		Vehicule v1 = fv.creerVehicule();
		Vehicule v2 = fv.creerVehicule();
		Vehicule v3 = fv.creerVehicule();
		Vehicule v4 = fv.creerVehicule();
		Vehicule v5 = fv.creerVehicule();
		Vehicule v6 = fv.creerVehicule();
		Vehicule v7 = fv.creerVehicule();

		/*
		Simulateur s;
		s = new Simulateur(new FabriquePieton());*/
	}

}
