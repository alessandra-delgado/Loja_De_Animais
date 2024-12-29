package src;

import src.ClassesMenu.MainMenu;
import src.ClassesLoja.*;
import src.Enum.ProductType;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<ProductType, ArrayList<Product>> products;
    public static ArrayList<Client> clients;
    public static ArrayList<Employee> employees;

    public static void main(String[] args) {
        init();

        // Shows main menu
        System.out.println("Bem-vindo à Puro Pet, uma loja de animais um tanto complexa.");
        MainMenu.show();
        System.out.println("Volte sempre!");
    }

    public static void init() {
        // Initializes the product by type
        products = new HashMap<>();
        for(ProductType type : ProductType.values())
            if(type != ProductType.NONE)
                products.put(type, File.binRead(type.getFilePath()));

        // Clients
        clients = File.binRead("Client/Client.dat");
        // Employees
        employees = File.binRead("Employee/Employee.dat");

        // Set Product ID
        Product.setLast(File.binReadInt("Product/LastId.dat"));
        // Set Purchase ID
        Purchase.setLast(File.binReadInt("Purchase/LastId.dat"));

    }

    public static void saveData() {
        // All products (animals included)
        for(ProductType type : ProductType.values()) {
            if (type != ProductType.NONE)
                File.binWrite(Main.products.get(type), type.getFilePath());
        }

        // Clients and employees
        File.binWrite(clients, "Client/Client.dat");
        File.binWrite(employees, "Employee/Employee.dat");

        // Last IDs
        File.binWriteInt(Purchase.getLast(), "Purchase/LastId.dat");
        File.binWriteInt(Product.getLast(), "Product/LastId.dat");

    }

    public static void listProducts(ProductType type) {
        for (Product p : Main.products.get(type)) {
            System.out.println(p);
        }
    }

    public static void presetData() {
        //todo: create objects

        // products --------------------------------
        // animal field


        // cosmetic field


        // food field
        

        // habitat field


        // hygiene field


        // medicine field


        // clients ---------------------------------


        // employees -------------------------------


        // Guardar todos os produtos
        saveData();
    }
}