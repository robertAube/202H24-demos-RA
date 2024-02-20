package cours09_interfaceComparable;

public class TesterCompareTo {

    public TesterCompareTo() {
        testerCompareTo("aaaa", "bbbb");
        testerCompareTo("bbbb", "bbbb");
        testerCompareTo("bbb", "bbbb");
        testerCompareTo("cccc", "bbbb");

        //  testerCompareTo(new Etudiant("1234567", "Jean Boulanger", 77.2f), new Etudiant("1234567", "Jean Boulanger", 77.2f));
        //  testerCompareTo(new Etudiant("1234567", "Jean Boulanger", 77.2f), new Etudiant("1234567", "David Boulanger", 77.2f));
        //  testerCompareTo(new Etudiant("1234567", "David Boulanger", 77.2f), new Etudiant("1234567", "Jean Boulanger", 77.2f));
        //  testerCompareTo(new Etudiant("1234567", "Jean Boulanger", 77.2f), new Etudiant("1234567", "Jean Boulanger", 78.2f));
        //  testerCompareTo(new Etudiant("1234567", "Jean Boulanger", 78.2f), new Etudiant("1234567", "David Boulanger", 77.2f));
    }

    public static void testerCompareTo(Comparable v1, Comparable v2) {
        int comparaison = v1.compareTo(v2);
        if (comparaison == 0 ) {
            System.out.println(v1 + " = " + v2);
        } else if (comparaison < 0) {
            System.out.println(v1 + " < " + v2);
        } else {
            System.out.println(v1 + " > " + v2);
        }
    }

    public static void main(String[] args) {
        new TesterCompareTo();
    }
}
