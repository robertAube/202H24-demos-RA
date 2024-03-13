package cours09_interfaceComparable;

import _utilitaire.GestionFichier;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Robert Aubé
 * @version 1.0
 */
public class ListeEtudiants {
    ArrayList<Etudiant> listeEtudiants;
    ArrayList<String> strLignesFichier;

    public ListeEtudiants() {
        listeEtudiants = new ArrayList<>();
    }

    public void lireEtudiants() {
        lireEtudiants(GestionFichier.PATH_DEFAUT + "in.csv");
    }

    /**
     * Lire un fichier csv d'étudiants et placer chaque ligne valide dans...
     * - ArrayList<String> lignesFichier
     * - ArrayList<Etudiant> listeEtudiants
     *
     * @param nomFichier
     */
    public void lireEtudiants(String nomFichier) {
        Etudiant etudiant;
        strLignesFichier = new ArrayList<>();
        for (String ligne : GestionFichier.lireFichierTxtToArrayList(nomFichier)) {
            etudiant = getEtudiantFromLigne(ligne);
            if (etudiant != null) {
                strLignesFichier.add(ligne);
                listeEtudiants.add(etudiant);
            } else {
                System.out.println("ligne invalide : " + ligne);
            }
        }
    }

    public Etudiant getEtudiantFromLigne(String ligne) {
        Etudiant etudiant;
        String[] str = ligne.split(";");
        try {
            etudiant = new Etudiant(str[0], str[1], str[2]);
        } catch (IllegalArgumentException e) {
            etudiant = null;
        }
        return etudiant;
    }

    public void ajouterANote(int noteAAjouter) {
        float note;
        for (Etudiant e : listeEtudiants) {
            note = e.getNote() + noteAAjouter;
            note = note < Etudiant.NOTE_MIN ? Etudiant.NOTE_MIN : note;
            note = note > Etudiant.NOTE_MAX ? Etudiant.NOTE_MAX : note;
            e.setNote(note);
        }
    }

    public void ecrireEtudiants(String nomFichier) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Etudiant ligne : listeEtudiants) {
            stringBuilder.append(ligne + GestionFichier.LINE_SEPARATOR);
        }
        GestionFichier.ecrireFichierTexte(nomFichier, stringBuilder.toString());
    }

    public void trier() {

        listeEtudiants.sort(Comparator.naturalOrder());
        System.out.println("Trier:");
        for (Etudiant etudiant : listeEtudiants) {
            System.out.println(etudiant);
        }
    }

    public void trierOld() {

        strLignesFichier.sort(Comparator.naturalOrder());
        System.out.println("Trier:");
        for (String ligne : strLignesFichier) {
            System.out.println(ligne);
        }
    }

    @Override
    public String toString() {
        return listeEtudiants.toString();
    }
}
