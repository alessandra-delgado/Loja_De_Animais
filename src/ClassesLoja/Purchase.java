package src.ClassesLoja;

import src.Exceptions.ProductStockExceeded;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Purchase implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static int last_id = 0;
    private int id;
    private double total;
    private ArrayList<Product> products;
    private LocalDateTime purchase_time;

    public Purchase() {
        this.id = ++last_id;
        this.total = 0.0;
        products = new ArrayList<>();
        purchase_time = LocalDateTime.now();
    }

    public static int getLast() {
        return Purchase.last_id;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(this.products);
    }

    public LocalDateTime getPurchase_time() {
        return purchase_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setLast(int last_id) {
        Purchase.last_id = last_id;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setPurchase_time(LocalDateTime purchase_time) {
        this.purchase_time = purchase_time;
    }

    public void addProduct(Product p) throws ProductStockExceeded {
        p.decrementQuantity();
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
        this.total -= this.products.get(id).getPrice();
        this.products.get(id).incrementQuantity();
        this.products.remove(id);
        this.total -= (int) this.products.get(id).getPrice();
    }

    public void removeAllProducts() {
        for (Product p : this.products) {
            p.incrementQuantity();
            // Given that remove() removes the first instance of given object in an ArrayList,
            // removing each product for each iteration would not work if repeated products
            // are contained in the list
        }
        this.products.clear();
        this.total = 0.0;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase p)) return false;
        return this.id == p.id && this.products.equals(p.products) && this.total == p.total && this.purchase_time.equals(p.purchase_time); // does id comparison make sense?
    }

    public Object clone() {
        Purchase p = new Purchase();
        p.id = this.id; //?
        p.total = this.total;
        p.purchase_time = this.purchase_time;
        p.products = (ArrayList<Product>) this.products.clone();
        return p;
    }

    public String toString() {
        return "[id: " + this.id + " , products: " + this.products.toString() + ", total: " + this.total + " ]";
    }
}