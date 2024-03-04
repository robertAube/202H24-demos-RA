package cours12_Clonable;

/*
420-202 – TP2 – Traitement de données orienté objet
TP2 – jeu de mémoire
Groupe : 2 (mardi – vendredi)
Nom : Aubé, Robert; 1234567
Nom : Musk, Elise; 5671234
Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
*/
public class ContenantLiquide implements Cloneable {
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

    public void setLiquide(Liquide liquide) {
        this.liquide = liquide;
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

    public ContenantLiquide cloneSurface() throws CloneNotSupportedException {
        return (ContenantLiquide) super.clone();
    }
}
