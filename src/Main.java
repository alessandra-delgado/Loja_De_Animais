package src;

import src.ClassesMenu.Menu;
import src.Classes_Loja.*;
import src.Files.files;

import java.io.File;
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
        animals_r = new ArrayList<>();
        animals_i = new ArrayList<>();
        cosmetics = new ArrayList<>();
        food = new ArrayList<>();
        habitat = new ArrayList<>();
        hygiene = new ArrayList<>();
        medicine = new ArrayList<>();
        secret = new ArrayList<>();

    }




}
