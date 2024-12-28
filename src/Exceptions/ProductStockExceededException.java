package src.Exceptions;

public class ProductStockExceededException extends Exception {
    public ProductStockExceededException() {
        super();
    }
    public ProductStockExceededException(String s) {
        super(s);
    }
}
