package cours16_gestionFichiers;

import java.io.File;
import java.io.IOException;

public class Demo_File {
    private static char fSep = File.separatorChar;
    private static String path = System.getProperty("user.dir") + fSep + "_fichiers" + fSep;

    public Demo_File() {
        String strNomFichier = path + "Denis.txt";
        testerGestionFichier(strNomFichier);
        testerGestionRepertoire(path + "repertoireTest");
    }

    private void testerGestionRepertoire(String repertoire) {
        File file = new File(repertoire); //Crée un path file

        System.out.println("file.getName() : " + file.getName());
        System.out.println("file.getPath() : " + file.getPath());
        System.out.println("file.getParent() : " + file.getParent());
        System.out.println("file.exists() : " + file.exists());

        System.out.println("On crée un répertoire : ");
        file.mkdir();

        System.out.println("file.exists() : " + file.exists());
        System.out.println("file.isDirectory() : " + file.isDirectory());
        System.out.println("file.isFile() : " + file.isFile());

        _utilitaire.GestionFichier.afficher(file.listFiles());

        _utilitaire.GestionFichier.afficher(new File(file.getParent()).listFiles());
    }

    private void testerGestionFichier(String strNomFichier) {
        try {
            File file = new File(strNomFichier); //Crée un path file
            System.out.println("file.getName() : " + file.getName());
            System.out.println("file.getPath() : " + file.getPath());
            System.out.println("file.getParent() : " + file.getParent());
            System.out.println("file.exists() : " + file.exists());

            System.out.println("On crée un fichier vide : ");
            file.createNewFile();

            System.out.println("file.exists() : " + file.exists());
            System.out.println("file.isDirectory() : " + file.isDirectory());
            System.out.println("file.isFile() : " + file.isFile());
            System.out.println("file.length() : " + file.length() + " octets");

            System.out.println("On supprime le fichier : ");
            file.delete();

            System.out.println("file.exists() : " + file.exists());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Demo_File();
    }

}
