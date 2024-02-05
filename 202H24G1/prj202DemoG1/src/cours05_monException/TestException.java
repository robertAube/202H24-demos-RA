package cours05_monException;

public class TestException {
    public TestException() {
        provoquerException();
    }

    private void provoquerException() {
        try {
            throw new MonException( "Problème!");
        } catch (MonException monException) {
            System.out.println(monException.getMessage());
        }
    }

    public static void main(String[] args) {
        new TestException();
    }
}
