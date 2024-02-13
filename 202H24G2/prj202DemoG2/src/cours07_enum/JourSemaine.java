package cours07_enum;

public enum JourSemaine {
    /**
     * Valeurs que peut prendre le type enum JourSemaine
     */
    LUNDI("Monday", true), MARDI("Tuesday", true), MERCREDI("Wednesday", true), JEUDI("Thursday", true), VENDREDI("Friday", true), SAMEDI("Saturday", false), DIMANCHE("Sunday", false); //Norme: on emploie des majuscules

    private final String nomAnglais; //final : une fois initialisé, la valeur ne peut pas être changé

    private final boolean estTravaille;

    JourSemaine(String nomAnglais, boolean estTravaille) {
        this.nomAnglais = nomAnglais;
        this.estTravaille = estTravaille;
    }

    public String getNomAnglais() {
        return nomAnglais;
    }

    public boolean estTravaille() {
        return estTravaille;
    }

    public String getNom() {
        String nom = name(); //retourne le nom (selon la norm, c'est en majuscule)
        return nom.toLowerCase();
    }

    public String getAbreviation() {
        return getNom().substring(0, 3);
    }

    /**
     * Retourne le numéro de journée
     * lundi étant le jour 1
     * @return le numéro de journée
     */
    public int getNoJournee() {
        int position = ordinal(); //retourne la position (le premier étant à la position 0)
        return position + 1;
    }
}
