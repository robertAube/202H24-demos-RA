package cours09_interfaceComparable;
import _utilitaire.GestionFichier;

/**
 * @author Robert Aubé
 * @version 1.0
 */
public class ListeEtudiantTest {

    private ListeEtudiants listeEtudiants;
    public ListeEtudiantTest() {
        listeEtudiants = new ListeEtudiants();

        listeEtudiants.lireEtudiants(GestionFichier.PATH_DEFAUT + "etudiantsIn.csv"); //lit un fichier
        listeEtudiants.trier(); //trie les éléments de la structure par ligne ascendante
        System.out.println(listeEtudiants.toString()); //affiche les données de la structure
        listeEtudiants.ajouterANote(10); //ajoute la note passée en argument aux étudiants de la structure
        listeEtudiants.ecrireEtudiants(GestionFichier.PATH_DEFAUT + "etudiantsOut+10.csv"); //écrit le fichier
        listeEtudiants.ajouterANote(-20); //ajoute la note passée en argument aux étudiants de la structure
        listeEtudiants.ecrireEtudiants(GestionFichier.PATH_DEFAUT + "etudiantsOut-10.csv"); //écrit le fichier
    }

    public static void main(String[] args) {
        new ListeEtudiantTest();
    }
}
