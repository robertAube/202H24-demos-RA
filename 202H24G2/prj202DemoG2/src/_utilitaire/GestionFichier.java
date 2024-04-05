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
     * Écrit un fichier texte dans un fichier dont le nom est nomFichier
     *
     * @param nomFichier     nom du fichier
     * @param contenuFichier contenu du fichier
     */
    public static void ecrireFichierTexte(String nomFichier, String contenuFichier) {
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(nomFichier));
            bufferedWriter.write(contenuFichier);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Lit un fichier texte dont le nom est nomFichier et le retourne dans une String
     *
     * @param nomFichier nom du fichier
     * @return un ArrayList où chaque ligne du fichier est placé en ordre dans chaque élément de l'ArrayList
     */
    public static String lireFichierTexte(String nomFichier) {
        String ligne;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader entree = null;

        try {
            entree = new BufferedReader(new FileReader(nomFichier));
            ligne = entree.readLine();
            while (ligne != null) {
                stringBuilder.append(ligne);
                ligne = entree.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entree != null) {
                try {
                    entree.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Écrit un fichier texte dans nomFichier.
     * Pour chaque Objet de l'ArrayList, on appelle le toString() et on l'ajoute à une ligne du fichier
     *
     * @param lignes     contenu du fichier. Chaque élément de lignes
     * @param nomFichier nom du fichier
     */
    public static void ecrireFichierTexte(ArrayList<Object> lignes, String nomFichier) {
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

    /**
     * Lit un fichier texte nomFichier et le place dans un ArrayList
     *
     * @param nomFichier nom du fichier
     * @return un ArrayList où chaque ligne du fichier est placé en ordre dans chaque élément de l'ArrayList
     */
    public static ArrayList<String> lireFichierTxtToArrayList(String nomFichier) {
        String ligne;
        ArrayList<String> arrayList = new ArrayList();
        BufferedReader entree = null;

        try {
            entree = new BufferedReader(new FileReader(nomFichier));
            ligne = entree.readLine();
            while (ligne != null) {
                arrayList.add(ligne);
                ligne = entree.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entree != null) {
                try {
                    entree.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static void afficher(String[] tabInt) {
        System.out.print('{');
        for (int i = 0; i < tabInt.length; i++) {
            System.out.print(tabInt[i] + ((tabInt.length - 1 == i) ? "" : ", ")); // lire la valeur à l'index i
        }
        System.out.println('}');
    }

    public static void afficher(File[] files) {
        System.out.print('{');
        for (int i = 0; i < files.length; i++) {
            System.out.print(files[i].getName() + ((files.length - 1 == i) ? "" : ", ")); // lire la valeur à l'index i
        }
        System.out.println('}');
    }

    public static String[] lireFichier(String nomFichier) {
        return new String[2];
    }
}
