package src.ClassesLoja;

import src.Enum.AnimalType;

public class  Animal extends Product {
    private int age;
    private char gender;
    private String sciname;
    private String asciiart;
    private AnimalType type;

    public Animal() {

    }

    public Animal(int age, char gender, String sciname, String asciiart, AnimalType type) {
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

    public char getGender() {
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

    public void setGender(char gender) {
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

    public boolean equals(Object obj){
         if (obj instanceof Animal){
             Animal a = (Animal) obj;
             return super.equals(a) && this.age == a.age && this.gender == a.gender && this.sciname.equals(a.sciname) && this.asciiart.equals(a.asciiart) && this.type == a.type;
         }
         return false;
     }
}