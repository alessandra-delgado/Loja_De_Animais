import java.util.ArrayList;

public class Purchase {
    private static int last_id = 0;
    private int id;
    private int total;
    private ArrayList<Product> products;

    public Purchase(){
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
        return (ArrayList<Product>) new ArrayList<>(this.products);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p){
        this.products.add(p);
        this.total += (int) p.getPrice();
    }

    public void removeProduct(Product p){
        this.products.remove(p);
        this.total -= (int) p.getPrice();
    }

    public void removeProduct(int id){
        this.products.remove(id);
        this.total -= (int) this.products.get(id).getPrice();
    }

    public void removeAllProducts(){
        this.products.clear();
        this.total = 0;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase p = (Purchase) o;
        return this.id == p.id && this.products.equals(p.products) && this.total == p.total; // does id comparison make sense?
    }

    public Object clone(){
        Purchase p = new Purchase();
        p.id = this.id; //?
        p.products = (ArrayList<Product>) this.products.clone();
        return p;
    }

    public String toString(){
        String str = "";
        str = "[id: " + this.id + " , products: " + this.products.toString() + ", total: " + this.total + " ]";
        return str;
    }
}