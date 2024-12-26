package src.ClassesMenu;

// Todo: try catch <-> verificações, organizar, escrever fatura para o ficheiro de faturas, Formatar fatura!

import src.Classes_Loja.Client;
import src.Classes_Loja.File;
import src.Classes_Loja.Product;
import src.Classes_Loja.Purchase;
import src.Enum.ProductType;
import src.Input.Ler;
import src.Main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

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
        Purchase purchase = new Purchase();

        int id_selected = -1;

        // 1 - Choose client----
        do {
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
                    id_selected = selectClientID();
                    if (id_selected == -2) {
                        System.out.println("<-");
                        return;
                    }

                    if (id_selected == -1) {
                        continue;
                    }

                    System.out.println("Cliente selecionado com sucesso! (id : " + (id_selected + 1) + ")");
                    break;
                case 3:
                    id_selected = createNewClient();

                    if (id_selected == -1) {
                        continue;
                    }

                    System.out.println("Cliente registado e selecionado com sucesso! (id : " + (id_selected + 1) + ")");
                    break;

                case 4:
                    System.out.println("<-");
                    return;
            }
        } while (id_selected == -1);

        // 2 - Choose products
        int opt;
        do {
            System.out.println("Adicione produtos para a compra (por indice)");
            System.out.println("1 - Visualizar Catálogo");
            System.out.println("2 - Adicionar produto à lista de compras");
            System.out.println("3 - Remover produto da lista de compras");
            System.out.println("4 - Finalizar compra");
            System.out.println("5 - Cancelar compra");
            System.out.print("Insira uma opção: ");

            opt = Ler.umInt();

            switch (opt) {
                case 1:
                    viewCatalog();
                    break;
                case 2:
                    Product product = selectProductID();
                    if (product == null)
                        continue;

                    purchase.addProduct(product);

                    System.out.println("Produtos: " + purchase.getProducts());
                    break;
                case 3:
                    removeSelectedProduct(purchase);
                    break;
                case 4:
                    if (purchase.getProducts().isEmpty()) {
                        System.out.println("Necessita de especificar pelo menos um produto");
                    }
                    break;
                case 5:
                    System.out.println("<-");
                    return;
            }


        } while (opt != 4 || purchase.getProducts().isEmpty());

        // 4 - Write fatura file and display buy info on screen
        System.out.println("Obrigado Pela Compra");
        Main.clients.get(id_selected).addPurchase(purchase);

        File.binWrite(Main.clients, "Client/Client.dat");

        System.out.println(Main.clients.get(id_selected));
        System.out.println(purchase.getProducts());
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
        System.out.print("Insira id do cliente: ");
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

    private static int createNewClient() {
        System.out.println("INFORMAÇÃO");
        System.out.println("Para registar um novo cliente, as seguintes informações são obrigatórias:");
        System.out.println("- Nome");
        System.out.println("- Contacto telefónico");
        System.out.println("- Nif");

        System.out.println("As informações seguintes são apenas opcionais:");
        System.out.println("- Género");
        System.out.println("- Data de nascimento");


        System.out.println("Deseja prosseguir? (Y/N)");
        while (true) {
            switch (Ler.umChar()) {
                case 'Y', 'y':
                    Client c = new Client();
                    System.out.print("Nome: ");
                    c.setName(Ler.umaString());
                    System.out.print("Contato: ");
                    c.setTel(Ler.umInt());
                    System.out.print("Nif: ");
                    c.setNif(Ler.umInt());

                    System.out.print("Deseja inserir o género? (Y para confirmar) ");
                    switch (Ler.umChar()) {
                        case 'Y', 'y':
                            System.out.print("Género: ");
                            c.setGender(Ler.umChar());
                    }

                    System.out.print("Deseja inserir a data de nascimento? (Y para confirmar) ");
                    switch (Ler.umChar()) {
                        case 'Y', 'y':
                            System.out.print("Deve inserir no formato YYYY-MM-DD: ");
                            c.setBirthdate(LocalDate.parse(Ler.umaString()));
                    }

                    System.out.println("Cliente registado com sucesso!");
                    System.out.println(c);
                    Main.clients.add(c);
                    File.binWrite(Main.clients, "Client/Client.dat");
                    return Main.clients.size() - 1;

                case 'N', 'n':
                    System.out.println("Registo de cliente cancelado.");
                    return -1;

                default:
                    System.out.println("Opção inválida!");
            }

        }

    }

    private static Product selectProductID() {
        AtomicReference<Product> selected = new AtomicReference<>();

        System.out.println("Insira id do produto:");
        int id = Ler.umInt();

        Main.products.forEach((_, products) -> {
            for (Product p : products) {
                if (p.getId() == id) {
                    selected.set(p);
                    break;
                }
            }
        });

        do {
            System.out.println("Selecionou o produto " + selected.get() + ".");
            System.out.println("1 - Prosseguir com este produto");
            System.out.println("2 - Reescolher produto");
            switch (Ler.umInt()) {
                case 1:
                    return selected.get();
                case 2:
                    return null;
                default:
                    System.out.println("Operação inválida!");
            }

        } while (true);
    }

    private static void removeSelectedProduct(Purchase purchase) {
        while(true) {
            System.out.println("1 - Remover todos os produtos");
            System.out.println("2 - Remover um produto");
            switch (Ler.umInt()) {
                case 1:
                    purchase.removeAllProducts();
                    return;
                case 2:
                    for (int i = 0; i < purchase.getProducts().size(); i++) {
                        System.out.println((i + 1) + " - " + purchase.getProducts().get(i));
                    }
                    while (true) {
                        System.out.print("Insira o produto que deseja remover (índice): ");
                        int opt = Ler.umInt();
                        if (opt > 0 && opt <= purchase.getProducts().size()) {
                            purchase.removeProduct(opt - 1);
                            return;
                        } else System.out.println("Índice inválido!");
                    }
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}