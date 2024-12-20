package src;

import src.ClassesMenu.Menu;
import src.Classes_Loja.*;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Animal> animals_r;
    public static ArrayList<Animal> animals_i;
    public static ArrayList<Product> cosmetics;
    public static ArrayList<Product> food;
    public static ArrayList<Product> habitat;
    public static ArrayList<Product> hygiene;
    public static ArrayList<Product> medicine;
    public static ArrayList<Product> secret;


    public static void main(String[] args) {
        System.out.println("Hello World");
        init();


        Menu.main();
    }

    public static void init(){
        ArrayList<ArrayList<Animal>> animals_r = new ArrayList<>();
        ArrayList<ArrayList<Animal>> animals_i = new ArrayList<>();
        ArrayList<Product> cosmetics = new ArrayList<>();
        ArrayList<Product> food = new ArrayList<>();
        ArrayList<Product> habitat = new ArrayList<>();
        ArrayList<Product> hygiene = new ArrayList<>();
        ArrayList<Product> medicine = new ArrayList<>();
        ArrayList<Product> secret = new ArrayList<>();

    }
}
