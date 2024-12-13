import java.util.ArrayList;

public class Purchase {
    private static int last_id = 0;
    private int id;
    private ArrayList<Product> products;

    public Purchase(){
        this.id = ++last_id;
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> get = new ArrayList<>();
        for(Product p : this.products){
            get.add(p);
        }
        return get;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public static Purchase getInstance() {
        return new Purchase();
    }

    public void addProducts(Product p){
        this.products.add(p);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase p = (Purchase) o;
        return this.id == p.id && this.products.equals(p.products); // does id comparison make sense?
    }

    public Object clone(){
        Purchase p = new Purchase();
        p.id = this.id; //?
        p.products = (ArrayList<Product>) this.products.clone();
        return p;
    }

    public String toString(){
        String str = "";
        str = "[id: " + this.id + " , products: " + this.products.toString() + " ]";
        return str;
    }
}