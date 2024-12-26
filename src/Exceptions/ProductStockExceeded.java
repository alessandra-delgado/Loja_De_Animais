package src.Exceptions;

public class ProductStockExceeded extends Exception {
    public ProductStockExceeded() {
        super();
    }
    public ProductStockExceeded(String s) {
        super(s);
    }
}
