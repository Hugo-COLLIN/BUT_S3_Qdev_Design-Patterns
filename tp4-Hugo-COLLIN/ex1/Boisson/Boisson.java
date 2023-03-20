package TP4_4.Boisson;

// Abstrait car depend de la boisson
public abstract class Boisson {
    String description = "TP4.Boisson inconnue";
    public String getDescription() {
        return description;
    }
    public abstract double cout();
}
