package src.Exceptions;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException() {
        super();
    }

    public EmployeeNotFoundException(String s) {
        super(s);
    }
}
