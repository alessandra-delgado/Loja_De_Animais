import java.util.ArrayList;

public class Client extends Person{
    private int totalPurchase;
    private ArrayList<Purchase> purchases;

    public Client(){
        super();
        this.totalPurchase = 0;
        this.purchases = new ArrayList<>();
    }

    public Client(String name, int nif, int tel, int totalPurchase){
        super(name, nif, tel);
        this.totalPurchase = totalPurchase;
        this.purchases = new ArrayList<>();
    }

    public Client(Person p, int totalPurchase){
        super(p.name, p.gender, p.birthdate, p.tel, p.nif);
        this.totalPurchase = totalPurchase;
    }

    public int getTotalPurchase(){
        return totalPurchase;
    }

    public void setTotalPurchase(int totalPurchase){
        this.totalPurchase = totalPurchase;
    }

    public ArrayList<Purchase> getPurchases(){
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases){
        this.purchases = (ArrayList<Purchase>) purchases.clone();
    }

    public String toString(){
        String s = super.toString() + "\nNumber = " + totalPurchase;
        return s;
    }

    public boolean equals(Object obj){
        if ( obj != null && obj.getClass() == this.getClass() ) {
            Client p = (Client) obj;
            return super.equals(p) && this.totalPurchase == p.totalPurchase && this.purchases.equals(p.purchases);
        }else{
            return false;
        }
    }

    public Object clone(){
        Person p = (Person) super.clone();
        Client c = new Client(p, this.totalPurchase);
        c.setPurchases(this.purchases);
        return c;
    }



    
}