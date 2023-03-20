import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        ListeIp lIp11 = new ListeIp(false);
        lIp11.chargerFichier("Exercice2/resources/logs.txt");
        System.out.println(lIp11);

        ListeIp lIp12 = new ListeIp(true);
        lIp12.chargerFichier("Exercice2/resources/logs.txt");
        System.out.println(lIp12);

        ListeIp2 lIp21 = new ListeIp2(false);
        lIp21.chargerFichier("Exercice2/resources/logs.txt");
        System.out.println(lIp21);

        ListeIp2 lIp22 = new ListeIp2(true);
        lIp22.chargerFichier("Exercice2/resources/logs.txt");
        System.out.println(lIp22);
    }
}
