package cours23_jSon;
// https://repo1.maven.org/maven2/com/google/code/gson/gson/2.9.1/

import java.io.*;

public class SauverJSON {
    private static char fSep = File.separatorChar;
    private static String PATH_DEFAUT = System.getProperty("user.dir") + fSep + "_fichiers" + fSep;

    private cours15_gestionFichiers.ListeContenants listeContenants;

    public SauverJSON() {
        listeContenants = new cours15_gestionFichiers.ListeContenants();
        System.out.println(listeContenants);
        sauverListeContenants(PATH_DEFAUT + "contenants.json");
        listeContenants.clear();
        lireListeContenants(PATH_DEFAUT + "contenants.json");
        System.out.println(listeContenants);
    }

    public void sauverListeContenants(String nomFichier) {

    }

    public void lireListeContenants(String nomFichier) {
    }

    public static void main(String[] args) {
        new SauverJSON();
    }
}
