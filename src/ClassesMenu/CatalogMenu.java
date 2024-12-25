package src.ClassesMenu;

import src.Classes_Loja.Client;
import src.Classes_Loja.Product;
import src.Enum.ProductType;
import src.Input.Ler;
import src.Main;

import java.util.HashMap;

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
                    CatalogMenu.makePurchase();
                    break;
                case 3:
                    System.out.println("A voltar");
                    return;
            }
        }
    }

    private static void makePurchase() {
        boolean isClientValid = false;
        do {
            // 1 - Choose client----
            System.out.println("Escolher um cliente para a operação (por id)");
            System.out.println("1 - Pesquisar cliente");
            System.out.println("2 - Inserir id de cliente");
            System.out.println("3 - Novo cliente");
            System.out.println("4 - Voltar");
            System.out.print("Insira uma opção: ");

            switch (Ler.umInt()) {
                case 1:
                    searchClient();
                case 2:
                    int id = selectClientID();
                    if (id == -2) {
                        System.out.println("<-");
                        return;
                    }

                    if (id != -1) {
                        System.out.println("Cliente selecionado com sucesso!");
                        isClientValid = true;
                    }
                    break;
                case 3:


                case 4:
                    System.out.println("<-");
                    return;
            }
        } while (!isClientValid);

        // 2 - Choose products
        // 3 - Display info for confirmation
        // 4 - Write fatura file and display buy info on screen
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

            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Animais Reais");
                    CatalogMenu.viewAnimals(true);
                    break;
                case 2:
                    System.out.println("Animais Imaginários");
                    CatalogMenu.viewAnimals(false);
                    break;
                case 3:
                    System.out.println("Cosmeticos");
                    CatalogMenu.listProducts(ProductType.COSMETIC);
                    break;
                case 4:
                    System.out.println("Comida");
                    CatalogMenu.listProducts(ProductType.FOOD);
                    break;
                case 5:
                    System.out.println("Habitat");
                    CatalogMenu.listProducts(ProductType.HABITAT);
                    break;
                case 6:
                    System.out.println("Medicamentos");
                    CatalogMenu.listProducts(ProductType.MEDICINE);
                    break;
                case 7:
                    System.out.println("Higiene");
                    CatalogMenu.listProducts(ProductType.HYGIENE);
                    break;
                case 8:
                    System.out.println("Sair");
                    return;
                case 42:
                    System.out.println("Menu Secreto");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (true);
    }

    private static void viewAnimals(boolean areAnimalsReal) {
        ProductType aerialType = areAnimalsReal ? ProductType.ANIMAL_REAL_AERIAL : ProductType.ANIMAL_IMAGINARY_AERIAL;
        ProductType landType = areAnimalsReal ? ProductType.ANIMAL_REAL_LAND : ProductType.ANIMAL_IMAGINARY_LAND;
        ProductType aquaticType = areAnimalsReal ? ProductType.ANIMAL_REAL_AQUATIC : ProductType.ANIMAL_IMAGINARY_AQUATIC;

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

    private static void searchClient() {
        do {
            System.out.println("Pesquisar cliente");
            System.out.println("1 - Filtrar por Nome");
            System.out.println("2 - Listagem de todos os clientes");
            System.out.println("3 - Voltar");
            System.out.print("Insira uma opção: ");

            switch (Ler.umInt()) {
                case 1:
                    HashMap<Integer, Client> clients = filterByName(Ler.umaString());
                    if (clients.isEmpty()) System.out.println("Não há clientes com esse nome");
                    clients.forEach((k, v) -> System.out.println((k + 1) + " - " + v));
                    break;
                case 2:
                    for (int i = 0; i < Main.clients.size(); i++) {
                        System.out.println((i + 1) + " - " + Main.clients.get(i));
                    }
                    break;
                case 3:
                    System.out.println("<-");
                    return;
            }
        } while (true);
    }

    private static int selectClientID() {
        System.out.println("Insira id do cliente:");
        int id = Ler.umInt();
        do {
            System.out.println("Selecionou o cliente " + Main.clients.get(id - 1) + ".");
            System.out.println("1 - Prosseguir com este cliente");
            System.out.println("2 - Reescolher cliente");
            System.out.println("3 - Cancelar compra");
            switch (Ler.umInt()) {
                case 1:
                    return id - 1;
                case 2:
                    return -1;
                case 3:
                    return -2;
                default:
                    System.out.println("Operação inválida!");
            }

        } while (true);
    }

    private static HashMap<Integer, Client> filterByName(String name) {
        HashMap<Integer, Client> clients = new HashMap<>();
        for (int i = 0; i < Main.clients.size(); i++) {
            Client c = Main.clients.get(i);
            if (c.getName().contains(name)) {
                clients.put(i, c);
            }
        }
        return clients;
    }

    private static void createNewClient() {
        System.out.println("INFORMAÇÃO");
        System.out.println("Para registar um novo cliente, as seguintes informações são obrigatórias:");
        System.out.println("- Nome");
        System.out.println("- Contacto telefónico");
        System.out.println("- Nif");

        System.out.println("As informações seguintes são apenas opcionais:");
        System.out.println("- Género");
        System.out.println("- Email");
        System.out.println("- Data de nascimento");


        System.out.println("Deseja prosseguir? (Y/N");
        while (true) {
            switch (Ler.umChar()) {
                case 'Y':
                case 'y':
                    //código bravo


                    break;
                case 'N':
                case 'n':
                    System.out.println("<-");
                    return;

                default:
                    System.out.println("Opção inválida!");

            }

        }

    }

    private static void createNewProduct() {
    }
}
