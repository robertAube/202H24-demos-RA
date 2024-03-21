package cours19_gestionFichiers;

import java.io.*;

public class SauverObjets {
    private static char fSep = File.separatorChar;
    private static String PATH_DEFAUT = System.getProperty("user.dir") + fSep + "_fichiers" + fSep;

    private ListeContenants listeContenants;

    public SauverObjets() {
        listeContenants = new ListeContenants();
        System.out.println(listeContenants);
//        sauverListeContenants(PATH_DEFAUT + "contenant.bin");
        sauverListeContenants(new File(PATH_DEFAUT + "contenant.bin"));
        listeContenants.clear();
        lireListeContenants(PATH_DEFAUT + "contenant.bin");
        System.out.println(listeContenants);
    }

    public void sauverListeContenants(File nomFichier) {
        sauverListeContenants(nomFichier.getPath());
    }

    public void sauverListeContenants(String nomFichier) {
        try {
            //ouverture
            FileOutputStream fileOutputStream = new FileOutputStream(nomFichier);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(listeContenants);

            objectOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void lireListeContenants(String nomFichier) {

        try {
            FileInputStream fileInputStream = new FileInputStream(nomFichier);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            listeContenants = (ListeContenants) objectInputStream.readObject();

            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SauverObjets();
    }
}
