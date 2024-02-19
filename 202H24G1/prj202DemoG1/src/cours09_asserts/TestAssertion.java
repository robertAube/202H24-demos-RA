package cours09_asserts;

/**
 * @author Robert Aubé
 * @version 1.0
 */
public class TestAssertion {
    public TestAssertion() {
        jouerAvecAssert();
    }

    private void jouerAvecAssert() {
        Pizza p1 = new Pizza(1,1,"rouge", 4);
        Coordonnee c1 = new Coordonnee(2,2);
        Coordonnee cNull = null;

        System.out.println("p1 = " + p1);
        System.out.println("c1 = " + c1);

        System.out.println("p1 = " + p1);

    }


    public static void main(String[] args) {
        new TestAssertion();
    }
}
