
public class Principale {

	public static void main(String[] args) { //static : permet de def une methode de classe, pas besoin de creer d'objet != methode d'instance : s'exec sur 1 objet
		//args : Arguments puissent etre recuperes sur le terminal
		// TODO Auto-generated method stub
		Annuaire2 annuaire = new Annuaire2();
		
		annuaire.adjonction("Manu", "0607080910");
		annuaire.adjonction("Sophie", "0601020304");
		annuaire.adjonction("Léa", "0700051015");
		annuaire.adjonction("Lucas", "0710090807");
		annuaire.adjonction("Louise", "0609100709");
		
		annuaire.affiche();
		
		System.out.println("Léa : " + annuaire.acces("Léa") + "\n");
		
		annuaire.changement("Lucas", "0710090809");
		
		annuaire.affiche();
		
		System.out.println(annuaire);
	}

}
