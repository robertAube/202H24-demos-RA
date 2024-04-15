package exemple4_Set;

import java.util.*;

/**
 * - Set : TreeSet & HashSet
 * - méthodes : add(), remove(), contains()
 */
public class Ex4_1DemoSet {
    private Set<Integer>[] tabSet = new Set[]{
        new TreeSet<>(), //ordonné par clé
        new HashSet<>() //sans ordre
    };
    private Set<Integer> set;

    public Ex4_1DemoSet() {
        for (Set<Integer> s: tabSet){
            set = s;
            System.out.println("########### " + set.getClass().getSimpleName());
            peuplerLeSet(new int[]{7, 9, 1, 5, 4, 6, 3, 2, 5, 9, 9, 5});
            supprimerElement(5);
        }
    }

    public void supprimerElement(Integer element) {
        boolean estEfface;

        System.out.println("Avant suppression de " + element + " - " + this);
        estEfface = set.remove(element); //objet de valeur Integer(5)
        if (estEfface) {
            System.out.println("On a supprimé " + element);
        }
        System.out.println("Après suppression de " + element + " - " + this);

        if (!set.contains(element))
            System.out.println("On ne trouve pas " + element);
    }

    public void peuplerLeSet(int[] tab) {
        boolean estAjoute;
        String strAjoute = "";
        String strDejaPresent = "";

        //Utilisation de Arrays.toString() pour afficher le tableau
        System.out.println("On assaie de peupler le " + set.getClass().getSimpleName() +" avec: " + Arrays.toString(tab));

        for (int elementTab : tab) {
            estAjoute = set.add(elementTab);

            if (estAjoute)
                strAjoute += elementTab + " ";
            else
                strDejaPresent += elementTab + " ";
        }
        System.out.println("Les ajoutés = " + strAjoute);
        System.out.println("Les déjà présents = " + strDejaPresent);
    }

    @Override
    public String toString() { //Pourrait être fait avec un itérateur
        return set.getClass().getSimpleName() + set;
    }

    public static void main(String args[]) {
        new Ex4_1DemoSet();
    }
}
/**
 * Les ajoutés = 2 5 6 8 9
 * Les déjà présents = 2 5 5
 * ensemble = [2, 5, 6, 8, 9]
 * On a supprimé 5
 * ensemble = [2, 6, 8, 9]
 * On ne trouve pas 5
 */

