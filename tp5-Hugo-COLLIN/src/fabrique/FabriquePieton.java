package fabrique;

public class FabriquePieton implements FabriqueVehicule{

	@Override
	public Vehicule creerVehicule() {
		return new Pieton();
	}

}
