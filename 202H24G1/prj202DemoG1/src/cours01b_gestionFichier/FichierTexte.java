package cours01b_gestionFichier;

import java.io.File;

public class FichierTexte {
    private static char fileSeparator = File.separatorChar;
    private static String PATH_DEFAUT = System.getProperty("user.dir") + fileSeparator + "_fichiers";

    public FichierTexte() {
        afficherInfo();
    }

    private void afficherInfo() {
        System.out.println("fileSeparator : " + fileSeparator);
        System.out.println("PATH_DEFAUT : " + PATH_DEFAUT);
    }

    public static void main(String[] args) {
        new FichierTexte();
    }
}
