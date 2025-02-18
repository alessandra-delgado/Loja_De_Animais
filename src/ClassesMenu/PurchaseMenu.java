package src.ClassesMenu;

import src.ClassesLoja.*;
import src.Exceptions.ProductNotFoundException;
import src.Exceptions.ProductStockExceededException;
import src.Input.Ler;
import src.Main;

public class PurchaseMenu {
    public static void show() {
        Purchase purchase = new Purchase();
        int opt;
        int id_selected = -1;

        // 1 - Choose client
        do {
            System.out.println("╭──────────────────────────────────────────────────╮");
            System.out.println("│ Escolher um cliente para a operação (por índice) │");
            System.out.println("│ 1 - Pesquisar cliente                            │");
            System.out.println("│ 2 - Inserir índice de cliente                    │");
            System.out.println("│ 3 - Novo cliente                                 │");
            System.out.println("│ 4 - Voltar                                       │");
            System.out.println("╰──────────────────────────────────────────────────╯");
            System.out.print("Insira uma opção: ");

            switch (Ler.umInt()) {
                case 1:
                    ClientMenu.searchClient();
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

                    System.out.println("Cliente selecionado com sucesso! (índice : " + (id_selected + 1) + ")");
                    break;
                case 3:
                    id_selected = ClientMenu.createNewClient();

                    if (id_selected == -1) {
                        continue;
                    }

                    System.out.println("Cliente registado e selecionado com sucesso! (índice : " + (id_selected + 1) + ")");
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
                    if (product == null) // Either the product does not exist, or the user wants to choose another product
                        continue;

                    try {
                        purchase.addProduct(product);
                        if(product instanceof Animal)
                            ((Animal) product).viewAnimal();
                    } catch (ProductStockExceededException e) {
                        System.out.println(e.getMessage());
                    } // Redundant, but necessary if changes are made in the code

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
                    if (!purchase.getProducts().isEmpty()) purchase.removeAllProducts();
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

        Main.saveData(); // Update Quantities after finishing purchase
        purchase.printInvoice(Main.clients.get(id_selected));
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
        System.out.print("Insira o id do produto: ");
        int id = Ler.umInt();

        try {
            Product product = ProductMenu.findProductById(id);

            // If the product is not in stock, warn user. Exits Product selection with null.
            if (product.getQuantity() == 0)
                throw new ProductStockExceededException("O produto selecionado não está em stock.");

            do {
                System.out.println("Selecionou o produto " + product + ".");
                System.out.println("1 - Prosseguir com este produto");
                System.out.println("2 - Reescolher produto");
                System.out.print("Opção introduzida: ");

                switch (Ler.umInt()) {
                    case 1:
                        return product;
                    case 2:
                        return null;
                    default:
                        System.out.println("Operação inválida!");
                        break;
                }
            } while (true);

        } catch (ProductNotFoundException | ProductStockExceededException e) {
            System.out.println(e.getMessage());
        }

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