package cours16_gestionFichiers;

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
        System.out.println(listeContenants);

        lireListeContenants(PATH_DEFAUT + "contenant.bin");
        System.out.println(listeContenants);
    }

    public void sauverListeContenants(String nomFichier) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nomFichier);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(listeContenants);

            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lireListeContenants(String nomFichier) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nomFichier);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            listeContenants = (ListeContenants) objectInputStream.readObject();

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new SauverObjets();
    }
}
