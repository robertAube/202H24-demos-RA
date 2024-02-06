package cours05_heritage;

public class Paysan extends Personnage {
    public Paysan(String nom, int ptsVie) {
        super(nom, ptsVie);
    }

    @Override
    public void rencontrer(Personnage pRencontre) {
        System.out.println("Je peux t'aider?");
    }

    @Override
    public String toString() {
        return "Je suis un Paysan " + super.toString(); //appel de la méthode toString de la classe parent
    }
}
