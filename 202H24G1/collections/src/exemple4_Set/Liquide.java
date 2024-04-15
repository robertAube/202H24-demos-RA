package exemple4_Set;

public class Liquide implements Comparable<Liquide> //Type générique
{
    private String nom; //lait (1030), eau (1000), essence (750), Mercure(13600)
    private int masseVolumique_KgParM3;

    public Liquide(String nom, int masseVolumique_KgParM3) {
        setNom(nom);
        this.masseVolumique_KgParM3 = masseVolumique_KgParM3;
    }

    public void setNom(String nom) {
        if (validerNom(nom))
            this.nom = nom;
        else
            throw new RuntimeException("Le nom ne peut pas être null");
    }

    public static boolean validerNom(String nom) {
        return (nom != null);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Liquide liquide = (Liquide) o;
//
//        return nom.equals(liquide.nom);
//    }
//
//    @Override
//    public int hashCode() {
//        return nom != null ? nom.hashCode() : 0;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Liquide liquide = (Liquide) o;

        if (masseVolumique_KgParM3 != liquide.masseVolumique_KgParM3) return false;
        return nom.equals(liquide.nom);
    }

    @Override
    public int hashCode() {
        int result = nom.hashCode();
        result = 31 * result + masseVolumique_KgParM3;
        return result;
    }

    @Override
    public int compareTo(Liquide liquide) {
        int comparaison;
        comparaison = this.nom.compareTo(liquide.nom) ;

        comparaison = comparaison == 0 ? this.masseVolumique_KgParM3 - liquide.masseVolumique_KgParM3 : comparaison;
//            comparaison = this.masseVolumique_KgParM3 - liquide.masseVolumique_KgParM3;

        return comparaison;
    }

    @Override
    public String toString() {
        return nom
                + " - { masseVolumique= " + masseVolumique_KgParM3 + " Kg/M3"
                + ", hashCode= " + this.hashCode() + " (" + String.format("0x%08X", this.hashCode())+ ") }";
    }

    public static void main(String[] args) {
        Liquide [] lLiquide = {
                new Liquide("huile de sésame", 920),
                new Liquide("huile d'olive", 920),
                new Liquide("eau", 999),
                new Liquide("eau", 1000),
                new Liquide("mercure", 13600),
                new Liquide("mercure", 13600),
                };
        for (Liquide liquide: lLiquide) {
            System.out.println(liquide);
        }
    }
}

/**
 * huile de sésame - {masseVolumique= 920 Kg/M3, hashCode= 1782076880 (0x6A3855D0) }
 * huile d'olive - {masseVolumique= 920 Kg/M3, hashCode= -131812915 (0xF824B1CD) }
 * eau - {masseVolumique= 999 Kg/M3, hashCode= 100185 (0x00018759) }
 * eau - {masseVolumique= 1000 Kg/M3, hashCode= 100185 (0x00018759) }
 * mercure - {masseVolumique= 13600 Kg/M3, hashCode= 953544447 (0x38D5EEFF) }
 * mercure - {masseVolumique= 13600 Kg/M3, hashCode= 953544447 (0x38D5EEFF) }
 */