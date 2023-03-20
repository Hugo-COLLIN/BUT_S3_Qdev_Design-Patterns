import java.util.*;

//Mauvaise façon de programmer, car user peut aussi utiliser les fonctions de hasmap au lieu de celles qu'on a choisi.
public class Annuaire extends HashMap<String,String> {
	
	public Annuaire(){
		super();
	}
	
    public void domaine() {
       Set<String> ks = this.keySet();
       for(String s:ks){
           System.out.print(s+" ");
       }
       System.out.println("");
    }

    public void domaine2() {
    		Set<String> ks = this.keySet();
    		Iterator it = ks.iterator();
    		while (it.hasNext()) {
    			System.out.print(it.next()+" ");
    		}
    		System.out.println("");
    }
      
    public String acces(String nom) {
        String rep = null;
        rep = this.get(nom);
        return rep;
    }
    
    public void adjonction(String nom, String numero) {
          if (!this.containsKey(nom)){
        	  	this.put(nom, numero);
          }
    }
     
    public void suppression(String nom) {
           this.remove(nom);
    }    
    
    public void changement(String nom, String numero) {
          if (this.containsKey(nom)){
        	  	this.put(nom, numero);
          }
    }
    
}
