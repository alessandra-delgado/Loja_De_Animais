public class Animal extends Product{
    private int age;
    private String gender;
    public Animal(){

    }
    public Animal( int age, String gender){
        // falta o super....
        this.age = age;
        this.gender = gender;
    }
    public double getPrice(){}
}