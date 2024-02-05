package cours05_heritage;

public class Medecin extends Personnage{
    public Medecin(String nom, int ptsVie) {
        super(nom, ptsVie); //appelle le constructeur de la super classe (classe parent personnage)
    }

    @Override
    public void saluer() {
        System.out.println("Je peux te soigner?");
    }


    @Override
    public String toString() {
        String s;
        s = "Je suis un medecin ";
        s += super.toString(); //appel de la méthode parent toString();

        return s;
    }
}
