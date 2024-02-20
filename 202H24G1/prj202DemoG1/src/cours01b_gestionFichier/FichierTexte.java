package cours01b_gestionFichier;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class FichierTexte {
    private static final char FILE_SEPARATOR = File.separatorChar;
    private static final String PATH_DEFAUT = System.getProperty("user.dir") + FILE_SEPARATOR + "_fichiers" + FILE_SEPARATOR;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator"); // Séparateur de ligne du système d'exploitation. Windows "\r\n", sous Unix "\n", MasOX "\r"

    public FichierTexte() {
        afficherInfo();
       // ecrireDansUnFichier("test.txt", "bla bla bla" + LINE_SEPARATOR + "test");
       // System.out.println(lireTexteDansUnFichier("test.txt"));

       tester_lectureAvecArrayList();


//        System.out.println(motsDansUneString("Tirer son chapeau à quelqu’un"));
    }

    private String motsDansUneString(String mots) {
        String motSepareParUnSautDeLigne = "";
        String tabMots[];

        tabMots = mots.split(" ");
        for (int i = 0; i < tabMots.length; i++) {
            motSepareParUnSautDeLigne += tabMots[i] + "\n";
        }

        return motSepareParUnSautDeLigne;
    }

    private void tester_lectureAvecArrayList() {
        ArrayList<String> lignesFichier;

        lignesFichier = lireLignesFichier("test.txt");

        for (int i = 0; i < lignesFichier.size(); i++) {
            System.out.println(lignesFichier.get(i));
        }

        lignesFichier.sort(Comparator.naturalOrder());

        for (int i = 0; i < lignesFichier.size(); i++) {
            System.out.println(lignesFichier.get(i));
        }

    }

    private ArrayList<String> lireLignesFichier(String nomFichier) {
        ArrayList<String> contenuFichier = new ArrayList<>();
        String ligne = "";
        try {
            BufferedReader entree = new BufferedReader(new FileReader(PATH_DEFAUT + nomFichier)); //Ouverture de fichier
            ligne = entree.readLine(); //lecture d'une ligne
            while (ligne != null) { // Est-ce que je suis à la fin du fichier
                contenuFichier.add(ligne);
                ligne = entree.readLine(); //lecture d'une ligne
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return contenuFichier;
    }

    private String lireTexteDansUnFichier(String nomFichier) {
        String contenuFichier = "";
        String ligne = "";
        try {
            BufferedReader entree = new BufferedReader(new FileReader(PATH_DEFAUT + nomFichier)); //Ouverture de fichier
            ligne = entree.readLine(); //lecture d'une ligne
            while (ligne != null) { // Est-ce que je suis à la fin du fichier
                contenuFichier += ligne + "\n";
                ligne = entree.readLine(); //lecture d'une ligne
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return contenuFichier;
    }

    private void ecrireDansUnFichier(String nomFichier, String informationAEcrire) {
        try {
            PrintWriter sortie = new PrintWriter(new FileWriter(PATH_DEFAUT + nomFichier)); //ouverture de fichier
            sortie.println(informationAEcrire); //écrire le texte
            sortie.flush(); //force l'écriture du buffer (à faire au besoin)
            sortie.close(); //fermeture du fichier
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void afficherInfo() {
        System.out.println("FILE_SEPARATOR : " + FILE_SEPARATOR);
        System.out.println("PATH_DEFAUT : " + PATH_DEFAUT);
        System.out.println("LINE_SEPARATOR : \"" + LINE_SEPARATOR + "\"");
    }

    public static void main(String[] args) {
        new FichierTexte();
    }
}
