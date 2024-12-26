package src.ClassesLoja;

import src.Enum.ProductType;

import java.io.Serial;
import java.io.Serializable;

public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected static int last = 0;
    protected int id;
    protected double price;
    protected String name;
    protected ProductType category;
    protected int quantity;

    public Product() {
        this.id = ++last;
        this.price = 0;
        this.name = "";
        this.category = ProductType.NONE;
        this.quantity = 0;
    }

    public Product(String name, double price, int quantity) {
        this.id = ++last;
        this.price = price;
        this.name = name;
        this.category = ProductType.NONE;
        this.quantity = quantity;
    }

    // GETTERS ------------------------------------------------------------------------------------
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

    public ProductType getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    // SETTERS ------------------------------------------------------------------------------------
    public static void setLast(int last) {
        Product.last = last;
    }

    public void setCategory(ProductType category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // OVERRIDES ----------------------------------------------------------------------------------
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Product)) return false;

        Product p = (Product) obj;
        return p.getId() == this.getId() &&
                p.getPrice() == this.getPrice() &&
                p.getName().equals(this.getName()) &&
                p.getCategory().equals(this.getCategory()) &&
                p.getQuantity() == this.getQuantity();
    }

    public Object clone() {
        Product p = new Product();
        p.price = this.price;
        p.name = this.name;
        p.category = this.category;
        p.quantity = this.quantity;
        return p;
    }

    public String toString() {
        return "[ID: " + this.getId() + ", Price: " + this.getPrice() + ", Name: " + this.getName() + ", Categoria: " + this.category  + ", Quantidade:" + this.quantity +  "]";
    }
}