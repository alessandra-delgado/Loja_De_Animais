package src.Classes_Loja;

import java.util.ArrayList;
import java.util.HashMap;

public class Purchase {
    private static int last_id = 0;
    private static HashMap<Integer, Integer> quant_prod_sold;
    private int id;
    private int total;
    private ArrayList<Product> products;

    public Purchase() {
        this.id = ++last_id;
        this.total = 0;
        products = new ArrayList<>();
        quant_prod_sold = new HashMap<>();
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

    public static HashMap<Integer, Integer> getQuant_prod_sold() {
        return quant_prod_sold;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public static void setQuant_prod_sold(HashMap<Integer, Integer> quant_prod_sold) {
        Purchase.quant_prod_sold = new HashMap<>(quant_prod_sold);
    }

    public void addProduct(Product p) {
        this.products.add(p);
        this.total += (int) p.getPrice();
        if ( quant_prod_sold.containsKey(p.getId()) ) {
            quant_prod_sold.put(p.getId(), quant_prod_sold.get(p.getId()) + 1);
        }else {
            quant_prod_sold.put(p.getId(), 1);
        }
    }

    public void removeProduct(Product p) {
        this.products.remove(p);
        this.total -= (int) p.getPrice();
        if ( quant_prod_sold.get(p.getId()) != 1 ) {
            quant_prod_sold.put(p.getId(), quant_prod_sold.get(p.getId()) - 1);
        }else {
            quant_prod_sold.remove(p.getId(), quant_prod_sold.get(p.getId()));
        }
    }

    public void removeProduct(int id) {
        this.products.remove(id);
        this.total -= (int) this.products.get(id).getPrice();
        if ( quant_prod_sold.get(id) != 1 ) {
            quant_prod_sold.put(id, quant_prod_sold.get(id) - 1);
        }else {
            quant_prod_sold.remove(id, quant_prod_sold.get(id));
        }
    }

    public void removeAllProducts() {
        for ( Product p : this.products ) {
            quant_prod_sold.remove(p.getId());
        }
        this.products.clear();
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