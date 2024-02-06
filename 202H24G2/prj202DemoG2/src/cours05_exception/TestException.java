package cours05_exception;

public class TestException {
    public TestException() {
        try {
            provoquerUneException();
        } catch (MonException monException) {
            System.out.println(monException.getMessage());
        }
    }

    private void provoquerUneException() throws MonException {
        throw new MonException("Problème!");
    }

    public static void main(String[] args) {
        new TestException();
    }
}
