package src.ClassesMenu;

import src.ClassesLoja.*;
import src.Enum.ProductType;
import src.Input.Ler;

import java.util.ArrayList;

import static src.Main.clients;
import static src.Main.products;

public class MenuStats {
    public static void menu() {
        System.out.println("1 - Produtos mais vendidos");
        System.out.println("2 - Produtos menos vendidos");
        System.out.println("3 - Melhores clientes");
        System.out.println("4 - Valor faturado");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção:");
    }

    public static void showMenu() {
        do {
            MenuStats.menu();

            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Produtos mais vendidos");
                    MenuStats.MostLeastSold(0);
                    break;
                case 2:
                    System.out.println("Produtos menos vendidos");
                    MenuStats.MostLeastSold(1);
                    break;
                case 3:
                    System.out.println("Melhores clientes");
                    MenuStats.bestClient();
                    break;
                case 4:
                    System.out.println("Valor faturado");
                    break;
                case 5:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);
    }

    public static void MostLeastSold(int j) {
        int i = 0;
        ArrayList<Product> prod_sold = new ArrayList<>();
        for (ProductType p : ProductType.values()) {
            if (products.get(p) == null || products.get(p).isEmpty()) continue;
            ArrayList<Product> prod = new ArrayList<Product>(products.get(p));

            prod.sort((product1, product2) -> {
                if (j == 0) return product2.getQuantity_sold() - product1.getQuantity_sold();
                else return product1.getQuantity_sold() - product2.getQuantity_sold();
            });
            i = 0;

            while (i < prod.size() && prod.get(i).getQuantity_sold() == prod.get(0).getQuantity_sold()) {
                prod_sold.add(prod.get(i));
                i++;
            }
        }

        prod_sold.sort((product1, product2) -> {
            if (j == 0) return product2.getQuantity_sold() - product1.getQuantity_sold();
            else return product1.getQuantity_sold() - product2.getQuantity_sold();
        });

        i = 0;
        while (i < prod_sold.size()) {
            System.out.println(prod_sold.get(i).getName() + " : " + prod_sold.get(i).getQuantity_sold() + " purchases");
            i++;
            if (i == 5) break;
        }
    }

    public static void bestClient() {
            int max = Integer.MIN_VALUE;
            int i = 0;
            ArrayList<Client> bestClients = new ArrayList<Client>(clients);
            bestClients.sort((client1, client2) -> client2.getTotalSpent() - client1.getTotalSpent());

            while ( i<bestClients.size() ) {
                    System.out.println(bestClients.get(i).getName() + " : Total spent is " + bestClients.get(i).getTotalSpent());
                    if ( i == 5 ) break;
                    i++;
            }
    }
}