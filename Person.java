import java.time.LocalDate;

public class Person {
    private String name;
    private char gender;
    private LocalDate birthdate;
    private int tel;
    private int nif;

    public Person() {
        this.name = "";
        this.gender = ' ';
        this.birthdate = null;
        this.tel = 0;
        this.nif = 0;
    }

    public Person(String name, int tel, int nif){
        this.name = name;
        this.gender = ' ';
        this.birthdate = null;
        this.tel = tel;
        this.nif = nif;
    }

    public Person(String name, char gender, LocalDate birthdate, int tel, int nif) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.tel = tel;
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String toString() {
        String s = "\nName = " + name + "\nBirthdate = " + birthdate + "\nTel = " + tel + "\nNIF = " + nif;
        if ( gender != ' ' ){
            s += "\nGender = " + gender;
        }
        if ( birthdate != null ){
            s += "\nBirthdate = " + birthdate;
        }
        return s;
    }
}
