package src;

import src.ClassesMenu.MainMenu;
import src.ClassesLoja.*;
import src.Enum.ProductType;
import src.ClassesLoja.File;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<ProductType, ArrayList<Product>> products;
    public static ArrayList<Client> clients;
    public static ArrayList<Employee> employees;

    public static void main(String[] args) {
        init();

        // Shows main menu
        MainMenu.show();
    }

    public static void init() {
        // Initializes the product by type
        products = new HashMap<>();

        products.put(ProductType.ANIMAL_REAL_LAND, File.binRead("Animal/Real/Land.dat"));
        products.put(ProductType.ANIMAL_REAL_AQUATIC, File.binRead("Animal/Real/Aquatic.dat"));
        products.put(ProductType.ANIMAL_REAL_AERIAL, File.binRead("Animal/Real/Aerial.dat"));

        products.put(ProductType.ANIMAL_IMAGINARY_LAND, File.binRead("Animal/Imaginary/Land.dat"));
        products.put(ProductType.ANIMAL_IMAGINARY_AQUATIC, File.binRead("Animal/Imaginary/Aquatic.dat"));
        products.put(ProductType.ANIMAL_IMAGINARY_AERIAL, File.binRead("Animal/Imaginary/Aerial.dat"));

        products.put(ProductType.COSMETIC, File.binRead("Cosmetics/Cosmetics.dat"));
        products.put(ProductType.FOOD, File.binRead("Food/Food.dat"));
        products.put(ProductType.HABITAT, File.binRead("Habitat/Habitat.dat"));
        products.put(ProductType.HYGIENE, File.binRead("Hygiene/Hygiene.dat"));
        products.put(ProductType.MEDICINE, File.binRead("Medicine/Medicine.dat"));

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