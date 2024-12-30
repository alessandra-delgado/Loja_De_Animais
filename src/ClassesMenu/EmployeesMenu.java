package src.ClassesMenu;

import src.ClassesLoja.Person;
import src.ClassesLoja.Employee;
import src.Input.Ler;
import src.ClassesLoja.File;
import src.Main;

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

        //dados da pessoa
        String name = Ler.umaString();
        char gender = Ler.umChar();
        String date = Ler.umaString();
        LocalDate datenascimento = LocalDate.parse(date);
        int tel = Ler.umInt();
        int nif = Ler.umInt();

        //criar pessoa
        Person e1 = new Person(name, gender, datenascimento, tel, nif);
        System.out.println("Agora, insira o salário e a posição do Empregado: ");

        //dados empregado
        double sal = Ler.umDouble();
        String position = Ler.umaString();

        //criar empregado
        Employee emp = new Employee(e1, sal, position);
        Main.employees.add(emp);

        //atualizar ficheiro
        File.binWrite(Main.employees, "Employees/Employees.dat");

        System.out.println("Empregado adicionado com sucesso!");
    }

    private static void updateEmployee() {

        System.out.println("Insira o NIF do Empregado: ");
        int nif = Ler.umInt();

        for (int i = 0; i < Main.employees.size(); i++) {
            if (Main.employees.get(i).getNif() == nif) {
                System.out.println("Empregado: ");
                System.out.println(Main.employees.get(i).toString());


                System.out.println("Selecione o que deseja atualizar: ");
                System.out.println("1- Nome");
                System.out.println("2- Género");
                System.out.println("3- Data de nascimento");
                System.out.println("4- Telefone");
                System.out.println("5- NIF");
                System.out.println("6- Salário");
                System.out.println("7 - Posição");
                System.out.println("8- Sair");

                int op = 0;
                while (true) {
                    op = Ler.umInt();
                    switch (op) {
                        case 1:
                            System.out.println("Insira o nome do Empregado: ");
                            String name = Ler.umaString();
                            Main.employees.get(i).setName(name);
                            break;
                        case 2:
                            System.out.println("Insira o género do Empregado: ");
                            char gender = Ler.umChar();
                            Main.employees.get(i).setGender(gender);
                            break;
                        case 3:
                            System.out.println("Insira o data de nascimento do Empregado: ");
                            String date = Ler.umaString();
                            LocalDate datenascimento = LocalDate.parse(date);
                            Main.employees.get(i).setBirthdate(datenascimento);
                            break;
                        case 4:
                            System.out.println("Insira o telefone do Empregado: ");
                            int tel = Ler.umInt();
                            Main.employees.get(i).setTel(tel);
                            break;
                        case 5:
                            System.out.println("Insira o nif do Empregado: ");
                            int nif2 = Ler.umInt();
                            Main.employees.get(i).setNif(nif2);
                            break;
                        case 6:
                            System.out.println("Insira o salário do Empregado: ");
                            double sal = Ler.umDouble();
                            Main.employees.get(i).setSalary(sal);
                            break;
                        case 7:
                            System.out.println("Insira a posição do Empregado: ");
                            String position = Ler.umaString();
                            Main.employees.get(i).setPosition(position);
                            break;
                        case 8:
                            File.binWrite(Main.employees, "Employees/Employees.dat");
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
}