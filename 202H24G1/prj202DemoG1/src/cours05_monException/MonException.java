package cours05_monException;

/**
 * Faire sa propre classe d'exception
 */
public class MonException extends Exception {
    public MonException() {
        super();
    }

    public MonException(String message) {
        super(message);
    }
}
