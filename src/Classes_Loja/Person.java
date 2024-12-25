package src.Classes_Loja;

import java.time.LocalDate;


public class Person {
    protected String name;
    protected char gender;
    protected LocalDate birthdate;
    protected int tel;
    protected int nif;
    protected String email;

    public Person() {
        this.name = "";
        this.gender = ' ';
        this.email = "";
        this.birthdate = null;
        this.tel = 0;
        this.nif = 0;
    }

    public Person(String name, int tel, int nif, String email) {
        this.name = name;
        this.gender = ' ';
        this.birthdate = null;
        this.tel = tel;
        this.nif = nif;
        this.email = "";
    }

    public Person(String name, char gender, LocalDate birthdate, int tel, int nif, String email) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.tel = tel;
        this.nif = nif;
        this.email = email;
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

    public String getEmail(){ return email;}

    public  void setEmail(String email){ this.email = email; }

    public String toString() {
        String s = "\nName = " + name + "\nBirthdate = " + birthdate + "\nTel = " + tel + "\nNIF = " + nif;
        if ( gender != ' ' ){
            s += "\nGender = " + gender;
        }
        if ( birthdate != null ){
            s += "\nBirthdate = " + birthdate;
        }
        if (email != null){
            s += "\nEmail = " + email;
        }
        return s;
    }

    public boolean equals(Object obj){
        if ( obj != null && obj.getClass() == this.getClass() ) {
            Person p = (Person) obj;
            return name.equals(p.name) && gender == p.gender && birthdate.equals(p.birthdate) && tel == p.tel && nif == p.nif && email.equals(p.email);
        }else{
            return false;
        }
    }

    public Object clone(){
        Person p = new Person(name, gender, birthdate, tel, nif, email);
        return p;
    }
}
