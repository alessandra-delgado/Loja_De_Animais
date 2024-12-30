package src.ClassesMenu;

import src.ClassesLoja.*;
import src.Enum.ProductType;
import src.Input.Ler;

import java.util.ArrayList;

import static src.Main.products;

public class StatsMenu {
    public static void menu() {
        System.out.println("╭─────────────────────────────╮");
        System.out.println("│ 1 - Produtos mais vendidos  │");
        System.out.println("│ 2 - Produtos menos vendidos │");
        System.out.println("│ 3 - Melhores clientes       │");
        System.out.println("│ 4 - Valor faturado          │");
        System.out.println("│ 5 - Voltar                  │");
        System.out.println("╰─────────────────────────────╯");
        System.out.println("Escolha uma opção:");
    }

    public static void showMenu() {
        do {
            StatsMenu.menu();

            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Produtos mais vendidos");
                    StatsMenu.MostSold();
                    break;
                case 2:
                    System.out.println("Produtos menos vendidos");
                    StatsMenu.LeastSold();
                    break;
                case 3:
                    System.out.println("Melhores clientes");
                    BestClientMenu.showMenu();
                    break;
                case 4:
                    TotalGainedMenu.showMenu();
                    break;
                case 5:
                    System.out.println("Sair");
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);
    }

    public static void MostSold() {
        int i = 0;
        ArrayList<Product> prod_sold = new ArrayList<>();

        for (ProductType p : ProductType.values()) {
            if (products.get(p) == null || products.get(p).isEmpty()) continue;

            prod_sold.addAll(products.get(p));
        }

        prod_sold.sort((product1, product2) -> (product2.getQuantity_sold() - product1.getQuantity_sold()));

        while (i < prod_sold.size()) {
            System.out.println(prod_sold.get(i).getName() + " : " + prod_sold.get(i).getQuantity_sold() + " purchases");
            i++;
            if (i == 5) break;
        }
    }

    public static void LeastSold() {
        int i = 0;
        ArrayList<Product> prod_sold = new ArrayList<>();

        for (ProductType p : ProductType.values()) {
            if (products.get(p) == null || products.get(p).isEmpty()) continue;

            prod_sold.addAll(products.get(p));
        }

        prod_sold.sort((product1, product2) -> (product1.getQuantity_sold() - product2.getQuantity_sold()));

        while (i < prod_sold.size()) {
            System.out.println(prod_sold.get(i).getName() + " : " + prod_sold.get(i).getQuantity_sold() + " purchases");
            i++;
            if (i == 5) break;
        }
    }

}
