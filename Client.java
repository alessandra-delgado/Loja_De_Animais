import java.time.LocalDate;

public class Client extends Person{
    private static int last = 0;
    private int num;

    public Client(){
        super();
        last++;
        this.num = last;
    }

    public Client(String name, int nif, int tel){
        super(name, nif, tel);
        last++;
        num = last;
    }

    public Client(String name, int nif, int tel, LocalDate birthdate, char gender){
        super(name, gender, birthdate, tel, nif);
        last++;
        num = last;
    }

    public static int getLast(){
        return last;
    }

    public static void setLast(int last){
        Client.last = last;
    }

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public String toString(){
        String s = super.toString() + "\nNumber = " + num;
        return s;
    }





    
}