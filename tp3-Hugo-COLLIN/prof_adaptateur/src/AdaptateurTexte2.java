
public class AdaptateurTexte2 implements Dessinable {

	private TextDrawer adapte;
	
	public AdaptateurTexte2 (String texte) {
		this.adapte = new TextDrawer(texte);
	}

	@Override
	public void dessine() {
		// TODO Auto-generated method stub
		this.adapte.drawText();
	}

}
