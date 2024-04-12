package exemple5_Set;

import java.util.*;

public class Ex5_0UnionIntersectionDifference {
    public static void main(String[] args) {
        // Création d'un ensemble set1
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(7);
        set1.add(1);
        System.out.println("Ensemble 1 (set1): " + set1);

        // Création d'une liste d'entiers
        List<Integer> list = Arrays.asList(1, 7, 6, 8, 9); //Méthode static de Arrays qui retourne une ArrayList avec ce qui est reçu en argument

        // Création d'un ensemble set2 à partir de la liste
        Set<Integer> set2 = new TreeSet<>(list);
        System.out.println("Ensemble 2 (set2): " + set2);

        // Calcul de l'union entre set1 et set2
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Calcul de l'intersection entre set1 et set2
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Calcul de la différence entre set1 et set2
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);

        System.out.println("Union entre set1 et set2: " + union);
        System.out.println("Intersection entre set1 et set2: " + intersection);
        System.out.println("Différence entre set1 et set2 : " + difference);
    }
}
