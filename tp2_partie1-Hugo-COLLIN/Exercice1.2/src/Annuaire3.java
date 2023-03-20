import java.util.*;

//Bonne facon de prog : cache l'implémentation à user, contrôle ce que user peut faire. User ne ourra jamais acceder a Hashmap
//= Encapsulation
// Doit fonctionner + évoluer au cours du temps, en utilisant patrons de conception
//ProgR:comment faire ; user : quoi faire ?
public class Annuaire3 {
	
	private Map<Personne,String> hmap; //Privilégier l'interface dans la déclaration de l'attribut, au cas où on veut changer l'init dans le constructeur

	public Annuaire3(){
		hmap = new HashMap<Personne,String>();
	}
	
    public void domaine() {
       Set<Personne> ks = hmap.keySet();
       for(Personne p : ks){
           System.out.print(p + " ");
       }
       System.out.println("");
    }
    
    public void domaine2() {
		Set<Personne> ks = hmap.keySet();
		Iterator it = ks.iterator();
		while (it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println("");
    }
    
    public void affiche() {
        Set<Personne> ks = hmap.keySet();
        for(Personne p : ks){
            System.out.print(p+" : ");
            System.out.println(hmap.get(p));
        }
        System.out.println("");
     }
    
    public String acces(String nom, String prenom) {
        String rep = null;
        rep = hmap.get(new Personne(nom, prenom));
        return rep;
    }
    
    public void adjonction(Personne pers, String numero) {
          if (!hmap.containsKey(pers)){
        	  	hmap.put(pers, numero);
          }
    }
    
    public void suppression(String nom) {
           hmap.remove(nom);
    }
    
    public void changement(Personne pers, String numero) {
          if (hmap.containsKey(pers)){
        	  	hmap.put(pers, numero);
          }
    }

	@Override //Directive, Redéfinition de methode, on hérite de la classe Object meme si on ne le def pas nous-meme. Grâce a Override, 'IDE verif que la methode redefinit une methode heritee.
	public String toString() {
		return "Annuaire3 [hmap=" + hmap + "]";
	}

}
