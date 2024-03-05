package cours14_Clonable;

/*
420-202 – TP2 – Traitement de données orienté objet
*/
public class Liquide {
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

    @Override
    public String toString() {
        return '{' +
                "nom='" + nom + '\'' +
                ", masseVolumique_KgParM3=" + masseVolumique_KgParM3 +
                '}';
    }
}
