package exemple4_Set;

import _utilitaire.Utilitaire;

import java.util.*;

public class Ex4_5AccesElements {
    public static final int NB_COORDONNEES = 1000000;
    public static final int NB_DE_GET = 50;
    private Set<Coordonnee>[] tabSet = new Set[]{
            new TreeSet<>(), //ordonné par clé
            new HashSet<>(), //sans ordre
            new LinkedHashSet<>() //
    };

    private Set<Coordonnee> setCoodonnees;
    private List<Coordonnee> listeDeCoordonnees;
    int nbDEchecDAjoutAuSet;

    public Ex4_5AccesElements() {
        long startTime;
        long tempsAjout, tempsRecherche;
        String strNomSet;

        remplirLArrayDeCoordonneesAletoire(NB_COORDONNEES);

        for (Set<Coordonnee> s : tabSet) {
            setCoodonnees = s;
            strNomSet = s.getClass().getSimpleName();
            System.out.println("########### " + strNomSet);

            startTime = new Date().getTime(); //Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
            ajouterCoordonneAuSet();
            tempsAjout = new Date().getTime() - startTime;
            System.out.println("Temps d'ajout d'éléments dans un " + strNomSet + ": " + tempsAjout + " millisecondes");

            startTime = new Date().getTime(); //Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
            testerRechercher(NB_DE_GET);
            tempsRecherche = new Date().getTime() - startTime;
            System.out.println("Temps de recherche pour " + NB_DE_GET * 2 + " éléments dans un " + strNomSet + ": " + tempsRecherche + " millisecondes");

            System.out.println("Temps total pour un " + strNomSet + ": " + tempsAjout + tempsRecherche + " millisecondes");

        }
    }

    private void remplirLArrayDeCoordonneesAletoire(int nbCoordonnees) {
        int x, y;

        listeDeCoordonnees = new ArrayList<>();
        for (int i = 0; i < nbCoordonnees; i++) {
            x = Utilitaire.getRandomInRange(Coordonnee.MIN_XY, Coordonnee.MAX_XY);
            y = Utilitaire.getRandomInRange(Coordonnee.MIN_XY, Coordonnee.MAX_XY);
            listeDeCoordonnees.add(new Coordonnee(x, y));
        }
    }

    private void testerRechercher(int nbTest) {
        nbTest = nbTest > setCoodonnees.size() ? setCoodonnees.size() : nbTest;
        for (int i = 0; i < nbTest; i++) { //On fait 2 recherches par itération
            getFromSet(listeDeCoordonnees.get(i));
            getFromSet(listeDeCoordonnees.get(nbTest - 1 - i));
        }
    }

    /**
     * Le Set en Java ne propose pas de méthode pour récupérer un élément par sa valeur.
     * Utilisez un itérateur pour parcourir les éléments et accéder à un élément qui vous intéresse.
     *
     * @param coordonneeCherche
     */
    private void getFromSet(Coordonnee coordonneeCherche) { //Pour
        Iterator<Coordonnee> it = setCoodonnees.iterator(); // Récupération de l'itérateur

        // Parcours des éléments
        while (it.hasNext()) {
            Coordonnee coordonneeDuSet = it.next();
            if (coordonneeCherche.equals(coordonneeDuSet)) {
                //   System.out.println("Élément : " + coordonneeDuSet);
            }
        }
    }

    private void ajouterCoordonneAuSet() {
        boolean succes;
        nbDEchecDAjoutAuSet = 0;

        for (Coordonnee coordonnneAAjouter : listeDeCoordonnees) {
            succes = setCoodonnees.add(coordonnneAAjouter);
            if (!succes) {
                System.out.println("Échec #" + ++nbDEchecDAjoutAuSet + " d'ajouter ce point " + coordonnneAAjouter);
            }
        }
        System.out.println("Il y a " + setCoodonnees.size() + " ajoutés à la " + setCoodonnees.getClass().getSimpleName() + '.');
    }

    public static void main(String[] args) {
        new Ex4_5AccesElements();
    }
}
