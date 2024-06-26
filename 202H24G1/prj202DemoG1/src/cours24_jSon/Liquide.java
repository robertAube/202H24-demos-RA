package cours24_jSon;


import java.io.Serializable;

/**
 * Clonage profond.
 * @version 1.0 (Date de création: 2024-03-10)
 */
public class Liquide implements Cloneable, Serializable {
    private String nom; //lait (1030), eau (1000), essence (750), Mercure(13600)
    private int masseVolumique_KgParM3;

    public Liquide(String nom, int masseVolumique_KgParM3) {
        this.nom = nom;
        this.masseVolumique_KgParM3 = masseVolumique_KgParM3;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMasseVolumique_KgParM3(int masseVolumique_KgParM3) {
        this.masseVolumique_KgParM3 = masseVolumique_KgParM3;
    }

    public String getNom() {
        return nom;
    }

    public int getMasseVolumique_KgParM3() {
        return masseVolumique_KgParM3;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return '{' +
                "nom='" + nom + '\'' +
                ", masseVolumique_KgParM3=" + masseVolumique_KgParM3 +
                '}';
    }
}
