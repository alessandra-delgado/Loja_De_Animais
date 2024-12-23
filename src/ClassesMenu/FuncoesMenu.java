// Todo: Colocar cada menu na sua própria classe
package src.ClassesMenu;

import src.Classes_Loja.Product;
import src.Enum.ProductType;
import src.Input.Ler;
import src.Main;
import src.Files.files;

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
                    System.out.println("A sair ...");
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
                    Menu_Produtos.main();
                    break;
                case 2:
                    System.out.println("Empregados");
                    Menu_Empregados.main();
                    break;
                case 3:
                    System.out.println("A sair...");
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
    public class Menu_Empregados {
        public static void main_Empregados() {
            System.out.println("1 - Adicionar Empregados");
            System.out.println("2 - Atualizar Empregados ");
            System.out.println("3 - Visualizar Empregados ");
            System.out.println("4 - Eliminar Empregados ");
            System.out.println("5 - Sair");
            System.out.println("Escolha uma opção:");
        }

        public static void main() {
            int op = 0;
            do {
                main_Empregados();
                op = Ler.umInt();
                switch (op) {
                    case 1:
                        System.out.println("Adicionar Empregados");

                        break;
                    case 2:
                        System.out.println("Atualizar Empregados");
                        break;
                    case 3:
                        System.out.println("Visualizar Empregados");
                        break;
                    case 4:
                        System.out.println("Eliminar Empregados");
                        break;
                    case 5:
                        System.out.println("Sair");
                        return;
                }
            } while (true);
        }
    }

    public class Menu_Produtos {
        public static void main_Produtos() {
            System.out.println("1 - Adicionar Produtos");
            System.out.println("2 - Atualizar Produtos ");
            System.out.println("3 - Visualizar Produtos ");
            System.out.println("4 - Eliminar Produtos ");
            System.out.println("5 - Sair");
            System.out.println("Escolha uma opção:");
        }

        public static void main() {
            int op = 0;
            do {
                main_Produtos();
                op = Ler.umInt();
                switch (op) {
                    case 1:
                        System.out.println("Que tipo de produto:");
                        System.out.println("1 - Cosmeticos");
                        System.out.println("2 - Comida");
                        System.out.println("3 - Habitat");
                        System.out.println("4 - Medicamentos");
                        System.out.println("5 - Sair");
                        int resposta = Ler.umInt();
                        switch(resposta){
                            case 1:
                                System.out.println("Qual o nome do cosmetico:");
                                String nome = Ler.umaString();
                                System.out.println("Qual o preco do cosmetico:");
                                double preco = Ler.umDouble();
                                //Cria produto
                                Product novoCosmetico = new Product(nome, preco);
                                //Adiciona á lista de cosméticos
                                novoCosmetico.setCategory("Cosmeticos");
                                Main.cosmetics.add(novoCosmetico);

                                //Guardar em cosmetics.dat
                                files.saveInfo(Main.cosmetics, "src/Files_Products/Cosmetics/Cosmetics.dat");

                                System.out.println("Cosmético registado!!");
                                break;
                            case 2:
                                Main.food.add(new Product());
                                break;
                            case 3:
                                Main.habitat.add(new Product());
                                break;
                            case 4:
                                Main.medicine.add(new Product());
                                break;
                            case 5:
                                System.out.println("Sair");
                                return;
                        }
                        break;
                    case 2:
                        System.out.println("Atualizar Produtos");

                        break;
                    case 3:
                        System.out.println("Visualizar Produtos");

                        break;
                    case 4:
                        System.out.println("Eliminar Produtos");
                        break;
                    case 5:
                        System.out.println("Sair");
                        return;
                }
            } while (true);
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
        ArrayList<?> arr = new ArrayList<>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
            arr = (ArrayList<?>) is.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        /*public static ArrayList<?> readFile (String path){
            ArrayList<?> arr = new ArrayList<>();
            try {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
                arr = (ArrayList<?>) is.readObject();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            return arr;*/

        }
    }
}
