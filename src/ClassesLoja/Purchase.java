package src.ClassesLoja;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Purchase implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static int last_id = 0;
    private int id;
    private int total;
    private ArrayList<Product> products;

    public Purchase() {
        this.id = ++last_id;
        this.total = 0;
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(this.products);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        this.total += (int) p.getPrice();
        this.products.add(p);
        this.total += (int) p.getPrice();
    }

    public void removeProduct(Product p) {
        this.total -= (int) p.getPrice();
        this.products.get(id).incrementQuantity();
        this.products.remove(p);
        this.total -= (int) p.getPrice();
    }

    public void removeProduct(int id) {
        this.total -= (int) this.products.get(id).getPrice();
        this.products.get(id).incrementQuantity();
        this.products.remove(id);
        this.total -= (int) this.products.get(id).getPrice();
    }

    public void removeAllProducts() {
        for (Product p : this.products) {
            p.incrementQuantity();
            this.products.remove(p);
        }
        this.total = 0;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase p = (Purchase) o;
        return this.id == p.id && this.products.equals(p.products) && this.total == p.total; // does id comparison make sense?
    }

    public Object clone() {
        Purchase p = new Purchase();
        p.id = this.id; //?
        p.products = (ArrayList<Product>) this.products.clone();
        return p;
    }

    public String toString() {
        return "[id: " + this.id + " , products: " + this.products.toString() + ", total: " + this.total + " ]";
    }
}