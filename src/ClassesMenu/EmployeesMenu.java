package src.ClassesMenu;

import src.ClassesLoja.Person;
import src.ClassesLoja.Employee;
import src.Exceptions.EmployeeNotFoundException;
import src.Exceptions.InvalidSalaryException;
import src.FormValidation.Form;
import src.Input.Ler;
import src.ClassesLoja.File;
import src.Main;
import src.FormValidation.Validation;

import java.time.LocalDate;

public class EmployeesMenu {
    public static void menu() {
        System.out.println("1 - Adicionar Empregados");
        System.out.println("2 - Atualizar Empregados ");
        System.out.println("3 - Visualizar Empregados ");
        System.out.println("4 - Eliminar Empregados ");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção:");
    }

    public static void show() {
        int op = 0;
        while (true) {
            EmployeesMenu.menu();
            op = Ler.umInt();
            switch (op) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    viewEmployees();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("A sair ...");
                    return;
            }
        }
    }

    private static void addEmployee() {
        System.out.println("Insira o nome, género, data de nascimento, número de telefone e NIF da Pessoa: ");

        //dados da pessoa --------------------------------------------------------------------
        // Nome
        System.out.print("Nome: ");
        String name = Ler.umaString();

        // Género
        char gender = Form.insertGender();

        // Data nascimento
        LocalDate datenascimento = Form.insertDate();

        // Tel
        System.out.print("Número de telemóvel: ");
        int tel = Ler.umInt();

        // NIF
        int nif = insertNIF();

        //criar pessoa -----------------------------------------------------------------------
        Person e1 = new Person(name, gender, datenascimento, tel, nif);
        System.out.println("Agora, insira o salário e a posição do Empregado: ");

        //dados empregado
        double sal = insertSalary();

        System.out.print("Posição do Empregado: ");
        String position = Ler.umaString();

        //criar empregado
        Employee emp = new Employee(e1, sal, position);
        Main.employees.add(emp);

        //atualizar ficheiro
        File.binWrite(Main.employees, "Employee/Employee.dat");

        System.out.println("Empregado adicionado com sucesso!");
    }

    private static void updateEmployee() {

        System.out.println("Insira o NIF do Empregado: ");
        int nif = Ler.umInt();

        for (int i = 0; i < Main.employees.size(); i++) {
            if (Main.employees.get(i).getNif() == nif) {
                System.out.println("Empregado: ");
                System.out.println(Main.employees.get(i).toString());


                int op = 0;
                while (true) {
                    System.out.println("Selecione o que deseja atualizar: ");
                    System.out.println("1- Nome");
                    System.out.println("2- Género");
                    System.out.println("3- Data de nascimento");
                    System.out.println("4- Telefone");
                    System.out.println("5- NIF");
                    System.out.println("6- Salário");
                    System.out.println("7 - Posição");
                    System.out.println("8- Sair");
                    System.out.print("Insira uma opção: ");
                    op = Ler.umInt();
                    switch (op) {
                        case 1:
                            System.out.println("Insira o nome do Empregado: ");
                            String name = Ler.umaString();
                            Main.employees.get(i).setName(name);
                            break;
                        case 2:
                            System.out.println("Insira o género do Empregado: ");
                            char gender = Form.insertGender();
                            Main.employees.get(i).setGender(gender);
                            break;
                        case 3:
                            System.out.println("Insira a data de nascimento do Empregado: ");
                            LocalDate date = Form.insertDate();
                            Main.employees.get(i).setBirthdate(date);
                            break;
                        case 4:
                            System.out.println("Insira o telefone do Empregado: ");
                            int tel = Ler.umInt();
                            Main.employees.get(i).setTel(tel);
                            break;
                        case 5:
                            int nif2 = insertNIF();
                            Main.employees.get(i).setNif(nif2);
                            break;
                        case 6:
                            double sal = insertSalary();
                            Main.employees.get(i).setSalary(sal);
                            break;
                        case 7:
                            System.out.println("Insira a posição do Empregado: ");
                            String position = Ler.umaString();
                            Main.employees.get(i).setPosition(position);
                            break;
                        case 8:
                            File.binWrite(Main.employees, "Employee/Employee.dat");
                            System.out.println("Empregado atualizado com sucesso!");
                            System.out.println("A sair...");
                            return;
                        default:
                            System.out.println("Opção inválida.");
                            return;
                    }
                }
            }
        }
    }

    private static void viewEmployees() {

        for (int i = 0; i < Main.employees.size(); i++) {
            System.out.println(Main.employees.get(i).toString());
        }
    }

    private static void deleteEmployee() {
        System.out.println("Insira o NIF do Empregado: ");
        double nif = Ler.umDouble();

        for (int i = 0; i < Main.employees.size(); i++) {
            if (Main.employees.get(i).getNif() == nif) {
                Main.employees.remove(i);
            }
        }
    }

    private static Employee findByNIF(int nif) throws EmployeeNotFoundException {
        for (Employee employee : Main.employees) {
            if (employee.getNif() == nif) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Empregado com o NIF " + nif + " não está registado");
    }

    private static int insertNIF(){
        int nif = 0;
        while (true) {
            try {
                System.out.print("Insira o NIF do empregado: ");
                nif = Ler.umInt();
                Employee _ = EmployeesMenu.findByNIF(nif);
                System.out.println("Já existe um empregado com o NIF introduzido!");
            } catch (EmployeeNotFoundException e) {
                return nif;
            }
        }
    }

    private static double insertSalary(){
        double salary = 0;
        while (true) {
            try{
                System.out.print("Insira o salário do Empregado: ");
                salary = Validation.validateSalary();
                return salary;
            }catch (InvalidSalaryException e){
                System.out.println(e.getMessage());
            }
        }
    }
}