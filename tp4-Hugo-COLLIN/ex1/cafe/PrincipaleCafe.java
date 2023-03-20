package ex1.cafe;

public class PrincipaleCafe
{
    public static void main(String[] args) {
        Boisson deca = new Deca();
        deca = new BoissonChantilly(new BoissonChantilly(new BoissonCreme(deca)));
        System.out.println(deca);
    }
}
