import java.util.*;

//Bonne facon de prog : cache l'implémentation à user, contrôle ce que user peut faire. User ne ourra jamais acceder a Hashmap
//= Encapsulation
// Doit fonctionner + évoluer au cours du temps, en utilisant patrons de conception
//ProgR:comment faire ; user : quoi faire ?
public class Annuaire2{
	
	private Map<String,String> hmap; //Privilégier l'interface dans la déclaration de l'attribut, au cas où on veut changer l'init dans le constructeur

	public Annuaire2(){
		hmap = new HashMap<String,String>();
	}
	
    public void domaine() {
       Set<String> ks = hmap.keySet();
       for(String s:ks){
           System.out.print(s+" ");
       }
       System.out.println("");
    }
    
    public void domaine2() {
		Set<String> ks = hmap.keySet();
		Iterator it = ks.iterator();
		while (it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println("");
    }
    
    public void affiche() {
        Set<String> ks = hmap.keySet();
        for(String s:ks){
            System.out.print(s+" : ");
            System.out.println(hmap.get(s));
        }
        System.out.println("");
     }
    
    public String acces(String nom) {
        String rep = null;
        rep = hmap.get(nom);
        return rep;
    }
    
    public void adjonction(String nom, String numero) {
          if (!hmap.containsKey(nom)){
        	  	hmap.put(nom, numero);
          }
    }
    
    public void suppression(String nom) {
           hmap.remove(nom);
    }
    
    public void changement(String nom, String numero) {
          if (hmap.containsKey(nom)){
        	  	hmap.put(nom, numero);
          }
    }

	@Override //Directive, Redéfinition de methode, on hérite de la classe Object meme si on ne le def pas nous-meme. Grâce a Override, 'IDE verif que la methode redefinit une methode heritee.
	public String toString() {
		return "Annuaire2 [hmap=" + hmap + "]";
	}

}
