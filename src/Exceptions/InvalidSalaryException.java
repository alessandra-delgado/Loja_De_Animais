package src.Exceptions;

public class InvalidSalaryException extends RuntimeException {
    public InvalidSalaryException(String message) {
        super(message);
    }
}
