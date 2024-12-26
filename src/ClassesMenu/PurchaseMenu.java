package src.ClassesMenu;

// Todo: escrever fatura para o ficheiro de faturas, Formatar fatura!

import src.ClassesLoja.File;
import src.ClassesLoja.Product;
import src.ClassesLoja.Purchase;
import src.Input.Ler;
import src.Main;

import java.util.concurrent.atomic.AtomicReference;

public class PurchaseMenu {
    public static void show() {
        Purchase purchase = new Purchase();
        int opt;
        int id_selected = -1;

        // 1 - Choose client
        do {
            System.out.println("Escolher um cliente para a operação (por id)");
            System.out.println("1 - Pesquisar cliente");
            System.out.println("2 - Inserir id de cliente");
            System.out.println("3 - Novo cliente");
            System.out.println("4 - Voltar");
            System.out.print("Insira uma opção: ");

            switch (Ler.umInt()) {
                case 1:
                    MenuClient.searchClient();
                    break;
                case 2:
                    id_selected = selectClientID();
                    if (id_selected == -2) {
                        System.out.println("Compra cancelada");
                        return;
                    }

                    if (id_selected == -1) {
                        continue;
                    }

                    System.out.println("Cliente selecionado com sucesso! (id : " + (id_selected + 1) + ")");
                    break;
                case 3:
                    id_selected = MenuClient.createNewClient();

                    if (id_selected == -1) {
                        continue;
                    }

                    System.out.println("Cliente registado e selecionado com sucesso! (id : " + (id_selected + 1) + ")");
                    break;
                case 4:
                    System.out.println("<-");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (id_selected == -1);

        // 2 - Choose products
        do {
            System.out.println("Carrinho de Compras: ");
            System.out.println(purchase.getProducts());
            System.out.println("--------------------------------------------");
            System.out.println("Adicione produtos para a compra");
            System.out.println("1 - Visualizar Catálogo");
            System.out.println("2 - Adicionar produto à lista de compras");
            System.out.println("3 - Remover produto da lista de compras");
            System.out.println("4 - Finalizar compra");
            System.out.println("5 - Cancelar compra");
            System.out.print("Insira uma opção: ");

            opt = Ler.umInt();

            switch (opt) {
                case 1:
                    CatalogMenu.show();
                    break;
                case 2:
                    Product product = selectProductID();
                    if (product == null)
                        continue;

                    purchase.addProduct(product);

                    System.out.println("Produtos: " + purchase.getProducts());
                    break;
                case 3:
                    if (purchase.getProducts().isEmpty()) {
                        System.out.println("Ainda não foram adicionados produtos ao carrinho");
                        continue;
                    }

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
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opt != 4 || purchase.getProducts().isEmpty());

        // 3 - Write fatura file and display buy info on screen
        System.out.println("Obrigado Pela Compra");
        Main.clients.get(id_selected).addPurchase(purchase);

        File.binWrite(Main.clients, "Client/Client.dat");

        System.out.println(Main.clients.get(id_selected));
        System.out.println(purchase.getProducts());
    }

    private static int selectClientID() {
        if (Main.clients.isEmpty()) {
            System.out.println("Não existem clientes.");
            return -1;
        }

        System.out.print("Insira id do cliente: ");
        int id = Ler.umInt();

        if (id <= 0 || id > Main.clients.size()) {
            System.out.println("O id inserido não é válido.");
            return -1;
        }

        do {
            System.out.println("Selecionou o cliente " + Main.clients.get(id - 1) + ".");
            System.out.println("1 - Prosseguir com este cliente");
            System.out.println("2 - Reescolher cliente");
            System.out.println("3 - Cancelar compra");
            System.out.print("Opção inserida: ");

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

    private static Product selectProductID() {
        AtomicReference<Product> selected = new AtomicReference<>();

        System.out.print("Insira o id do produto: ");
        int id = Ler.umInt();

        Main.products.forEach((_, products) -> {
            for (Product p : products) {
                if (p.getId() == id) {
                    selected.set(p);
                    break;
                }
            }
        });

        while (selected.get() != null) {
            System.out.println("Selecionou o produto " + selected.get() + ".");
            System.out.println("1 - Prosseguir com este produto");
            System.out.println("2 - Reescolher produto");
            System.out.print("Opção introduzida: ");

            switch (Ler.umInt()) {
                case 1:
                    return selected.get();
                case 2:
                    return null;
                default:
                    System.out.println("Operação inválida!");
                    break;
            }
        }

        System.out.println("Erro: Não existe nenhum produto com o id introduzido");

        return null;
    }

    private static void removeSelectedProduct(Purchase purchase) {
        do {
            System.out.println("1 - Remover todos os produtos");
            System.out.println("2 - Remover um produto");
            System.out.print("Opção introduzida: ");

            switch (Ler.umInt()) {
                case 1:
                    purchase.removeAllProducts();
                    return;
                case 2:
                    for (int i = 0; i < purchase.getProducts().size(); i++) {
                        System.out.println((i + 1) + " - " + purchase.getProducts().get(i));
                    }
                    do {
                        System.out.print("Insira o produto que deseja remover (índice): ");
                        int opt = Ler.umInt();
                        if (opt > 0 && opt <= purchase.getProducts().size()) {
                            purchase.removeProduct(opt - 1);
                            return;
                        } else System.out.println("Índice inválido!");
                    } while (true);
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (true);
    }
}