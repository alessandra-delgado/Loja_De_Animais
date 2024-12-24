package src.ClassesMenu;

import src.Classes_Loja.Product;
import src.Enum.ProductType;
import src.Input.Ler;
import src.Main;

public class CatalogMenu {
    private static void menu() {
        System.out.println("Menu Catálogo");
        System.out.println("1 - Visualizar catálogo");
        System.out.println("2 - Fazer Compra");
        System.out.println("3 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void show() {
        while (true) {
            CatalogMenu.menu();

            switch (Ler.umInt()) {
                case 1:
                    CatalogMenu.viewCatalog();
                    break;
                case 2:
                    System.out.println("Fazer Compra");
                    break;
                case 3:
                    System.out.println("A voltar");
                    return;
            }
        }
    }

    private static void viewCatalog() {
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
                    CatalogMenu.viewAnimals(true);
                    break;
                case '2':
                    System.out.println("Animais Imaginários");
                    CatalogMenu.viewAnimals(false);
                    break;
                case '3':
                    System.out.println("Cosmeticos");
                    CatalogMenu.listProducts(ProductType.COSMETIC);
                    break;
                case '4':
                    System.out.println("Comida");
                    CatalogMenu.listProducts(ProductType.FOOD);
                    break;
                case '5':
                    System.out.println("Habitat");
                    CatalogMenu.listProducts(ProductType.HABITAT);
                    break;
                case '6':
                    System.out.println("Medicamentos");
                    CatalogMenu.listProducts(ProductType.MEDICINE);
                    break;
                case '7':
                    System.out.println("Higiene");
                    CatalogMenu.listProducts(ProductType.HYGIENE);
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

    private static void viewAnimals(boolean realAnimals) {

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
                    CatalogMenu.listProducts(aerialType);
                    break;
                case 2:
                    System.out.println("Terrestres");
                    CatalogMenu.listProducts(landType);
                    break;
                case 3:
                    System.out.println("Aquáticos");
                    CatalogMenu.listProducts(aquaticType);
                    break;
                case 4:
                    System.out.println("Todos");
                    CatalogMenu.listProducts(aerialType);
                    CatalogMenu.listProducts(landType);
                    CatalogMenu.listProducts(aquaticType);
                    break;
                case 5:
                    System.out.println("Sair");
                    return;
            }
        }
    }

    private static void listProducts(ProductType type) {
        for (Product p : Main.products.get(type)) {
            System.out.println(p);
        }
    }
}
