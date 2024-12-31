package src.Exceptions;

public class InvalidPriceException extends Exception {
    public InvalidPriceException() {
        super();
    }
    public InvalidPriceException(String s) {
        super(s);
    }
}
