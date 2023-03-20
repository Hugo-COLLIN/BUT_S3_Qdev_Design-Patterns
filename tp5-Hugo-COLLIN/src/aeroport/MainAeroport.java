package aeroport;

public class MainAeroport
{
    public static void main(String[] args) {
        Avion v1 = new Avion("Avion 1");
        Avion v2 = new Avion("Avion 2");
        Avion v3 = new Avion("Avion 3");
        Avion v4 = new Avion("Avion 4");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
    }
}
/*Tt qu'un avion est en train de décoller, les autres doivent attendre. Exemple :
*   Avion 3 sur l'aéroport
*   Avion 1 sur l'aéroport
*   Avion 3 autorisé a decoller
*   Avion 3 a décollé
*   Avion 1 autorisé a decoller
*   Avion 1 a décollé
*/