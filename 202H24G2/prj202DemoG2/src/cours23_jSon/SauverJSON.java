package cours23_jSon;
// https://repo1.maven.org/maven2/com/google/code/gson/gson/2.9.1/

import _utilitaire.GestionFichier;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class SauverJSON {
    private static char fSep = File.separatorChar;
    private static String PATH_DEFAUT = System.getProperty("user.dir") + fSep + "_fichiers" + fSep;

    private ListeContenants listeContenants;

    public SauverJSON() {
        listeContenants = new ListeContenants();
       // System.out.println(listeContenants);
        sauverListeContenants(PATH_DEFAUT + "contenants.json");
        listeContenants.clear();
        lireListeContenants(PATH_DEFAUT + "contenants.json");
        System.out.println(listeContenants);
    }

    public void sauverListeContenants(String nomFichier) {
        Gson json;
        String strJson;

        json = new Gson();
        json = new GsonBuilder().setPrettyPrinting().create();
        strJson = json.toJson(listeContenants);

        System.out.println(strJson);

        GestionFichier.ecrireFichierTexte(nomFichier, strJson);
    }

    public void lireListeContenants(String nomFichier) {
        Gson json = new Gson();
        String contenuFichier;

        contenuFichier = GestionFichier.lireFichierTexte(nomFichier);
        listeContenants = json.fromJson(contenuFichier, ListeContenants.class);
    }

    public static void main(String[] args) {
        new SauverJSON();
    }
}
