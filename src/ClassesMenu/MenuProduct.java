package src.ClassesMenu;

import src.Classes_Loja.Product;
import src.Enum.ProductType;
import src.Classes_Loja.File;
import src.Input.Ler;
import src.Main;

public class MenuProduct {
    private static void menu() {
        System.out.println("1 - Adicionar Produtos");
        System.out.println("2 - Atualizar Produtos");
        System.out.println("3 - Visualizar Produtos");
        System.out.println("4 - Eliminar Produtos");
        System.out.println("5 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void show() {
        while (true) {
            MenuProduct.menu();
            switch (Ler.umInt()) {
                case 1:
                    addProduct();
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
                    System.out.println("Voltar");
                    return;
            }
        }
    }

    private static void addProduct() {
        System.out.println("Que tipo de produto:");
        System.out.println("1 - Cosmeticos");
        System.out.println("2 - Comida");
        System.out.println("3 - Habitat");
        System.out.println("4 - Medicamentos");
        System.out.println("5 - Voltar");

        while (true) {
            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Qual o nome do cosmetico:");
                    String nome = Ler.umaString();
                    System.out.println("Qual o preco do cosmetico:");
                    double preco = Ler.umDouble();

                    //Cria produto
                    Product novoCosmetico = new Product(nome, preco);
                    //Adiciona á lista de cosméticos
                    novoCosmetico.setCategory(ProductType.COSMETIC);
                    Main.products.get(ProductType.COSMETIC).add(novoCosmetico);

                    //Guardar em cosmetics.dat
                    File.binWrite(Main.products.get(ProductType.COSMETIC), "Cosmetics/Cosmetics.dat");

                    System.out.println("Cosmético registado!!");
                    break;
                case 2:
                    Main.products.get(ProductType.FOOD).add(new Product());
                    break;
                case 3:
                    Main.products.get(ProductType.HABITAT).add(new Product());
                    break;
                case 4:
                    Main.products.get(ProductType.MEDICINE).add(new Product());
                    break;
                case 5:
                    System.out.println("Voltar");
                    return;
            }
        }
    }
}
