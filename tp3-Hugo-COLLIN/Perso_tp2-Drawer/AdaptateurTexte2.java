package Drawer;

public class AdaptateurTexte2 implements Dessinable
{
    private TextDrawer adapte;

    public AdaptateurTexte2 (String texte)
    {
        this.adapte = new TextDrawer(texte);
    }

    @Override
    public void dessine()
    {
        this.adapte.drawText();
    }
}
