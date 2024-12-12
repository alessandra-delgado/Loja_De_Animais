import java.time.LocalDate;

public class Employee extends Person {
    private double salary;
    private String position;

    public Employee() {
        super();
        salary = 0.0;
        position = "";
    }

    public Employee(double salary, String position, String name, int tel, int nif) {
        super(name, tel, nif);
        this.salary = salary;
        this.position = position;
    }

    public Employee(double salary, String position, String name, int tel, int nif, LocalDate birthdate, char gender) {
        super(name, gender, birthdate,tel, nif);
        this.salary = salary;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String toString(){
        String s = super.toString() + "\nSalary: " + salary + "\nPosition: " + position + "\n";
        return s;
    }

}
