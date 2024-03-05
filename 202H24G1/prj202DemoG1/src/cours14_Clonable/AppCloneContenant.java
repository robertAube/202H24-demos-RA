package cours14_Clonable;

/*
420-202 – TP2 – Traitement de données orienté objet
*/
public class AppCloneContenant implements Cloneable {
    private static Liquide eau = new Liquide("eau", 1000);
    private static Liquide lait = new Liquide("lait", 1030);
    public AppCloneContenant() {
       // sansVraimentCloner();
        testerCloner();
    }

    private void testerCloner() {
        System.out.println("testerCloner()");
        ContenantLiquide pipette1 = new ContenantLiquide("pipette1", eau, 150, 100);
        ContenantLiquide pipette2 = null;
        System.out.println("pipette1 : " + pipette1);

        try {
            pipette2 = (ContenantLiquide) pipette1.clone();
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            System.out.println("Erreur : " + cloneNotSupportedException.getMessage());
        }

        System.out.println("pipette2 : " + pipette2);

        pipette2.setNom("pipette2");
        pipette2.setLiquide(lait);
        System.out.println("pipette1 : " + pipette1);
        System.out.println("pipette2 : " + pipette2);
    }


    private void sansVraimentCloner() {
        System.out.println("sansVraimentCloner()");
        ContenantLiquide pipette1 = new ContenantLiquide("pipette1", eau, 150, 100);
        ContenantLiquide pipette2;
        System.out.println("pipette1 : " + pipette1);

        pipette2 = pipette1;

        System.out.println("pipette2 : " + pipette2);

        pipette2.setNom("pipette2");
        pipette2.setLiquide(lait);
        System.out.println("pipette1 : " + pipette1);
        System.out.println("pipette2 : " + pipette2);
    }

    public static void main(String[] args) {
        new AppCloneContenant();
    }
}
