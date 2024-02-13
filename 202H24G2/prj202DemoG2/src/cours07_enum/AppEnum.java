package cours07_enum;

public class AppEnum {
    public AppEnum() {
//        demoEnumSimple();
//        System.out.println(quelJour(JourSemaineSimple.MERCREDI));
//
//        afficherInfoJournee(JourSemaine.VENDREDI);

        for (JourSemaine jreSem: JourSemaine.values()) { //JourSemaine.values() représente toutes les valeurs du type enum
            afficherInfoJournee(jreSem);
            System.out.println("*******");
        }
    }

    private void afficherInfoJournee(JourSemaine jSemaine) {
        System.out.println("name() : " + jSemaine.name());
        System.out.println("ordinal() : " + jSemaine.ordinal());
        System.out.println("getNom()) : " + jSemaine.getNom());
        System.out.println("getAbreviation() : " + jSemaine.getAbreviation());
        System.out.println("getNomAnglais() : " + jSemaine.getNomAnglais());
        System.out.println("getNoJournee() : " + jSemaine.getNoJournee());
        System.out.println("estTravaille() : " + jSemaine.estTravaille());
    }

    private void demoEnumSimple() {
        JourSemaineSimple jourSemaine;
        jourSemaine = JourSemaineSimple.MARDI;
        System.out.println(jourSemaine); //Affiche : MARDI
        System.out.println(jourSemaine.ordinal()); //MARDI est le numéro 1, comme lundi est le numéro 0
        System.out.println(jourSemaine.name()); //Affiche : MARDI
    }

    public String quelJour(JourSemaineSimple jSemaine) {
        String strJourSem = "";

        if (jSemaine == JourSemaineSimple.DIMANCHE) {
            strJourSem = "dimanche";
        }

        switch (jSemaine) {
            case LUNDI:
                strJourSem = "lundi";
                break;
            case MARDI:
                strJourSem = "mardi";
                break;
            case MERCREDI:
                strJourSem = "mercredi";
                break;
            case JEUDI:
                strJourSem = "jeudi";
                break;
            case VENDREDI:
                strJourSem = "vendredi";
                break;
            case SAMEDI:
                strJourSem = "samedi";
                break;
            case DIMANCHE:
                strJourSem = "dimanche";
                break;
        }
        return strJourSem;
    }

    public static void main(String[] args) {
        new AppEnum();
    }
}
