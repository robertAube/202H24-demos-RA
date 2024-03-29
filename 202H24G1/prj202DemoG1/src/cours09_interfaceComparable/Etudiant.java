package cours09_interfaceComparable;

import java.util.regex.Pattern;

/**
 * @author Robert Aubé
 * @version 1.0
 */
public class Etudiant implements Comparable<Etudiant> {
    public static final int LGR_NODA = 7;
    public static final int NOTE_MIN = 0;
    public static final int NOTE_MAX = 100;

    private String noDA;
    private String nom;
    private float note;

    public Etudiant(String noDA, String nom, float note) {
        setNoDA(noDA);
        setNom(nom);
        setNote(note);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     */
    public int compareTo(Etudiant etudiant) {
        int valeurComparaison;
//        valeurComparaison = compareToParNom(etudiant);
        valeurComparaison = compareToParNote(etudiant);

        return valeurComparaison;
    }

    private int compareToParNote(Etudiant etudiant) {
        int valeurComparaison;
        valeurComparaison = (int) (note - etudiant.note);

        return valeurComparaison;
    }

    private int compareToParNom(Etudiant etudiant) {
        int valeurComparaison;
        valeurComparaison = nom.compareTo(etudiant.nom);

        return valeurComparaison;
    }


    public Etudiant(String noDA, String nom, String note) {
        this(noDA, nom, Float.parseFloat(note));
    }

    public void setNoDA(String noDA) {
        if (noDa_estValide(noDA)) {
            this.noDA = noDA;
        } else
            throw new IllegalArgumentException("DA invalide : " + noDA);
    }

    public void setNom(String nom) {
        if (nom_estValide(nom)) {
            this.nom = nom.trim();
        } else
            throw new IllegalArgumentException("Nom invalide : " + nom);
    }

    public void setNote(float note) {
        if (note_estValide(note)) {
            this.note = note;
        } else
            throw new IllegalArgumentException("Note invalide : " + note);
    }

    public String getNom() {
        return nom;
    }

    public float getNote() {
        return note;
    }

    public String getNoDA() {
        return noDA;
    }

    public static boolean noDa_estValide(String noDA) {
        try {
            Integer.parseInt(noDA);
        } catch (NumberFormatException numberFormatException) {
            return (false);
        }

        return (noDA.length() == LGR_NODA);
    }

    public static boolean nom_estValide(String nom) {
        boolean estValide = true;
        if (nom == null)
            estValide =  false;
        else if (nom.length() == 0)
            estValide =  false;
        else if (aDesCarInvalides(nom)) {
            estValide =  false;
        }

        return estValide;
    }

    private static boolean aDesCarInvalides(String nom) {
        boolean carInvalide = false;
        String listeCarInvalides = "\"0123456789+-!|#/$%?&*()=[]<>½¾^¶;:¤¢`~«°».";
        char c;
        for (int i = 0; i < nom.length() && !carInvalide; i++) {
            c = nom.charAt(i);
            if (listeCarInvalides.contains("" + c)) {
                carInvalide = true;
            }
        }

        return carInvalide;
    }

    public static boolean note_estValide(double note) {
        return (NOTE_MIN <= note && note <= NOTE_MAX);
    }

    /**
     * Présenté en format csv
     * @return
     */
    @Override
    public String toString() {
        return noDA + ";" + nom + ";" + note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etudiant etudiant = (Etudiant) o;

        if (!noDA.equals(etudiant.noDA)) return false;
        if (Float.compare(etudiant.note, note) != 0) return false;
        return nom != null ? nom.equals(etudiant.nom) : etudiant.nom == null;
    }
}
