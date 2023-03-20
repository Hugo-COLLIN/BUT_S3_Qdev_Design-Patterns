import java.util.ArrayList;
import java.util.List;

public interface Collection extends Iterable{
    public boolean add(Object o);
    public boolean contains(Object o);
    public Iterator iterator();
    public boolean remove(Object o);

    List<Integer> tab = new ArrayList<Integer>();
    Iterator<Integer> it = tab.iterator();
while (it.hasNext())
        System.out.println(it.next().intValue()*2);
}