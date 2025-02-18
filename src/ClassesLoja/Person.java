package src.ClassesLoja;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected String name;
    protected char gender;
    protected LocalDate birthdate;
    protected int tel;
    protected int nif;

    public Person() {
        this.name = "";
        this.gender = ' ';
        this.birthdate = null;
        this.tel = 0;
        this.nif = 0;
    }

    public Person(String name, int tel, int nif) {
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
        String s = "\nNome = " + name +  "\nTel = " + tel + "\nNIF = " + nif;
        if (gender != ' ') {
            s += "\nGénero = " + gender;
        }
        if (birthdate != null) {
            s += "\nData de Nascimento = " + birthdate;
        }
        return s;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Person p = (Person) obj;
            return name.equals(p.name) && gender == p.gender && birthdate.equals(p.birthdate) && tel == p.tel && nif == p.nif;
        } else {
            return false;
        }
    }

    public Object clone() {
        Person p = new Person(name, gender, birthdate, tel, nif);
        return p;
    }
}
