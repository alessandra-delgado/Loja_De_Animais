package src.ClassesMenu;
import java.util.ArrayList;
import src.Classes_Loja.Product;
import src.Enum.ProductType;
import src.Classes_Loja.File;
import src.Input.Ler;
import src.Main;

import javax.swing.*;


public class MenuProduct {
    private static void menu() {
        System.out.println("1 - Adicionar Produtos");
        System.out.println("2 - Atualizar Produtos");
        System.out.println("3 - Visualizar Produtos");
        System.out.println("4 - Eliminar Produtos");
        System.out.println("5 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void show() {
        while (true) {
            MenuProduct.menu();
            switch (Ler.umInt()) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    viewProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("A sair ...");
                    return;
            }
        }
    }

    private static void addProduct() {
        System.out.println("Que tipo de produto:");
        System.out.println("1 - Cosmeticos");
        System.out.println("2 - Comida");
        System.out.println("3 - Habitat");
        System.out.println("4 - Medicamentos");
        System.out.println("5 - Voltar");

        while (true) {
            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Qual o nome do cosmetico:");
                    String nome = Ler.umaString();
                    System.out.println("Qual o preco do cosmetico:");
                    double preco = Ler.umDouble();

                    //Cria produto
                    Product novoCosmetico = new Product(nome, preco);
                    //Adiciona á lista de cosméticos
                    novoCosmetico.setCategory(ProductType.COSMETIC);
                    Main.products.get(ProductType.COSMETIC).add(novoCosmetico);
                    File.binWrite(Main.products.get(ProductType.COSMETIC), "Cosmetics/Cosmetics.dat");

                    System.out.println("Cosmético registado!!");
                    return;
                case 2:
                    System.out.println("Qual o nome da comida:");
                    String nomeComida = Ler.umaString();
                    System.out.println("Qual o preco do comida:");
                    double precoComida = Ler.umDouble();

                    Product comida = new Product(nomeComida, precoComida);
                    comida.setCategory(ProductType.FOOD);
                    Main.products.get(ProductType.FOOD).add(comida);
                    File.binWrite(Main.products.get(ProductType.FOOD), "Food/Food.dat");
                    System.out.println("Comida registada!!");
                    return;
                case 3:
                    System.out.println("Qual o nome do habitat:");
                    String nomeHabitat = Ler.umaString();
                    System.out.println("Qual o preco do habitat:");
                    double precoHabitat = Ler.umDouble();

                    Product habitat = new Product(nomeHabitat, precoHabitat);
                    habitat.setCategory(ProductType.HABITAT);
                    Main.products.get(ProductType.HABITAT).add(habitat);
                    File.binWrite(Main.products.get(ProductType.HABITAT), "Habitat/Habitat.dat");
                    System.out.println("Habitat registado!!");
                    return;
                case 4:
                    System.out.println("Qual o nome do medicamento:");
                    String nomeMedicamento = Ler.umaString();
                    System.out.println("Qual o preco do medicamento:");
                    double precoMedicamento = Ler.umDouble();

                    Product medicamento = new Product(nomeMedicamento, precoMedicamento);
                    medicamento.setCategory(ProductType.MEDICINE);
                    Main.products.get(ProductType.MEDICINE).add(medicamento);
                    File.binWrite(Main.products.get(ProductType.MEDICINE), "Medicine/Medicine.dat");
                    System.out.println("Medicamento registado!!");
                    return;
                case 5:
                    System.out.println("A sair ...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    private static void updateProduct() {
        System.out.println("Qual o tipo do produto:");
        System.out.println("1 - Cosmeticos");
        System.out.println("2 - Comida");
        System.out.println("3 - Habitat");
        System.out.println("4 - Medicamentos");
        System.out.println("5 - Sair");

        String filePath = "";
        ProductType categoria = null;


        switch (Ler.umInt()) {
            case 1:

                categoria = ProductType.COSMETIC;
                System.out.println("Qual o nome do cosmético:");
                String cosmetico = Ler.umaString();

                Product cosmetics = findProduct(Main.products.get(ProductType.COSMETIC), cosmetico);
                    if (cosmetics != null) {
                        System.out.println("Cosmético encontrado!!");
                        System.out.println("Nome: " + cosmetics.getName());
                        System.out.println("Preço atual: " + cosmetics.getPrice());
                        System.out.println("Qual o novo preço?");
                        cosmetics.setPrice(Ler.umDouble());

                        File.binWrite(Main.products.get(ProductType.COSMETIC), "Cosmetics/Cosmetics.dat");
                        System.out.println("Preço atualizado!!");
                        return;
                    }else{
                        System.out.println("Cosmético não encontrado!");
                }
                break;
            case 2:
                categoria = ProductType.FOOD;
                System.out.println("Qual o nome da comida:");
                String comida = Ler.umaString();

                Product foods = findProduct(Main.products.get(ProductType.FOOD), comida);
                    if (foods != null){
                        System.out.println("Comida encontrado!!");
                        System.out.println("Nome: " + foods.getName());
                        System.out.println("Preço atual: " + foods.getPrice());
                        System.out.println("Qual o novo preço?");
                        foods.setPrice(Ler.umDouble());

                        File.binWrite(Main.products.get(ProductType.FOOD), "Food/Food.dat");
                        System.out.println("Preço atualizado!!");
                    }else {
                        System.out.println("Comida não encontrada!");
                    }
                break;

            case 3:
                filePath = "Loja_De_Animais/files/Habitat/Habitat.dat";
                categoria = ProductType.HABITAT;
                System.out.println("Qual o nome do habitat:");
                String habitat = Ler.umaString();

                Product habitats =  findProduct(Main.products.get(ProductType.HABITAT), habitat );
                if (habitats != null){
                    System.out.println("Habitat encontrado!!");
                    System.out.println("Nome: " + habitats.getName());
                    System.out.println("Preço atual: " + habitats.getPrice());
                    System.out.println("Qual o novo preço?");
                    habitats.setPrice(Ler.umDouble());

                    File.binWrite(Main.products.get(ProductType.HABITAT), "Habitat/Habitat.dat");
                    System.out.println("Preço atualizado!!");
                    }else{
                    System.out.println("Habitat não encontrado!");
                }
                break;
            case 4:
                categoria = ProductType.MEDICINE;
                System.out.println("Qual o nome do medicamento:");
                String medicamento = Ler.umaString();

                Product medicines = findProduct(Main.products.get(ProductType.MEDICINE), medicamento );
                if (medicines != null){
                    System.out.println("Medicamento encontrado!!");
                    System.out.println("Nome: " + medicines.getName());
                    System.out.println("Preço atual: " + medicines.getPrice());
                    System.out.println("Qual o novo preço?");
                    medicines.setPrice(Ler.umDouble());

                    File.binWrite(Main.products.get(ProductType.COSMETIC), "Medicine/Medicine.dat");
                    System.out.println("Preço atualizado!!");
                }else{
                    System.out.println("Medicamento não encontrado!");
                }
                break;
            case 5:
                System.out.println("A sair ...");
                return;
            default:
                System.out.println("Opção inválida.");
                break;
        }



    }
    private static void viewProduct() {
        System.out.println("Qual o tipo do produto:");
        System.out.println("1 - Cosmeticos");
        System.out.println("2 - Comida");
        System.out.println("3 - Habitat");
        System.out.println("4 - Medicamentos");
        System.out.println("5 - Voltar");

        String filePath = "";
        ProductType categoria = null;


        switch (Ler.umInt()) {
            case 1:
                filePath = "Loja_De_Animais/files/Cosmetics/Cosmetics.dat";
                categoria = ProductType.COSMETIC;
                System.out.println("Qual o nome do cosmético:");
                String cosmetico = Ler.umaString();

                Product cosmetics = findProduct(Main.products.get(ProductType.COSMETIC), cosmetico);
                if (cosmetics != null) {
                    System.out.println("Cosmético encontrado!!");
                    System.out.println("Nome: " + cosmetics.getName());
                    System.out.println("Preço atual: " + cosmetics.getPrice());
                    return;
                }else{
                    System.out.println("Cosmético não encontrado");
                }
                break;
            case 2:
                filePath = "Loja_De_Animais/files/Food/Food.dat";
                categoria = ProductType.FOOD;
                System.out.println("Qual o nome da comida:");
                String comida = Ler.umaString();

                Product foods = findProduct(Main.products.get(ProductType.FOOD), comida);
                if (foods != null) {
                    System.out.println("Comida encontrado!!");
                    System.out.println("Nome: " + foods.getName());
                    System.out.println("Preço atual: " + foods.getPrice());
                }else{
                    System.out.println("Comida não encontrada");
                }
                break;
            case 3:
                filePath = "Loja_De_Animais/files/Habitat/Habitat.dat";
                categoria = ProductType.HABITAT;
                System.out.println("Qual o nome do habitat:");
                String habitat = Ler.umaString();

                Product habitats =  findProduct(Main.products.get(ProductType.HABITAT), habitat );
                if (habitats != null){
                    System.out.println("Habitat encontrado!!");
                    System.out.println("Nome: " + habitats.getName());
                    System.out.println("Preço atual: " + habitats.getPrice());
                    return;
                }else{
                    System.out.println("Habitat não encontrado");
                }
                break;
            case 4:
                filePath = "Loja_De_Animais/files/Medicine/Medicine.dat";
                categoria = ProductType.MEDICINE;
                System.out.println("Qual o nome do medicamento:");
                String medicamento = Ler.umaString();

                Product medicines = findProduct(Main.products.get(ProductType.MEDICINE), medicamento );
                if (medicines != null){
                    System.out.println("Medicamento encontrado!!");
                    System.out.println("Nome: " + medicines.getName());
                    System.out.println("Preço atual: " + medicines.getPrice());
                }else{
                    System.out.println("Medicamento não encontrado");
                }
                break;
            case 5:
                System.out.println("A sair ...");
                return;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
    private static void deleteProduct() {
        System.out.println("Qual o tipo do produto:");
        System.out.println("1 - Cosmeticos");
        System.out.println("2 - Comida");
        System.out.println("3 - Habitat");
        System.out.println("4 - Medicamentos");
        System.out.println("5 - Voltar");

        String filePath = "";
        ProductType categoria = null;
        switch (Ler.umInt()) {
            case 1:
                categoria = ProductType.COSMETIC;
                System.out.println("Qual o nome do produto a eliminar:");
                String nome = Ler.umaString();
                ArrayList<Product> produtos = Main.products.get(categoria);
                Product pEliminar = findProduct(produtos, nome);

                if (pEliminar != null) {
                    produtos.remove(pEliminar);
                    File.binWrite(produtos, "Cosmetics/Cosmetics.dat");
                    System.out.println("Produto eliminado!");
                } else {
                    System.out.println("Produto não encontrado!");
                }
                break;
            case 2:
                categoria = ProductType.FOOD;
                System.out.println("Qual o nome do produto a eliminar:");
                String foods = Ler.umaString();
                ArrayList<Product> comidas = Main.products.get(categoria);
                Product comidaEliminar = findProduct(comidas, foods);

                if (comidaEliminar != null) {
                    comidas.remove(comidaEliminar);
                    File.binWrite(comidas, "Food/Food.dat");
                    System.out.println("Produto eliminado!");
                } else {
                    System.out.println("Produto não encontrado!");
                }
                break;
            case 3:
                categoria = ProductType.HABITAT;
                System.out.println("Qual o nome do produto a eliminar:");
                String habitat = Ler.umaString();
                ArrayList<Product> habitats = Main.products.get(categoria);
                Product habitatEliminar = findProduct(habitats, habitat);

                if (habitatEliminar != null) {
                    habitats.remove(habitatEliminar);
                    File.binWrite(habitats, "Habitat/Habitat.dat");
                    System.out.println("Produto eliminado!");
                } else {
                    System.out.println("Produto não encontrado!");
                }

                break;
            case 4:
                categoria = ProductType.MEDICINE;
                System.out.println("Qual o nome do produto a eliminar:");
                String medicamento = Ler.umaString();
                ArrayList<Product> medicamentos = Main.products.get(categoria);
                Product medicamentosEliminar = findProduct(medicamentos, medicamento);

                if (medicamentosEliminar != null) {
                    medicamentos.remove(medicamentosEliminar);
                    File.binWrite(medicamentos, "Medicine/Medicine.dat");
                    System.out.println("Produto eliminado!");
                } else {
                    System.out.println("Produto não encontrado!");
                }

                break;
            case 5:
                System.out.println("A sair ...");
                return;
            default:
                System.out.println("Opção inválida.");
                return;
            }


    }

    //Função para encontrar produto
    private static Product findProduct(ArrayList<Product> produtos, String nome) {
        for(Product p : produtos) {
            if (p.getName().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
    }
}
