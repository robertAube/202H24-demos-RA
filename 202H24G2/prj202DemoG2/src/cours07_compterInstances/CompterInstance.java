package cours07_compterInstances;

import java.util.ArrayList;

/**
 * Compter les instances de la classe Point.
 */

public class CompterInstance {

    public CompterInstance() {
        compterInstance();
        System.out.println("Après méthode Nb d'instance de point : " + Point.getNbInstanceCree());
    }

    private void compterInstance() {
        ArrayList<Point> listePoints1 = new ArrayList<Point>();
        ArrayList<Point> listePoints2 = new ArrayList<Point>();

        System.out.println("Nb d'instance de point : " + Point.getNbInstanceCree()); //0
        // Point.nbInstance += 1000; //heureusement ce n'est pas accessible

        for (int i = 0; i < 3; i++) {
            listePoints1.add(new Point(i, i + 1));
            listePoints2.add(new Point(i, i + 1));
            System.out.println("Nb d'instance de point : " + Point.getNbInstanceCree());
        }
        System.out.println("Nb d'instance de point : " + Point.getNbInstanceCree());

    }

    public static void main(String[] args) {
        new CompterInstance();
    }
}
