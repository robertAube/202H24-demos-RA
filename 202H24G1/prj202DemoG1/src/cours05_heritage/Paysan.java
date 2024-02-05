package cours05_heritage;

public class Paysan extends Personnage {
    public Paysan(String nom, int ptsVie) {
        super(nom, ptsVie); //appelle le constructeur de la super classe (classe parent personnage)
    }

    @Override
    public void saluer() {
        System.out.println("Ne t'inquiète pas je suis innofensif");
    }

    @Override
    public String toString() {
        String s;
        s = "Je suis un paysan ";
        s += super.toString(); //appel de la méthode parent toString();

        return s;
    }
}
