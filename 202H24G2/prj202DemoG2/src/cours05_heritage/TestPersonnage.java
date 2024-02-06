package cours05_heritage;

import _utilitaire.Utilitaire;

import java.util.ArrayList;

public class TestPersonnage {
    private static final String[] tabNom = {"Tom", "Jacob", "Bronto", "Méduse", "Doom", "Yvon", "Agamemnon", "Eurysthée", "Brontès", "Perséphone", "Déjanire"};
    private ArrayList<Personnage> listPersonnages;

    public TestPersonnage() {
        //testerBasic();
        jouerAvecPersonnage();
    }

    private void jouerAvecPersonnage() {
        initListePersonnage(14);
        afficherPersonnage();
        faireSeRencontrer();
        afficherPersonnage();
    }

    private void faireSeRencontrer() {
        Personnage personnageQuiRencontre;
        Personnage personnageRencontre;
        int indicePersonneRencontre;
        for (int i = 0; i < listPersonnages.size(); i++) {
            personnageQuiRencontre = listPersonnages.get(i);
            if (i < listPersonnages.size() - 1) {
                indicePersonneRencontre = i+1;
            } else {
                indicePersonneRencontre = 0;
            }
            personnageRencontre = listPersonnages.get(indicePersonneRencontre);
            personnageQuiRencontre.rencontrer(personnageRencontre);
            if (personnageRencontre.estMort()) {
                listPersonnages.remove(indicePersonneRencontre);
            }
        }
    }

    private void afficherPersonnage() {
        for (Personnage p : listPersonnages) {
            System.out.println(p.toString());
        }
    }

    private void initListePersonnage(int nb) {
        listPersonnages = new ArrayList<>();
        Personnage p;
        for (int i = 0; i < nb; i++) {
            p = getRandomPersonnage(tabNom[i % tabNom.length]);
            listPersonnages.add(p);
        }
    }

    private Personnage getRandomPersonnage(String nom) {
        Personnage p;
        int typePersonnage = Utilitaire.getRandomInRange(0, 1);
        int nbPtsVie = Utilitaire.getRandomInRange(10, 20);
        switch (typePersonnage) {
            case 0:
                p = new Paysan(nom, nbPtsVie);
                break;
            case 1:
                p = new Guerrier(nom, nbPtsVie);
                break;
            default:
                throw new RuntimeException("Erreur de no de personnage");
        }
        return p;
    }

    private void testerBasic() {
        Guerrier g1 = new Guerrier(tabNom[0], 10);
        Paysan pay1 = new Paysan(tabNom[1], 11);
        //   Personnage per1 = new Personnage(tabNom[2], 12); //on ne peut pas instancier une méthode classe abstraite

        System.out.println(g1);
        System.out.println(pay1);
        //       System.out.println(per1);

        g1.saluer(pay1);

        g1.rencontrer(pay1);
        System.out.println(pay1);
    }

    public static void main(String[] args) {
        new TestPersonnage();
    }
}
