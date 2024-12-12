import java.time.LocalDate;

public class Client extends Person{
    private int totalPurchase;

    public Client(){
        super();
        this.totalPurchase = 0;
    }

    public Client(String name, int nif, int tel, int totalPurchase){
        super(name, nif, tel);
        this.totalPurchase = totalPurchase;
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

    public String toString(){
        String s = super.toString() + "\nNumber = " + totalPurchase;
        return s;
    }

    public boolean equals(Object obj){
        if ( obj != null && obj.getClass() == this.getClass() ) {
            Client p = (Client) obj;
            return super.equals(p) && this.totalPurchase == p.totalPurchase;
        }else{
            return false;
        }
    }

    public Object clone(){
        Person p = (Person) super.clone();
        Client c = new Client(p, this.totalPurchase);
        return c;
    }



    
}