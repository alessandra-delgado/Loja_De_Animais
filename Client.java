import java.util.ArrayList;

public class Client extends Person{
    private int totalSpent;
    private ArrayList<Purchase> purchases;

    public Client(){
        super();
        this.totalSpent = 0;
        this.purchases = new ArrayList<>();
    }

    public Client(String name, int nif, int tel, int totalSpent){
        super(name, nif, tel);
        this.totalSpent = totalSpent;
        this.purchases = new ArrayList<>();
    }

    public Client(Person p, int totalSpent){
        super(p.name, p.gender, p.birthdate, p.tel, p.nif);
        this.totalSpent = totalSpent;
    }

    public int getTotalSpent(){
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent){
        this.totalSpent = totalSpent;
    }

    public ArrayList<Purchase> getPurchases(){
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases){
        this.purchases = (ArrayList<Purchase>) purchases.clone();
    }

    public String toString(){
        return super.toString() + "\nNumber = " + totalSpent + "\nPurchases = " + purchases.toString() + "\n";
    }

    public boolean equals(Object obj){
        if ( obj != null && obj.getClass() == this.getClass() ) {
            Client p = (Client) obj;
            return super.equals(p) && this.totalSpent == p.totalSpent && this.purchases.equals(p.purchases);
        }else{
            return false;
        }
    }

    public Object clone(){
        Person p = (Person) super.clone();
        Client c = new Client(p, this.totalSpent);
        c.setPurchases(this.purchases);
        return c;
    }

    public void AddPurchase(Purchase p){
        this.purchases.add(p);
        totalSpent += p.totalSpent;
    }

    public void RemovePurchase(Purchase p){
        this.purchases.remove(p);
        totalSpent--;
    }

    public int TotalPurchases(){
        return purchases.size();
    }
}