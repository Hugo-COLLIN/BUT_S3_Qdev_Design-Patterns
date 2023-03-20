import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ListeIp
{
    private Set<String> ips;

    public ListeIp(boolean tri)
    {
        if (tri)
            this.ips = new TreeSet<String>();
        else
            this.ips = new HashSet<String>();
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
        this.ips.add(cut[0]);
    }

    public Set<String> getIps() {
        return ips;
    }

    @Override
    public String toString() {
        return "ListeIp{" +
                "ips=" + ips +
                '}';
    }
}





