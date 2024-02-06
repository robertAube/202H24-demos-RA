package cours05_heritage;

public class Guerrier extends Personnage { //Guerrier hérite de Personnage
    public Guerrier(String nom, int ptsVie) {
        super(nom, ptsVie);
    }

    @Override
    public void rencontrer(Personnage pRencontre) {
        int ptsVie = pRencontre.getPtsVie();
        System.out.println("Je ne t'aime pas!");
        ptsVie -= 3;
        pRencontre.setPtsVie(ptsVie < 0 ? 0 : ptsVie);
    }


    @Override
    public String toString() {
        return "Je suis un Guerrier " + super.toString(); //appel de la méthode toString de la classe parent
    }
}
