package _utilitaire;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Robert Aubé
 * @version 1.0 (Date de création: 2023-02-05)
 */
public class GestionFichier {
    public static final char FILE_SEPARATOR = File.separatorChar;
    public static final String PATH_DEFAUT = System.getProperty("user.dir") + FILE_SEPARATOR + "_fichiers" + FILE_SEPARATOR;
    public static final String LINE_SEPARATOR = System.getProperty("line.separator"); // Séparateur de ligne du système d'exploitation. Windows "\r\n", sous Unix "\n", MasOX "\r"

    /**
     * ÉCrit un fichier texte dans nomFichier
     * @param nomFichier nom du fichier
     * @param contenuFichier contenu du fichier
     */
    public static void ecrireFichierTexte(String nomFichier, String contenuFichier) {
        try {
            PrintWriter sortie = new PrintWriter(new FileWriter(nomFichier)); // ouverture du fichier
            sortie.print(contenuFichier); //écrire le texte
            sortie.flush(); //forcer l'écriture du buffer (à faire besoin)
            sortie.close(); //fermer le fichier
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    /**
     * Lit un fichier texte dans nomFichier
     * @param nomFichier nom du fichier
     */
    public static ArrayList<String> lireFichier(String nomFichier) {
        String ligne;
        ArrayList<String> temp = new ArrayList();

        try {
            BufferedReader entree = new BufferedReader(new FileReader(nomFichier));
            ligne = entree.readLine();
            while (ligne != null) {
                temp.add(ligne);
                ligne = entree.readLine();
            }
            entree.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return (temp);
    }

    /**
     * Écrit un fichier texte dans nomFichier.
     * Pour chaque Objet de l'ArrayList, on appelle le toString() et on l'ajoute à une ligne du fichier
     * @param lignes contenu du fichier. Chaque élément de lignes
     * @param nomFichier nom du fichier
     */
    public static void ecrireFichier(ArrayList<Object> lignes, String nomFichier) {
        try {
            PrintWriter sortie = new PrintWriter(new FileWriter(nomFichier));

            for (Object ligne : lignes) {
                sortie.println(ligne.toString());
            }
            sortie.close();
        } catch (IOException e) {
            System.out.println("Erreur de création de fichier");
        }
    }
}
