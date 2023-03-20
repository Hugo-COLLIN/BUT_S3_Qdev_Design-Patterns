package Drawer;

public class AdaptateurText extends TextDrawer implements Dessinable
{
    public AdaptateurText(String text)
    {
        super(text);
    }

    @Override
    public void dessine()
    {
        this.drawText();
    }
}
