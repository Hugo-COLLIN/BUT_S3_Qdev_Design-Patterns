import java.lang.reflect.Field;

public class Analyseur
{
    public String analyseClasse(String nomClasse)
    {
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> c = Class.forName(nomClasse);
            Field [] attributes = c.getFields();

            for (Field f : attributes)
                System.out.println(f.getName() + "\t" + f.getType().getName() + "\t" + f.getType().isPrimitive() + "\n");
            return sb.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
