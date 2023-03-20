
public class TextDrawer {
	protected String texte;
	
	public TextDrawer(String texte) {
		this.texte = texte;
	}
	
	public void drawText() {
		System.out.println(this.texte);
	}
}
