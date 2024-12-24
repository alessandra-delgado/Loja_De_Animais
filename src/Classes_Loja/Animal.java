package src.Classes_Loja;

import src.Enum.AnimalType;

public class Animal extends Product {
    private int age;
    private String gender;
    private String sciname;
    private String asciiart;
    private AnimalType type;

    public Animal() {

    }

    public Animal(int age, String gender, String sciname, String asciiart, AnimalType type) {
        super();
        super.setName(getName());
        super.setCategory(getCategory());
        super.setPrice(getPrice());
        this.age = age;
        this.gender = gender;
        this.sciname = sciname;
        this.asciiart = asciiart;
        this.type = type;
    }

    //GETTERS
    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSciname() {
        return sciname;
    }

    public String getAsciiart() {
        return asciiart;
    }

    public AnimalType getType() {
        return type;
    }

    //SETTERS
    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSciname(String sciname) {
        this.sciname = sciname;
    }

    public void setAsciiart(String asciiart) {
        this.asciiart = asciiart;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    // OVERRIDES TOSTRING
    public String toString() {
        return super.toString() + "Age: " + age + "Gender: " + gender + "Sciname: " + sciname + "Asciiart: " + asciiart;
    }

    // public boolean equals(Object obj){
    //     if (obj != null && obj instanceof Animal){
    //         Animal a = (Animal) obj;
    //         return super.equals()
    //     }
    // }
}