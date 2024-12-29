package src.ClassesMenu;

import src.ClassesLoja.Client;
import src.Input.Ler;

import java.util.ArrayList;

import static src.Main.clients;

public class BestClientMenu {
    public static void menu() {
        System.out.println("Melhores clientes que têm: ");
        System.out.println("1 - Maior gasto total");
        System.out.println("2 - Maior gasto numa única compra");
        System.out.println("3 - Maior número de compras totais");
        System.out.println("4 - Sair");
    }

    public static void showMenu() {
        do {
            BestClientMenu.menu();

            switch (Ler.umInt()) {
                case 1:
                    BestClientMenu.MostSpentTotal();
                    break;
                case 2:
                    BestClientMenu.MostSpentSingle();
                    break;
                case 3:
                    BestClientMenu.MostPurchasesTotal();
                    break;
                case 4:
                    System.out.println("Sair");
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(true);
    }

    public static void MostSpentTotal() {
        int i = 0;

        if (clients.isEmpty()){
            System.out.println("No clients available");
        }

        ArrayList<Client> bestClients = new ArrayList<Client>(clients);
        bestClients.sort((client1, client2) -> Double.compare(client2.getTotalSpent(), client1.getTotalSpent()));

        while (i < bestClients.size()) {
            System.out.println(bestClients.get(i).getName() + " : Total spent is " + bestClients.get(i).getTotalSpent());
            if (i == 5) break;
            i++;
        }
    }

    public static void MostSpentSingle(){
        int i = 0;

        if (clients.isEmpty()){
            System.out.println("No clients available");
        }

        ArrayList<Client> bestClients = new ArrayList<Client>(clients);
        bestClients.sort((client1, client2) -> Double.compare(client2.MostExpensivePurchase(), client1.MostExpensivePurchase()));
        while (i < bestClients.size()) {
            System.out.println(bestClients.get(i).getName() + " : The most spent o na single purchase " + bestClients.get(i).MostExpensivePurchase());
            if (i == 5) break;
            i++;
        }
    }

    public static void MostPurchasesTotal(){
        int i = 0;

        if (clients.isEmpty()){
            System.out.println("No clients available");
        }

        ArrayList<Client> bestClients = new ArrayList<Client>(clients);
        bestClients.sort((client1, client2) -> client2.totalPurchases() - client1.totalPurchases());
        while (i < bestClients.size()) {
            System.out.println(bestClients.get(i).getName() + " : Total purchases made is " + bestClients.get(i).totalPurchases());
            if (i == 5) break;
            i++;
        }
    }
}
