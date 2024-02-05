package cours05_heritage;

public abstract class Personnage { //classe abstraite : parce que j'ai une méthode abstraite. Une classe ne peut pas être instanciée.
    private String nom;
    private int ptsVie;

    public Personnage(String nom, int ptsVie) {
        setNom(nom);
        setPtsVie(ptsVie);
    }

    public void rencontrer(Personnage p) {
        saluer();
        System.out.println("Bonjour " + getNom());
    }

    //Méthode abstraite : on n'est pas encore en mesure de la définir, mais on veut qu'elle existe pour l'utiliser.
    //Aussitôt qu'on a une méthode abstraite dans une classe, celle-ci doit être aussi abstraite
    public abstract void saluer();

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
        this.ptsVie = ptsVie < 0 ? 0 : ptsVie;
    }

    public boolean estMort() {
        return ptsVie == 0;
    }

    @Override
    public String toString() {
        return "Mon nom est " + nom + " et il me reste " + ptsVie + " points de vie.";
    }
}
