package src;

import src.ClassesMenu.MainMenu;
import src.Classes_Loja.*;
import src.Enum.ProductType;
import src.Files.File;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<ProductType, ArrayList<Product>> products;

    public static void main(String[] args) {
        init();

        // Shows main menu
        MainMenu.show();
    }

    public static void init() {
        // Initializes the product by type
        products = new HashMap<>();

        products.put(ProductType.ANIMAL_REAL_LAND, File.loadInfo("Animal/Imaginary/Land.dat"));
        products.put(ProductType.ANIMAL_REAL_AQUATIC, File.loadInfo("Animal/Imaginary/Aquatic.dat"));
        products.put(ProductType.ANIMAL_REAL_AERIAL, File.loadInfo("Animal/Imaginary/Aerial.dat"));

        products.put(ProductType.ANIMAL_IMAGINARY_LAND, File.loadInfo("Animal/Real/Land.dat"));
        products.put(ProductType.ANIMAL_IMAGINARY_AQUATIC, File.loadInfo("Animal/Real/Aquatic.dat"));
        products.put(ProductType.ANIMAL_IMAGINARY_AERIAL, File.loadInfo("Animal/Real/Aerial.dat"));

        products.put(ProductType.COSMETIC, File.loadInfo("Cosmetics/Cosmetics.dat"));
        products.put(ProductType.FOOD, File.loadInfo("Food/Food.dat"));
        products.put(ProductType.HABITAT, File.loadInfo("Habitat/Habitat.dat"));
        products.put(ProductType.HYGIENE, File.loadInfo("Hygiene/Hygiene.dat"));
        products.put(ProductType.MEDICINE, File.loadInfo("Medicine/Medicine.dat"));
    }
}
