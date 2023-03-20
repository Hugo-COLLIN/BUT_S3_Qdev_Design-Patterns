import java.util.ArrayList;
import java.util.List;

public class AdresseIp
{
    private List<Integer> ipTab;

    public AdresseIp(String ip)
    {
        this.ipTab = new ArrayList<Integer>();
        this.splitIp(ip);
    }

    public void splitIp(String ip)
    {
        String[] temp = ip.split("[.]");
        for (String s : temp)
            this.ipTab.add(Integer.parseInt(s));
    }

    public List<Integer> getIpTab() {
        return ipTab;
    }

    @Override
    public String toString() {
        return "AdresseIp{" +
                "ipTab=" + ipTab +
                '}';
    }
}
