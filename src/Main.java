package src;

import src.ClassesMenu.MainMenu;
import src.Classes_Loja.*;
import src.Enum.ProductType;
import src.Classes_Loja.File;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<ProductType, ArrayList<Product>> products;
    public static ArrayList<Client> clients;
    public static ArrayList<Client> employees;

    public static void main(String[] args) {
        init();

        // Shows main menu
        MainMenu.show();
    }

    public static void init() {
        // Initializes the product by type
        products = new HashMap<>();

        products.put(ProductType.ANIMAL_REAL_LAND, File.binRead("Animal/Imaginary/Land.dat"));
        products.put(ProductType.ANIMAL_REAL_AQUATIC, File.binRead("Animal/Imaginary/Aquatic.dat"));
        products.put(ProductType.ANIMAL_REAL_AERIAL, File.binRead("Animal/Imaginary/Aerial.dat"));

        products.put(ProductType.ANIMAL_IMAGINARY_LAND, File.binRead("Animal/Real/Land.dat"));
        products.put(ProductType.ANIMAL_IMAGINARY_AQUATIC, File.binRead("Animal/Real/Aquatic.dat"));
        products.put(ProductType.ANIMAL_IMAGINARY_AERIAL, File.binRead("Animal/Real/Aerial.dat"));

        products.put(ProductType.COSMETIC, File.binRead("Cosmetics/Cosmetics.dat"));
        products.put(ProductType.FOOD, File.binRead("Food/Food.dat"));
        products.put(ProductType.HABITAT, File.binRead("Habitat/Habitat.dat"));
        products.put(ProductType.HYGIENE, File.binRead("Hygiene/Hygiene.dat"));
        products.put(ProductType.MEDICINE, File.binRead("Medicine/Medicine.dat"));

        // Clients
        clients = File.binRead("Client/Client.dat");

        // Employees
        employees = File.binRead("Employee/Employee.dat");
    }
}
