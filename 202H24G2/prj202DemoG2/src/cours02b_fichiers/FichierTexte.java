package cours02b_fichiers;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class FichierTexte {
    private static final char FILE_SEPARATOR = File.separatorChar;
    private static final String PATH_DEFAUT = System.getProperty("user.dir") + FILE_SEPARATOR + "_fichiers" + FILE_SEPARATOR;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator"); //Séprateur de ligne d'un fichier texte du système d'exploitation. Windows "\r\n", sous Unix "\n", MacOS "\r"


    public FichierTexte() {
        // afficherInfo();

//        ecrireFichierTexte(PATH_DEFAUT + "text.txt", "bla bla bla" + LINE_SEPARATOR + "encore bla bla bla");
//        System.out.println(lireFichierTexte(PATH_DEFAUT + "text.txt"));

        lireAvecArrayList();
    }

    private void lireAvecArrayList() {
        ArrayList<String> lignesFichier;
        lignesFichier = lireLignesFichier(PATH_DEFAUT + "phrases.txt");

        afficherArrayListString(lignesFichier);
        lignesFichier.sort(Comparator.naturalOrder());
        afficherArrayListString(lignesFichier);
        lignesFichier.sort(Comparator.reverseOrder());
        afficherArrayListString(lignesFichier);
    }

    private void afficherArrayListString(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }


    private ArrayList<String> lireLignesFichier(String nomFichier) {
        ArrayList<String> contenuFichier = new ArrayList<>();
        String ligne;

        try {
            BufferedReader entree = new BufferedReader(new FileReader(nomFichier)); //Ouverture de fichier
            ligne = entree.readLine(); //lecture d'une ligne (vaut null si fin de fichier)
            while (ligne != null) { //Est-ce que je ne suis pas à la fin du fichier ?
                contenuFichier.add(ligne);
                ligne = entree.readLine(); //lecture d'une ligne
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        return contenuFichier;
    }

    private String lireFichierTexte(String nomFichier) {
        String contenuFichier = ""; //Devrait être un StringBuilder
        String ligne;

        try {
            BufferedReader entree = new BufferedReader(new FileReader(nomFichier)); //Ouverture de fichier
            ligne = entree.readLine(); //lecture d'une ligne (vaut null si fin de fichier)
            while (ligne != null) { //Est-ce que je ne suis pas à la fin du fichier ?
                contenuFichier += ligne + "\n";
                ligne = entree.readLine(); //lecture d'une ligne
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        return contenuFichier;
    }

    private void ecrireFichierTexte(String nomFichier, String contenuFichier) {
        try {
            PrintWriter sortie = new PrintWriter(new FileWriter(nomFichier)); // ouverture du fichier
            sortie.println(contenuFichier); //écrire le texte
            sortie.flush(); //forcer l'écriture du buffer (à faire besoin)
            sortie.close(); //fermer le fichier
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    private void afficherInfo() {
        System.out.println("FILE_SEPARATOR : " + FILE_SEPARATOR);
        System.out.println("PATH_DEFAUT : " + PATH_DEFAUT);
        System.out.println("LINE_SEPARATOR : \"" + LINE_SEPARATOR + '"');
    }

    public static void main(String[] args) {
        new FichierTexte();
    }
}
