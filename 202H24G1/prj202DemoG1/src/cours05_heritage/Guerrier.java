package cours05_heritage;

public class Guerrier extends Personnage { //héritage Guerrier hérite de personnage (Guerrier "est un" personnage)
    public Guerrier(String nom, int ptsVie) {
        super(nom, ptsVie); //appelle le constructeur de la super classe (classe parent personnage)
    }

    @Override
    public void saluer() {
        System.out.println("Je ne t'aime pas!");
    }


    public void seBattre(Personnage p) {
        p.setPtsVie(p.getPtsVie() - 10);
    }

    @Override
    public void rencontrer(Personnage p) {
        super.rencontrer(p);
        seBattre(p);
    }

    @Override
    public String toString() {
        String s;
        s = "Je suis un Guerrier ";
        s += super.toString(); //appel de la méthode parent toString();

        return s;
    }
}
