package forme;

import java.util.ArrayList;

/**
 * @author Robert Aubé
 * @version 1.0 (Date de création: 2024-01-30)
 */
public class CarreApp {
    ArrayList <Carre> listeCarre;
    public CarreApp() {
        jouerAvecCarre();
    }

    private void remplirLaListe(int nbCarre, int coteMax) {
        int cote;
        for (int i = 0; i < nbCarre; i++) {
            // génération d'un entier >= 0 et <= coteMax
            cote = (int)(Math.random() * coteMax + 1);
            listeCarre.add(new Carre(cote));
        }
    }

    private void jouerAvecCarre() {
        listeCarre = new ArrayList<>();
        remplirLaListe(10, 5);
        afficherCarre();
    }

    private void afficherCarre() {
        for (Carre c: listeCarre) { //for each : Pour tous les carrés (ça peut seulement être ça)
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
new CarreApp();
    }
}
