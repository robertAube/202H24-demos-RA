package cours09_interfaceComparable;

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
    public int compareTo(Etudiant etudiant) {
        float valeurComparaison;

        valeurComparaison = this.nom.compareTo(etudiant.nom);
        if (valeurComparaison == 0) {
//            valeurComparaison = (this.note - etudiant.note);
//            valeurComparaison = valeurComparaison < 0 ? -1 : 1;
            /**
             * Returns the signum function of the argument; zero if the argument
             * is zero, 1.0f if the argument is greater than zero, -1.0f if the
             * argument is less than zero.
             */
            valeurComparaison = Math.signum(this.note - etudiant.note);
        }

        return (int) valeurComparaison;
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
