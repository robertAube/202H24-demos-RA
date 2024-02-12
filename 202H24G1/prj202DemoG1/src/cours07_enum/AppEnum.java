package cours07_enum;

public class AppEnum {
    public AppEnum() {
        demoEnumSimple();
        demoEnumComplexe(JourSemaine.JEUDI);
        for (JourSemaine jSem : JourSemaine.values()) { //forEach
            demoEnumComplexe(jSem);
        }
    }

    public void demoEnumComplexe(JourSemaine jourSemaine) {
        System.out.println("name() " + jourSemaine.name());
        System.out.println("ordinal() " + jourSemaine.ordinal());
        System.out.println("getNom() " + jourSemaine.getNom());
        System.out.println("getNo() " + jourSemaine.getNo());
        System.out.println("getNomAnglais() " + jourSemaine.getNomAnglais());
        System.out.println("estTravaille() " + jourSemaine.estTravaille());
        System.out.println("getAbeviation() " + jourSemaine.getAbeviation());
    }

    private void demoEnumSimple() {
        JourSemaineEnumSimple jourSemaine;

        jourSemaine = JourSemaineEnumSimple.SAMEDI;

        System.out.println(jourSemaine);

        System.out.println(quelJour(jourSemaine));
    }

    public String quelJour(JourSemaineEnumSimple jSemaine) {
        String strJourSem = "";
        if (jSemaine == JourSemaineEnumSimple.DIMANCHE) {
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
