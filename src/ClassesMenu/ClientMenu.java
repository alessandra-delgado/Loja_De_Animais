package src.ClassesMenu;

import src.ClassesLoja.*;
import src.Exceptions.ClientNotFoundException;
import src.FormValidation.Form;
import src.Input.Ler;
import src.Main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientMenu {
    public static void menu() {
        System.out.println("╭──────────────────────────╮");
        System.out.println("│ 1 - Pesquisar Clientes   │");
        System.out.println("│ 2 - Adicionar Clientes   │");
        System.out.println("│ 3 - Atualizar Clientes   │");
        System.out.println("│ 4 - Visualizar Clientes  │");
        System.out.println("│ 5 - Histórico de Compras │");
        System.out.println("│ 6 - Voltar               │");
        System.out.println("╰──────────────────────────╯");
        System.out.print("Escolha uma opção: ");
    }

    public static void show() {
        do {
            ClientMenu.menu();

            switch (Ler.umInt()) {
                case 1:
                    ClientMenu.searchClient();
                    break;
                case 2:
                    System.out.println("Adicionar clientes");
                    ClientMenu.createNewClient();
                    break;
                case 3:
                    updateClient();
                    File.binWrite(Main.clients, "Client/Client.dat");
                    break;
                case 4:
                    viewClient();
                    break;
                case 5:
                    purchaseHistory();
                    break;
                case 6:
                    System.out.println("A voltar ...");
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);
    }

    public static void searchClient() {
        do {
            System.out.println("Pesquisar cliente");
            System.out.println("1 - Filtrar por Nome ");
            System.out.println("2 - Listagem de todos os clientes");
            System.out.println("3 - Voltar");
            System.out.print("Insira uma opção: ");

            switch (Ler.umInt()) {
                case 1:
                    System.out.print("Insira um nome: ");
                    String name = Ler.umaString();

                    HashMap<Integer, Client> clients = ClientMenu.filterByName(name);

                    if (clients.isEmpty())
                        System.out.println("Não há clientes com esse nome");

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
                default:
                    System.out.println("Opção inválida.");
            }
        } while (true);
    }

    public static void updateClient() {
        try {
            while (true) {
                System.out.println("Digite o NIF do cliente: ");
                int nif = Ler.umInt();
                Client cliente = findByNIF(nif);
                System.out.println("Cliente encontrado: " + cliente.getName());
                System.out.println("O que quer atualizar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Telefone");
                System.out.println("3 - Género");
                System.out.println("4 - Data de nascimento");
                System.out.println("5 - NIF");
                System.out.println("6 - Voltar");
                System.out.print("Insira uma opção: ");
                switch (Ler.umInt()) {
                    case 1:
                        System.out.print("Novo nome: ");
                        cliente.setName(Ler.umaString());
                        return;
                    case 2:
                        System.out.print("Novo telefone: ");
                        cliente.setTel(Ler.umInt());
                        return;
                    case 3:
                        System.out.println("Novo género: ");
                        cliente.setGender(Form.insertGender());
                        return;
                    case 4:
                        System.out.println("Nova data de nascimento:");
                        cliente.setBirthdate(Form.insertDate());
                        return;
                    case 5:
                        do {
                            System.out.print("Novo NIF: ");
                            nif = Ler.umInt();
                            try {
                                findByNIF(nif);
                                System.out.println("Já existe um cliente com o NIF introduzido!");
                            } catch (ClientNotFoundException e) {
                                cliente.setNif(nif);
                                break;
                            }

                        } while (true);
                        return;
                    case 6:
                        System.out.println("A voltar");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println("Cliente atualizado!");
            }
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewClient() {
        if (Main.clients.isEmpty()) {
            System.out.println("Nenhum cliente registado");
        } else {
            System.out.println("Lista de clientes registados:");
            for (Client cliente : Main.clients) {
                System.out.println(cliente);
                System.out.println("------------------------");
            }
        }
    }

    public static void purchaseHistory() {
        System.out.println("Digite o NIF do cliente: ");
        int nif = Ler.umInt();

        try {
            Client cliente = findByNIF(nif);

            System.out.println("Histórico de compras de " + cliente.getName() + ":");
            ArrayList<Purchase> purchases = cliente.getPurchases();

            if (purchases.isEmpty()) {
                System.out.println("Nenhuma compra foi realizada pelo cliente");
            } else {
                for (Purchase p : purchases) {
                    System.out.println(p);
                    System.out.println("------------------------");
                }
            }

        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Client findByNIF(int nif) throws ClientNotFoundException {
        for (Client client : Main.clients) {
            if (client.getNif() == nif) {
                return client;
            }
        }
        throw new ClientNotFoundException("Cliente com o NIF " + nif + " não está registado");
    }

    public static HashMap<Integer, Client> filterByName(String name) {
        HashMap<Integer, Client> clients = new HashMap<>();
        for (int i = 0; i < Main.clients.size(); i++) {
            Client c = Main.clients.get(i);
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                clients.put(i, c);
            }
        }
        return clients;
    }

    public static int createNewClient() {
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
                    do {
                        System.out.print("Nif: ");
                        int nif = Ler.umInt();
                        try {
                            findByNIF(nif);
                            System.out.println("Já existe um cliente com o NIF introduzido!");
                        } catch (ClientNotFoundException e) {
                            c.setNif(nif);
                            break;
                        }
                    } while (true);

                    System.out.print("Deseja inserir o género? (Y para confirmar) ");
                    switch (Ler.umChar()) {
                        case 'Y', 'y':
                            System.out.print("Género: ");
                            c.setGender(Form.insertGender());
                    }

                    System.out.print("Deseja inserir a data de nascimento? (Y para confirmar) ");
                    switch (Ler.umChar()) {
                        case 'Y', 'y':
                            c.setBirthdate(Form.insertDate());
                            break;
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
}