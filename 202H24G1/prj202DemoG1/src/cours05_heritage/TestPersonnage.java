package cours05_heritage;

import _utilitaire.Utilitaire;

import java.util.ArrayList;
import java.util.Random;

public class TestPersonnage {
    private static final String[] tabNom = {"Tom", "Jacob", "Bronto", "Méduse", "Doom", "Yvon", "Agamemnon", "Eurysthée", "Brontès", "Perséphone", "Déjanire"};
    private ArrayList<Personnage> listePersonnage;

    public TestPersonnage() {
        initListePessonnage();
        afficherPersonnage();
        seRencontre();
        afficherPersonnage();
    }

    private void seRencontre() {
        int suivant;
        for (int i = 0; i < listePersonnage.size(); i++) {
            suivant = i == listePersonnage.size() - 1 ? 0 : i + 1;
            listePersonnage.get(i).rencontrer(listePersonnage.get(suivant));
        }
    }

    private void afficherPersonnage() {
        for (Personnage p : listePersonnage) {
            System.out.println(p);
        }
    }

    private void initListePessonnage() {
        listePersonnage = new ArrayList<>();
        for (String nom : tabNom) {
            listePersonnage.add(getRandomPersonnage(nom));
        }
    }

    private Personnage getRandomPersonnage(String nom) {
        Personnage p;
        int noTypePersonnage = Utilitaire.getRandomInRange(0, 2);
        int nbPtsVie = Utilitaire.getRandomInRange(10, 100);
        switch (noTypePersonnage) {
            case 0:
                p = new Guerrier(nom, nbPtsVie);
                break;
            case 1:
                p = new Paysan(nom, nbPtsVie);
                break;
            case 2:
                p = new Medecin(nom, nbPtsVie);
                break;
            default:
                throw new RuntimeException("Numéro de personnage invalide");
        }

        return p;
    }

    public static void main(String[] args) {
        new TestPersonnage();
    }
}
