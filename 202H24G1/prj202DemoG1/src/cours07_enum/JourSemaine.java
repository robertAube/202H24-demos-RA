package cours07_enum;

public enum JourSemaine {
    LUNDI("Monday", true), MARDI ("Tuesday", true), MERCREDI ("Wednesday", true), JEUDI ("Thursday", true), VENDREDI("Friday", true), SAMEDI("Saturday", true), DIMANCHE("Sunday", false);

    private final String nomAnglais; //attribut final : une fois initialisé, ça ne change pas
    /**
     * Est à vrai si c'est une journée travaillée.
     */
    private final boolean estTravaille;

    private JourSemaine(String nomAnglais, boolean estTravaille) {
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
        String nom = name(); //retourne le nom (selon la norme, c'est majuscule)
        return nom.toLowerCase();
    }

    public String getAbeviation() {
        return name().toLowerCase().substring(0,3);
    }

    /**
     * Retourne le numéro de la journée
     * @return le numéro de la journée
     */
    public int getNo(){
        int position = ordinal(); //retourne la position (le premier étant à la position 0).
        return position + 1;
    }
}
