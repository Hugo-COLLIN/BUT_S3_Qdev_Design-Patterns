
public class Principale2 {

	public static void main(String[] args) { //static : permet de def une methode de classe, pas besoin de creer d'objet != methode d'instance : s'exec sur 1 objet
		//args : Arguments puissent etre recuperes sur le terminal
		// TODO Auto-generated method stub
		Annuaire3 annuaire = new Annuaire3();
		
		annuaire.adjonction(new Personne("Paillet", "Manu"), "0607080910");
		annuaire.adjonction(new Personne("Larose", "Sophie"), "0601020304");
		annuaire.adjonction(new Personne("Pamplemousse", "Léa"), "0700051015");
		annuaire.adjonction(new Personne("Pangot", "Lucas"), "0710090807");
		annuaire.adjonction(new Personne("Ricochet", "Louise"), "0609100709");
		
		annuaire.affiche();
		
		System.out.println("Léa : " + annuaire.acces("Pamplemousse", "Léa") + "\n");
		
		annuaire.changement(new Personne("Pangot", "Lucas"), "0710090809");
		
		annuaire.affiche();
		
		System.out.println(annuaire);
	}

}
