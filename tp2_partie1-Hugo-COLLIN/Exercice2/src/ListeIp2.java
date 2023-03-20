import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ListeIp2
{
    private Set<AdresseIp> ips;

    public ListeIp2(boolean tri)
    {
        if (tri)
            this.ips = new TreeSet<AdresseIp>();
        else
            this.ips = new HashSet<AdresseIp>();
    }

    public void chargerFichier(String name) throws IOException {
        Reader r = new FileReader(name);
        BufferedReader bR = new BufferedReader(r);

        String l = bR.readLine();
        while (l != null)
        {
            this.traiter(l);
            l = bR.readLine();
        }
    }

    public void traiter (String line)
    {
        String[] cut = line.split(" ");
        this.ips.add(new AdresseIp(cut[0]));
    }

    public Set<AdresseIp> getIps() {
        return ips;
    }

    @Override
    public String toString() {
        return "ListeIp{" +
                "ips=" + ips +
                '}';
    }
}





