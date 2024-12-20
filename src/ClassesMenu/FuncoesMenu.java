package src.ClassesMenu;

import src.Classes_Loja.Animal;
import src.Input.Ler;
import src.Main;

import java.io.*;
import java.util.ArrayList;

public class FuncoesMenu {
    public static void menu1() {
        System.out.println("1 - Visualizar catálogo");
        System.out.println("2 - Fazer Compra");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Finge que tem um catálogo :3");
                    break;
                case 2:
                    System.out.println("Fazer Compra");
                    break;
                case 3:
                    System.out.println("Saí do menu 1");
                    return;
            }
        }
    }

    public static void menu2() {
        System.out.println("1 - Produtos");
        System.out.println("2 - Empregados");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Produtos");
                    break;
                case 2:
                    System.out.println("Empregados");
                    break;
                case 3:
                    System.out.println("sair do menu 2");
                    return;
            }
        }
    }

    public static void menu3() {
        System.out.println("1 - Vendas");
        System.out.println("2 - Clientes");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Vendas");
                    break;
                case 2:
                    System.out.println("Clientes");
                    break;
                case 3:
                    System.out.println("Saí do menu 3");
                    return;
            }
        }

    }

    public static void catalogMenu() {
        System.out.println("1 - Animais");
        System.out.println("2 - Cosmeticos");
        System.out.println("3 - Comida");
        System.out.println("4 - Habitat");
        System.out.println("5 - Higiene");
        System.out.println("6 - Medicamentos");
        System.out.println("7 - Sair");
        System.out.println("? - ?");


        char op = Ler.umChar();
        do {
            switch (op) {
                case '1':
                    System.out.println("Animais");
                    break;
                case '2':
                    System.out.println("Cosmeticos");
                    break;
                case '3':
                    System.out.println("Comida");
                    break;
                case '4':
                    System.out.println("Habitat");
                    break;
                case '5':
                    System.out.println("Medicamentos");
                    break;
                case '6':
                    System.out.println("Higiene");
                    break;
                case '7':
                    System.out.println("Sair");
                    return;
                case '!':
                    System.out.println("Menu Secreto");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (true);

    }

    public static void animalTypes() {
        System.out.println("1 - Aéreos");
        System.out.println("2 - Terrestres");
        System.out.println("3 - Aquáticos");
        System.out.println("4 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Aéreos");
                    Main.animals_i.remove(0);
                    Main.animals_i.addAll(0, (ArrayList<Animal>) readFile("src/Files_Products/Animal/Imaginary/Air.dat"));
                    break;
                case 2:
                    System.out.println("Terrestres");
                    Main.animals_i.remove(1);
                    Main.animals_i.addAll(1, (ArrayList<Animal>) readFile("src/Files_Products/Animal/Imaginary/Land.dat"));
                    break;
                case 3:
                    System.out.println("Aquáticos");
                    Main.animals_i.remove(2);
                    Main.animals_i.addAll(2, (ArrayList<Animal>) readFile("src/Files_Products/Animal/Imaginary/Water.dat"));
                    break;
                case 4:
                    System.out.println("Sair");
                    return;
            }

        }
        public static ArrayList<?> readFile (String path){
            ArrayList<?> arr = new ArrayList<>();
            try {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
                arr = (ArrayList<?>) is.readObject();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            return arr;
        }
    }


