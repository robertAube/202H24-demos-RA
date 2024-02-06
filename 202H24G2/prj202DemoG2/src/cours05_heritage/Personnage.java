package cours05_heritage;

public abstract class Personnage {
    private String nom;
    private int ptsVie;

    public Personnage(String nom, int ptsVie) {
        this.nom = nom;
        this.ptsVie = ptsVie;
    }

    public void saluer(Personnage pRencontre) {
        System.out.println("Bonjour " + pRencontre.nom);
        rencontrer(pRencontre);
    }

    //Méthode abstraite : méthode qu'on n'est pas encore en mesure de définir, mais ceux qui héritent de cette classe devront la définir.
    //Aussitôt qu'on a une méthode abstraite dans une classe, celle-ci doit être également abstraite.
    public abstract void rencontrer(Personnage pRencontre);

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtsVie() {
        return ptsVie;
    }

    public void setPtsVie(int ptsVie) {
        this.ptsVie = ptsVie;
    }

    public boolean estMort() {
        return ptsVie == 0;
    }

    @Override
    public String toString() {
        return "mon nom est " + nom + " et il me reste " + ptsVie + " points de vie.";
    }
}
