package cours07_compterInstances;

import java.util.ArrayList;

/**
 * Compter les instances de la classe Point.
 */

public class CompterInstance {

    public CompterInstance() {
        ArrayList<Point> listePoints1 = new ArrayList<Point>();
        ArrayList<Point> listePoints2 = new ArrayList<Point>();

        System.out.println("Nb d'instance de point : "); //0

        for (int i = 0; i < 10; i++) {
            listePoints1.add(new Point(i, i + 1));
            listePoints2.add(new Point(i, i + 1));
            System.out.println("Nb d'instance de point : ");
        }
        System.out.println("Nb d'instance de point : ");

    }

    public static void main(String[] args) {
        new CompterInstance();
    }
}
