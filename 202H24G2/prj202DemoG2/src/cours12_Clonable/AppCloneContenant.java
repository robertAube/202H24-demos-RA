package cours12_Clonable;

import java.util.concurrent.Callable;

/*
420-202 – TP2 – Traitement de données orienté objet
*/
public class AppCloneContenant {
    private static Liquide eau = new Liquide("eau", 1000);
    private static Liquide lait = new Liquide("lait", 1030);
    public AppCloneContenant() {
        sansVraimentCloner();
        clonerPipette();
    }

    private void clonerPipette() {
        System.out.println("clonerPipette()");
        ContenantLiquide pipette1 = new ContenantLiquide("pipette1", eau, 150, 100);
        ContenantLiquide pipette2 = null;
        System.out.println("pipette1 : " + pipette1);

        try {
            pipette2 = pipette1.cloneSurface();
        } catch (CloneNotSupportedException e)  {
            System.out.println(e.getMessage());
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
    }

    public static void main(String[] args) {
        new AppCloneContenant();
    }
}
