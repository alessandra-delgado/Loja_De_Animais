// Todo: Colocar cada menu na sua própria classe
package src.ClassesMenu;

import src.Classes_Loja.Product;
import src.Enum.ProductType;
import src.Input.Ler;
import src.Main;

import java.io.*;
import java.util.ArrayList;

public class FuncoesMenu {
    public static void menuCatalogo() {
        System.out.println("Menu Catálogo");
        System.out.println("1 - Visualizar catálogo");
        System.out.println("2 - Fazer Compra");
        System.out.println("3 - Voltar");
        System.out.print("Escolha uma opção: ");

        while (true) {
            switch (Ler.umInt()) {
                case 1:
                    FuncoesMenu.catalogMenu();
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

    public static void menuInventario() {
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

    public static void menuEstatisticas() {
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
        do {
            System.out.println("1 - Animais Reais");
            System.out.println("2 - Animais Imaginários");
            System.out.println("3 - Cosmeticos");
            System.out.println("4 - Comida");
            System.out.println("5 - Habitat");
            System.out.println("6 - Higiene");
            System.out.println("7 - Medicamentos");
            System.out.println("? - ?");
            System.out.println("8 - Voltar");
            System.out.print("Escolha uma opção: ");

            switch (Ler.umChar()) {
                case '1':
                    System.out.println("Animais Reais");
                    animalMenu(true);
                    break;
                case '2':
                    System.out.println("Animais Imaginários");
                    animalMenu(false);
                    break;
                case '3':
                    System.out.println("Cosmeticos");
                    for (Product p : Main.products.get(ProductType.COSMETIC)) {
                        System.out.println(p);
                    }
                    break;
                case '4':
                    System.out.println("Comida");
                    for (Product p : Main.products.get(ProductType.FOOD)) {
                        System.out.println(p);
                    }
                    break;
                case '5':
                    System.out.println("Habitat");
                    for (Product p : Main.products.get(ProductType.HABITAT)) {
                        System.out.println(p);
                    }
                    break;
                case '6':
                    System.out.println("Medicamentos");
                    for (Product p : Main.products.get(ProductType.MEDICINE)) {
                        System.out.println(p);
                    }
                    break;
                case '7':
                    System.out.println("Higiene");
                    for (Product p : Main.products.get(ProductType.HYGIENE)) {
                        System.out.println(p);
                    }
                    break;
                case '8':
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

    public static void animalMenu(boolean realAnimals) {

        ProductType aerialType = realAnimals ? ProductType.ANIMAL_REAL_AERIAL : ProductType.ANIMAL_IMAGINARY_AERIAL;
        ProductType landType = realAnimals ? ProductType.ANIMAL_REAL_LAND : ProductType.ANIMAL_IMAGINARY_LAND;
        ProductType aquaticType = realAnimals ? ProductType.ANIMAL_REAL_AQUATIC : ProductType.ANIMAL_IMAGINARY_AQUATIC;

        System.out.println("1 - Aéreos");
        System.out.println("2 - Terrestres");
        System.out.println("3 - Aquáticos");
        System.out.println("4 - Todos");
        System.out.println("5 - Voltar");
        System.out.print("Escolha uma opção: ");

        while (true) {
            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Aéreos");

                    for (Product p : Main.products.get(aerialType)) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.println("Terrestres");
                    for (Product p : Main.products.get(landType)) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.println("Aquáticos");
                    for (Product p : Main.products.get(aquaticType)) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    System.out.println("Todos");
                    for (Product p : Main.products.get(aerialType)) {
                        System.out.println(p);
                    }

                    for (Product p : Main.products.get(landType)) {
                        System.out.println(p);
                    }

                    for (Product p : Main.products.get(aquaticType)) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    System.out.println("Sair");
                    return;
            }
        }
    }

    public static ArrayList<?> readFile(String path) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
            ArrayList<?> arr = (ArrayList<?>) is.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return arr;
    }
}
