package src.FormValidation;

import src.Exceptions.InvalidAgeException;
import src.Exceptions.InvalidGenderException;
import src.Exceptions.InvalidProductQuantityException;
import src.Input.Ler;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Form {
    // For animals and people
    public static char insertGender(){
        char gender;
        while (true) {
            try {
                System.out.print("Insira o género (F/M): ");
                gender = Validation.validateGender();
                gender = Character.toUpperCase(gender);
                return gender;
            } catch (InvalidGenderException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate insertDate(){
        LocalDate date;
        while (true) {
            try {
                System.out.print("Insira a data no formato YYYY-MM-DD: ");
                String parse = Ler.umaString();
                date = LocalDate.parse(parse);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("A data introduzida não é válida.");
            }
        }
    }

    public static int insertQuantity(){
        int quantity;
        while (true) {
            try {
                System.out.print("Insira a quantidade: ");
                quantity = Validation.validateQuantity();
                return quantity;
            } catch (InvalidProductQuantityException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int insertAge(){
        int age;
        while (true) {
            try{
                System.out.print("Insira a idade: ");
                age = Validation.validateAge();
                return age;
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
