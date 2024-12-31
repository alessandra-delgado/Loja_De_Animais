package src.ClassesLoja;

public class Employee extends Person implements Serializable {
    private double salary;
    private String position;

    public Employee() {
        super();
        salary = 0.0;
        position = "";
    }

    public Employee(Person p, double salary, String position) {
        super(p.name, p.gender, p.birthdate, p.tel, p.nif);
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
        return super.toString() + "\nSalário " + salary + "\nPosição: " + position + "\n";
    }

    public boolean equals(Object obj){
        if ( obj != null && obj.getClass() == this.getClass() ) {
            Employee p = (Employee) obj;
            return super.equals(p) && this.salary == p.salary && this.position.equals(p.position);
        }else{
            return false;
        }
    }

    public Object clone(){
        Person p = (Person) super.clone();
        Employee e = new Employee(p, this.salary, this.position);
        return e;
    }

}
