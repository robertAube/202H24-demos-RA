package cours05_exception;

public class MonException extends Exception {
    public MonException() {
        super();
    }
    public MonException(String message) {
        super(message); //appeler le constructeur de la super Classe
    }
}
