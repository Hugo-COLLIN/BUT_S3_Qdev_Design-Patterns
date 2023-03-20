package fabrique;

public class FabriqueIntersection implements FabriqueVehicule
{
    double probaVoiture, probaBus, probaByc, probaPieton;


    public FabriqueIntersection ()
    {
        this.probaBus = 0.1;
        this.probaByc = 0.05;
        this.probaPieton = 0.05;
        this.probaVoiture = 0.8;
    }

    @Override
    public Vehicule creerVehicule() {
        double rand = Math.random();
        if (rand < probaBus)
            return new Bus();
        rand -= probaBus;

        if (rand < probaByc)
            return new Bicyclette();
        rand -= probaByc;
        if (rand < probaVoiture)
            return new Voiture();

        return new Pieton();
    }
}
