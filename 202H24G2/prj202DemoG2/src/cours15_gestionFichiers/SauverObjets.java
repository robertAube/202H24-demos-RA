package cours15_gestionFichiers;

import java.io.*;

public class SauverObjets {
    private static char fSep = File.separatorChar;
    private static String PATH_DEFAUT = System.getProperty("user.dir") + fSep + "_fichiers" + fSep;

    private ListeContenants listeContenants;

    public SauverObjets() {
        listeContenants = new ListeContenants();
        System.out.println(listeContenants);
        sauverListeContenants(PATH_DEFAUT + "contenant.bin");
        listeContenants.clear();
        lireListeContenants(PATH_DEFAUT + "contenant.bin");
        System.out.println(listeContenants);
    }

    public void sauverListeContenants(String nomFichier) {

    }

    public void lireListeContenants(String nomFichier) {
    }

    public static void main(String[] args) {
        new SauverObjets();
    }
}
