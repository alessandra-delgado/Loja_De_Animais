public class Product {
    private static int last = 0;
    private int id;
    private double price;
    private String name;
    private String category;

    public Product(){
        this.id = ++last;
        this.price = 0;
        this.name = "";
        this.category = "";
    }
    public Product(String name, double price) {
        this.id = ++last;
        this.price = price;
        this.name = name;
        this.category = "";
    }

    public static int getLast() {
        return last;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}