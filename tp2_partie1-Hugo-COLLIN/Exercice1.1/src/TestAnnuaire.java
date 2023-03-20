import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TestAnnuaire {
   public static void main(String[] args) {
      Annuaire2 annu = new Annuaire2();
      int rep = 0;
      
      Scanner scanner = new Scanner(System.in);
      while (rep >= 0 ) {
         System.out.println("Voulez vous ? ");
         System.out.println("   Afficher les noms ? 		tapez 1");
         System.out.println("   Rechercher un numero ? 	tapez 2");
         System.out.println("   Ajouter une entree ?		tapez 3");
         System.out.println("   Supprimer une entree ?	tapez 4");
         System.out.println("   Modifier un numero ?		tapez 5");
         System.out.println("   Quitter ?			tapez -1");
         rep = scanner.nextInt();
         switch (rep) {
            case 1 :
            		annu.domaine();
            		break;
            case 2 : {
            		System.out.println("Quel nom ?");
            		String nom = scanner.next();
            		String numero = annu.acces(nom);
            		System.out.println("Numero = "+numero);
            		break;
            }
            case 3 :{ 
             	System.out.println("Quel nom ?");
             	String nom = scanner.next();
             	System.out.println("Quel numero ?");
             	String numero = scanner.next();
             	annu.adjonction(nom, numero);
             	break;
            }
            case 4 : {
             	System.out.println("Quel nom ?");
             	String nom = scanner.next();
             	annu.suppression(nom);
             	break;
            }
            case 5 : {
             	System.out.println("Quel nom ?");
             	String nom = scanner.next();
             	System.out.println("Quel numero ?");
             	String numero = scanner.next();
             	annu.changement(nom, numero);
             	break;
            	}
            case -1 : System.exit(0);
          }
      } 
   }
}
