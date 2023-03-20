package modele;

import exceptions.NaturePizzaInvalideException;
import exceptions.CapaciteMaxPizzasException;
import exceptions.NumPizzaInvalideException;
import vue.Observateur;

import java.util.ArrayList;
import java.util.List;

/**
 * ModeleCommande est le modele qui gere les données de la commande de pizzas
 * @author Hugo COLLIN, Raphael MANGIN
 */
public class ModeleCommande implements Sujet
{
    /**
     * Attribut décrivant le nombre de pizzas de la commande
     */
    private int nbPizzas;

    /**
     * Liste des pizzas de la commande
     */
    private List<Pizza> listPizza;

    /**
     * Indice de la pizza actuellement selectionnee par l'utilisateur
     */
    private int numPizzaCourante;

    /**
     * Prix de la commande
     */
    private double prixCommande;

    /**
     * Nombre total de pizzas commandables
     */
    public static final int MAX_PIZZA = 4;

    /**
     * Chaines decrivant les categories de pizzas/ingrédients possibles
     */
    public static final String P_CREME = "pizza-creme", P_TOMATE = "pizza-tomate";

    /**
     * Liste des vues qui observent le modele et sont actualisees en consequence
     */
    private List<Observateur> observateurs;

    /**
     * Constructeur vide
     */
    public ModeleCommande ()
    {
        this.nbPizzas = 0;
        this.listPizza = new ArrayList<Pizza>();
        this.prixCommande = 0;
        this.observateurs = new ArrayList<Observateur>();
    }

    /*
    --- METHODES D'INTERACTION AVEC LE MODELE ---
     */
    /**
     * Methode qui permet d'ajouter une pizza a la commande
     * @param naturePizza type de pizza
     * @throws NaturePizzaInvalideException
     * @throws CapaciteMaxPizzasException
     * @throws NumPizzaInvalideException
     */
    public void ajouterPizza (String naturePizza) throws NaturePizzaInvalideException, CapaciteMaxPizzasException, NumPizzaInvalideException {
        if (this.nbPizzas < MAX_PIZZA)
        {
            switch (naturePizza) {
                case P_CREME -> this.listPizza.add(new PizzaCreme());
                case P_TOMATE -> this.listPizza.add(new PizzaTomate());
                default -> throw new NaturePizzaInvalideException();
            }

            this.nbPizzas ++;
            this.calculPrixCommande();
            this.setNumPizzaCourante(this.nbPizzas - 1);
        }
        else throw new CapaciteMaxPizzasException();
    }

    /**
     * Methode calculPrixCommande
     * Cette methode calcule le prix de la commande en cours
     */
    public void calculPrixCommande()
    {
        int res = 0;
        for (Pizza pizza : this.listPizza)
            res += pizza.cout();

        this.prixCommande = res;
    }

    /**
     * Methode setNumPizzaCourante
     * Cette methode modifie la pizza selectionnee en fonction du parametre de la methode
     * @param num numero de la pizza a selectionner
     * @exception NumPizzaInvalideException jetee lorsque le numero num passe en parametre de la methode n'est pas valide
     */
    public void setNumPizzaCourante(int num) throws NumPizzaInvalideException
    {
        if (num < listPizza.size() && num >= 0)
            numPizzaCourante = num;
        else throw new NumPizzaInvalideException();
    }

    /*
    --- GETTERS ---
     */
    /**
     * Getter de nbPizzas
     * @return le nombre de pizzas de la commande
     */
    public int getNbPizzas() {
        return nbPizzas;
    }

    /**
     * Getter de listPizza
     * @return la liste des pizzas de la commande
     */
    public List<Pizza> getListPizza() {
        return listPizza;
    }

    /**
     * Getter de numPizzaCourante
     * @return le numero de la pizza actuellement selectionnee
     */
    public int getNumPizzaCourante() {
        return numPizzaCourante;
    }

    /**
     * Getter de prixCommande
     * @return le prix de la commande
     */
    public double getPrixCommande() {
        return prixCommande;
    }

    /*
    --- METHODES OBSERVATEURS ---
     */
    /**
     * Methode enregistrerObservateur
     * Cette methode ajoute un observateur a la liste des observateurs
     * @param observateur observateur a ajouter dans la liste
     */
    @Override
    public void enregistrerObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }

    /**
     * Methode supprimerObservateur
     * Cette methode permet de supprimer un observateur de la liste des observateurs
     * @param observateur observateur a supprimer
     */
    @Override
    public void supprimerObservateur(Observateur observateur) {
        observateurs.remove(observateur);
    }

    /**
     * Methode notifierObservateur
     * Cette methode permet de notifier les observateurs
     */
    @Override
    public void notifierObservateurs() {
        for (Observateur observer : this.observateurs)
            observer.actualiser(this);
    }
}
