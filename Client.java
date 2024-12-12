import java.time.LocalDate;

public class Client{
    private static int last = 0;
    private int num;
    private String name;
    private int nif;
    private int tel;
    private LocalDate birthdate;
    private char gender;

    public Client(){
        last++;
        this.num = last;
        this.name = "";
        this.nif = 0;
        this.tel = 0;
        this.birthdate = null;
    }

    public Client(String name, int nif, int tel){
        last++;
        num = last;
        this.name = name;
        this.nif = nif;
        this.tel = tel;
        this.birthdate = null;
        this.gender = ' ';
    }

    public Client(String name, int nif, int tel, LocalDate birthdate){
        last++;
        num = last;
        this.name = name;
        this.nif = nif;
        this.tel = tel;
        this.birthdate = birthdate;
        this.gender = ' ';
    }

    public Client(String name, int nif, int tel, LocalDate birthdate, char gender){
        last++;
        num = last;
        this.name = name;
        this.nif = nif;
        this.tel = tel;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNif(){
        return nif;
    }

    public void setNif(int nif){
        this.nif = nif;
    }

    public int getTel(){
        return tel;
    }

    public void setTel(int tel){
        this.tel = tel;
    }

    public LocalDate getBirthdate(){
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate){
        this.birthdate = birthdate;
    }

    public char getGender(){
        return gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public String toString(){
        String s = "Number = " + num + "\nName = " + name + "\nNIF = " + nif + "\nTel = " + tel + "\nBirthdate = " + birthdate + "\nGender = " + gender;
        return s;
    }





    
}