package cours23_jSon;


import java.io.Serializable;

public class ContenantLiquide implements Cloneable, Serializable {
    private String nom; //Bécher, Erlenmeyer, Éprouvette, Compte-Goutte, Pipette... (verrerie en chimie)

    private int capaciteMl; //capacité du contenant en millilitre
    private int qte; //quantité de liquide dans le contenant
    private Liquide liquide;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapaciteMl(int capaciteMl) {
        this.capaciteMl = capaciteMl;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public ContenantLiquide(String nom, Liquide liquide, int capaciteMl, int qte) {
        this.nom = nom;
        this.liquide = liquide;
        this.capaciteMl = capaciteMl;
        this.qte = qte;
    }

    public Liquide getLiquide() {
        return liquide;
    }
    public int getCapaciteMl() {
        return capaciteMl;
    }

    public int getQte() {
        return qte;
    }
    public void setLiquide(Liquide liquide) {
        this.liquide = liquide;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ContenantLiquide clone;
        clone = (ContenantLiquide)super.clone();
        clone.liquide = (Liquide) liquide.clone(); //cloner en profondeur

        return clone;
    }

    protected Object clonerEnSurface() throws CloneNotSupportedException {
        ContenantLiquide clone;
        clone = (ContenantLiquide)super.clone();

        return clone;
    }

    @Override
    public String toString() {
        return "ContenantLiquide={" +
                "nom='" + nom + '\'' +
                ", capaciteMl=" + capaciteMl +
                ", qte=" + qte +
                ", liquide=" + liquide +
                '}';
    }
}
