
public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect;
		AdaptateurTexte at;
		//AdaptateurTexte2 at2;
		
		rect = new Rectangle();
		rect.dessine();
		
		at = new AdaptateurTexte("Je suis un texte");
		at.dessine();
		
		//at2 = new AdaptateurTexte2("Je suis un texte");
		//at2.dessine();
	}

}
