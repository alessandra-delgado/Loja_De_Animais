package src.FormValidation;

import src.Exceptions.InvalidAgeException;
import src.Exceptions.InvalidGenderException;
import src.Exceptions.InvalidProductQuantityException;
import src.Exceptions.InvalidSalaryException;
import src.Input.Ler;

public class Validation {
    public static char validateGender() throws InvalidGenderException {
        char gender = Ler.umChar();
        switch (gender) {
            case 'F', 'f', 'M', 'm' -> {
                return gender;
            }
            default -> {
                throw new InvalidGenderException("Género inválido!");
            }
        }
    }

    public static double validateSalary() throws InvalidSalaryException {
        double salary = Ler.umDouble();
        if (salary < 0.0) throw new InvalidSalaryException("Salário inválido!");
        return salary;
    }

    public static int validateQuantity(){
        int quantity = Ler.umInt();
        if (quantity < 0) throw new InvalidProductQuantityException("A quantidade inserida é inválida!");
        return quantity;
    }

    public static int validateAge() throws InvalidAgeException {
        int age = Ler.umInt();
        if (age < 0) throw new InvalidAgeException("A idade inserida é inválida!");
        return age;
    }
}
