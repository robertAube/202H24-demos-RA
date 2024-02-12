
import java.util.ArrayList;

public class cours07_compterInstance {

    public cours07_compterInstance() {
        ArrayList<Point> listePoints1 = new ArrayList<Point>();
        ArrayList<Point> listePoints2 = new ArrayList<Point>();

        System.out.println("Nb d'instance de point : " + Point.getNbInstance()); //0

        for (int i = 0; i < 10; i++) {
            listePoints1.add(new Point(i, i+1));
            listePoints2.add(new Point(i, i+1));
            System.out.println("Nb d'instance de point : " + Point.getNbInstance()); //0
        }
        System.out.println("Nb d'instance de point : " + Point.getNbInstance()); //0

    }

    public static void main(String[] args) {
        new cours07_compterInstance();
    }
}
