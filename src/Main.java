package src;

import src.ClassesMenu.MainMenu;
import src.Classes_Loja.*;
import src.Enum.AnimalType;
import src.Enum.ProductType;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<ProductType, ArrayList<Product>> products;

    public static void main(String[] args) {
        System.out.println("Hello World");
        init();
        fakeData();

        // Shows main menu
        MainMenu mainMenu = new MainMenu();
        mainMenu.show();
    }

    public static void init() {
        // Initializes the product by type
        products = new HashMap<>();

        products.put(ProductType.ANIMAL_REAL_LAND, new ArrayList<>());
        products.put(ProductType.ANIMAL_REAL_AQUATIC, new ArrayList<>());
        products.put(ProductType.ANIMAL_REAL_AERIAL, new ArrayList<>());

        products.put(ProductType.ANIMAL_IMAGINARY_LAND, new ArrayList<>());
        products.put(ProductType.ANIMAL_IMAGINARY_AQUATIC, new ArrayList<>());
        products.put(ProductType.ANIMAL_IMAGINARY_AERIAL, new ArrayList<>());

        products.put(ProductType.COSMETIC, new ArrayList<>());
        products.put(ProductType.FOOD, new ArrayList<>());
        products.put(ProductType.HABITAT, new ArrayList<>());
        products.put(ProductType.HYGIENE, new ArrayList<>());
        products.put(ProductType.MEDICINE, new ArrayList<>());
    }

    public static void fakeData() {
        products.get(ProductType.ANIMAL_REAL_LAND).add(new Animal(6, "F", "Cat Catus", "cat", AnimalType.LAND));
        products.get(ProductType.ANIMAL_REAL_LAND).add(new Animal(12, "M", "Cat Catus", "cat", AnimalType.LAND));
        products.get(ProductType.ANIMAL_REAL_LAND).add(new Animal(33, "F", "Cat Catus", "cat", AnimalType.LAND));
    }
}

