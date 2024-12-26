package src.ClassesMenu;

import src.Classes_Loja.Client;
import src.Classes_Loja.Purchase;
import src.Input.Ler;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MenuClients {
    private static final String Clientes_file = "Client/Client.dat";
    private static ArrayList<Client> clientes = new ArrayList<>() ;
    public static void menu() {
        System.out.println("1 - Adicionar Clientes");
        System.out.println("2 - Atualizar Clientes ");
        System.out.println("3 - Visualizar Clientes ");
        System.out.println("4 - Histórico de compras ");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção:");
    }

    public static void show() {
        int op = 0;
        while (true) {
            MenuClients.menu();
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Adicionar clientes");
                    return;
                case 2:
                    updateClient();
                    saveClients();
                    return;
                case 3:
                    viewClient();
                    return;
                case 4:
                    purchaseHistory();
                    return;
                case 5:
                    System.out.println("A sair ...");
                    return;
                default:
                    break;
            }
        }
    }
    public static void updateClient() {
        System.out.println("Digite o NIF do cliente: ");
        int nif = Ler.umInt();
        Client cliente = findByNIF(nif);

        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getName());
            System.out.println("O que quer atualizar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Telefone");
            System.out.println("3 - Email");
            System.out.println("4 - Género");
            System.out.println("5 - Data de nascimento");
            System.out.println("6 - NIF");
            System.out.println("7 - Sair");

            while(true) {
                switch (Ler.umInt()) {
                    case 1:
                        System.out.println("Novo nome:");
                        cliente.setName(Ler.umaString());
                        return;
                    case 2:
                        System.out.println("Novo telefone:");
                        cliente.setTel(Ler.umInt());
                        return;
                    case 3:
                        System.out.println("Novo email:");
                        cliente.setEmail(Ler.umaString());
                        return;
                    case 4:
                        System.out.println("Novo género (M/F):");
                        cliente.setGender(Ler.umChar());
                        return;
                    case 5:
                        System.out.println("Nova data de nascimento (AAAA-MM-DD):");
                        cliente.setBirthdate(LocalDate.parse(Ler.umaString()));
                        return;
                    case 6:
                        System.out.println("Novo NIF:");
                        cliente.setNif(Ler.umInt());
                        return;
                    case 7:
                        System.out.println("A sair");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println("Cliente atualizado!");
            }
        }else{
            System.out.println("Cliente com o NIF " + nif + " não encontrado");
        }

    }
    public static void viewClient() {
        if(clientes.isEmpty()) {
            System.out.println("Nenhum cliente registado");
        } else {
            System.out.println("Lista de clientes registados:");
            for (Client cliente : clientes) {
                System.out.println(cliente);
                System.out.println("------------------------");
            }
        }
    }
    public static void purchaseHistory() {
        System.out.println("Digite o NIF do cliente: ");
        int nif = Ler.umInt();
        Client cliente = findByNIF(nif);

        if (cliente != null) {
            System.out.println("Histórico de compras de " + cliente.getName() + ":");
            ArrayList<Purchase> purchases = cliente.getPurchases();

            if (purchases.isEmpty()) {
                System.out.println("Nenhum compra foi realizada pelo cliente");
            } else {
                for (Purchase p : purchases) {
                    System.out.println(p);
                    System.out.println("------------------------");
                }
            }
        }else{
            System.out.println("Cliente com o NIF " + nif + " não está registado");
        }
    }
    public static Client findByNIF(int nif) {
        for(Client client : clientes){
            if (client.getNif() == nif){
                return client;
            }
        }
        return null;
    }
    public static void loadClients() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(Clientes_file))) {
            clientes = (ArrayList<Client>) obj.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o ficheiro: " + e.getMessage());
        }
    }
    public static void saveClients() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(Clientes_file))){
            obj.writeObject(clientes);
        } catch (Exception e) {
            System.out.println("Erro ao gravar os clientes: " + e.getMessage());
        }
    }
}