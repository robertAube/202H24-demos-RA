package _utilitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Utilitaire {
    public static Random r = new Random();
    private static final char fSep = File.separatorChar;
    public static final String REPERTOIRE_PROJET_FICHIERS = System.getProperty("user.dir") + fSep + "fichiers" + fSep;

    public static String lireString(String question) {
        Scanner sc;
        String reponse;

        sc = new Scanner(System.in);

        System.out.print(question);
        reponse = sc.nextLine();

        return reponse;
    }


    public static int lireInt(String question) {
        String reponse;
        int reponseInt;

        reponse = lireString(question);
        reponseInt = Integer.parseInt(reponse);

        return reponseInt;
    }

    public static int getRandomInRange(int min, int max) {
        return r.nextInt((max - min) + 1) + min;
    }

    public static double getRandomInRange(double min, double max) {
        double x = (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public static void saveTextToFile(String strToSave, String filePath) {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println(strToSave);
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé : " + filePath);;
        }
    }
}
