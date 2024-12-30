package src.Exceptions;

public class InvalidProductQuantityException extends RuntimeException {
    public InvalidProductQuantityException() {
        super();
    }
    public InvalidProductQuantityException(String s) {
        super(s);
    }
}
