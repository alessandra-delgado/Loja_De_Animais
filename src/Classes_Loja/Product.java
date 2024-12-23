package src.Classes_Loja;

import src.Enum.ProductType;

public class Product {
    protected static int last = 0;
    protected int id;
    protected double price;
    protected String name;
    protected ProductType category;

    public Product() {
        this.id = ++last;
        this.price = 0;
        this.name = "";
        this.category = ProductType.NONE;
    }

    public Product(String name, double price) {
        this.id = ++last;
        this.price = price;
        this.name = name;
        this.category = ProductType.NONE;
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

    // SETTERS ------------------------------------------------------------------------------------
    public void setCategory(ProductType category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // OVERRIDES ----------------------------------------------------------------------------------
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Product)) return false;

        Product p = (Product) obj;
        return p.getId() == this.getId() &&
                p.getPrice() == this.getPrice() &&
                p.getName().equals(this.getName()) &&
                p.getCategory().equals(this.getCategory());
    }

    public Object clone() {
        Product p = new Product();
        p.price = this.price;
        p.name = this.name;
        p.category = this.category;
        return p;
    }

    public String toString() {
        return "[ID: " + this.getId() + ", Price: " + this.getPrice() + ", Name: " + this.getName() + ", Categoria: " + this.category + "]";
    }
}