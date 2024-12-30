package src.ClassesMenu;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import src.ClassesLoja.Product;
import src.Enum.ProductType;
import src.ClassesLoja.File;
import src.Exceptions.ProductNotFoundException;
import src.FormValidation.Form;
import src.Input.Ler;
import src.Main;

public class ProductMenu {
    private static String filePath;

    private static void menu() {
        System.out.println("╭─────────────────────────╮");
        System.out.println("│ 1 - Adicionar Produtos  │");
        System.out.println("│ 2 - Atualizar Produtos  │");
        System.out.println("│ 3 - Visualizar Produtos │");
        System.out.println("│ 4 - Eliminar Produtos   │");
        System.out.println("│ 5 - Voltar              │");
        System.out.println("╰─────────────────────────╯");
        System.out.print("Escolha uma opção: ");
    }

    public static void show() {
        while (true) {
            ProductMenu.menu();
            switch (Ler.umInt()) {
                case 1:
                    addProduct();
                    return;
                case 2:
                    updateProduct();
                    return;
                case 3:
                    viewProduct();
                    return;
                case 4:
                    deleteProduct();
                    return;
                case 5:
                    System.out.println("A voltar ...");
                    return;
                default:
                    break;
            }
        }
    }

    private static void addProduct() {
        System.out.println("Que tipo de produto:");
        System.out.println("1 - Cosmeticos");
        System.out.println("2 - Comida");
        System.out.println("3 - Habitat");
        System.out.println("4 - Higiene");
        System.out.println("5 - Medicamentos");
        System.out.println("6 - Voltar");

        while (true) {
            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Qual o nome do cosmetico:");
                    String nome = Ler.umaString();
                    System.out.println("Qual o preco do cosmetico:");
                    double preco = Form.insertPrice();
                    System.out.println("Qual a quantidade do cosmetico?");
                    int quantidade = Form.insertQuantity();

                    //Cria produto
                    Product novoCosmetico = new Product(nome, preco, quantidade);
                    //Adiciona á lista de cosméticos
                    novoCosmetico.setCategory(ProductType.COSMETIC);
                    Main.products.get(ProductType.COSMETIC).add(novoCosmetico);
                    File.binWrite(Main.products.get(ProductType.COSMETIC), "Cosmetics/Cosmetics.dat");
                    File.binWriteInt(Product.getLast(), "Product/LastId.dat");
                    System.out.println("Cosmético registado!!");
                    return;
                case 2:
                    System.out.println("Qual o nome da comida:");
                    String nomeComida = Ler.umaString();
                    System.out.println("Qual o preco da comida:");
                    double precoComida = Form.insertPrice();
                    System.out.println("Qual a quantidade da comida?");
                    int quantidadeComida = Form.insertQuantity();

                    Product comida = new Product(nomeComida, precoComida, quantidadeComida);
                    comida.setCategory(ProductType.FOOD);
                    Main.products.get(ProductType.FOOD).add(comida);
                    File.binWrite(Main.products.get(ProductType.FOOD), "Food/Food.dat");
                    File.binWriteInt(Product.getLast(), "Product/LastId.dat");
                    System.out.println("Comida registada!!");
                    return;
                case 3:
                    System.out.println("Qual o nome do habitat:");
                    String nomeHabitat = Ler.umaString();
                    System.out.println("Qual o preco do habitat:");
                    double precoHabitat = Form.insertPrice();
                    System.out.println("Qual a quantidade do habitat?");
                    int quantidadeHabitat = Form.insertQuantity();

                    Product habitat = new Product(nomeHabitat, precoHabitat, quantidadeHabitat);
                    habitat.setCategory(ProductType.HABITAT);
                    Main.products.get(ProductType.HABITAT).add(habitat);
                    File.binWrite(Main.products.get(ProductType.HABITAT), "Habitat/Habitat.dat");
                    File.binWriteInt(Product.getLast(), "Product/LastId.dat");
                    System.out.println("Habitat registado!!");
                    return;
                case 4:
                    System.out.println("Qual o nome do produto de higiene:");
                    String nomeHigiene = Ler.umaString();
                    System.out.println("Qual o preco do produto de higiene:");
                    double precoHigiene = Form.insertPrice();
                    System.out.println("Qual a quantidade do produto de higiene?");
                    int quantidadeHigiene = Form.insertQuantity();

                    Product higiene = new Product(nomeHigiene, precoHigiene, quantidadeHigiene);
                    higiene.setCategory(ProductType.HYGIENE);
                    Main.products.get(ProductType.HYGIENE).add(higiene);
                    File.binWrite(Main.products.get(ProductType.HYGIENE), "Hygiene/Hygiene.dat");
                    File.binWriteInt(Product.getLast(), "Product/LastId.dat");
                    System.out.println("Produto de higiene registado!!");
                    return;
                case 5:
                    System.out.println("Qual o nome do medicamento:");
                    String nomeMedicamento = Ler.umaString();
                    System.out.println("Qual o preco do medicamento:");
                    double precoMedicamento = Form.insertPrice();
                    System.out.println("Qual a quantidade do medicamento?");
                    int quantidadeMedicamento = Form.insertQuantity();

                    Product medicamento = new Product(nomeMedicamento, precoMedicamento, quantidadeMedicamento);
                    medicamento.setCategory(ProductType.MEDICINE);
                    Main.products.get(ProductType.MEDICINE).add(medicamento);
                    File.binWrite(Main.products.get(ProductType.MEDICINE), "Medicine/Medicine.dat");
                    File.binWriteInt(Product.getLast(), "Product/LastId.dat");
                    System.out.println("Medicamento registado!!");
                    return;
                case 6:
                    System.out.println("A voltar ...");
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
        System.out.println("4 - Higiene");
        System.out.println("5 - Medicamentos");
        System.out.println("6 - Voltar");

        ProductType categoria = getProductByCategory(Ler.umInt());
        if (categoria == null) {
            return;
        }
        System.out.println("Qual o nome do produto:");
        String nome = Ler.umaString();

        Product produto = findProduct(Main.products.get(categoria), nome);
        if (produto != null) {
            System.out.println("Produto encontrado!");
            System.out.println("Nome: " + produto.getName());
            System.out.println("Preço atual: " + produto.getPrice());
            System.out.println("O que quer atualizar:");
            System.out.println("1 - Preço");
            System.out.println("2 - Categoria");
            System.out.println("3 - Quantidade");
            System.out.println("4 - Voltar");


            while (true) {
                switch (Ler.umInt()) {
                    case 1:
                        updatePrice(produto, categoria);
                        return;
                    case 2:
                        updateCategory(produto, categoria);
                        return;
                    case 3:
                        updateQuantity(produto, categoria);
                        return;
                    case 4:
                        System.out.println("A voltar ...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        } else {
            System.out.println("Produto não encontrado! ");
        }
    }

    private static void viewProduct() {
        System.out.println("Qual o tipo do produto:");
        System.out.println("1 - Cosmeticos");
        System.out.println("2 - Comida");
        System.out.println("3 - Habitat");
        System.out.println("4 - Higiene");
        System.out.println("5 - Medicamentos");
        System.out.println("6 - Voltar");

        switch (Ler.umInt()) {
            case 1:
                viewProdructDetails(ProductType.COSMETIC);
                return;
            case 2:
                viewProdructDetails(ProductType.FOOD);
                return;
            case 3:
                viewProdructDetails(ProductType.HABITAT);
                return;
            case 4:
                viewProdructDetails(ProductType.HYGIENE);
                return;
            case 5:
                viewProdructDetails(ProductType.MEDICINE);
                return;
            case 6:
                System.out.println("A voltar ...");
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
        System.out.println("4 - Hygiene");
        System.out.println("5 - Medicamentos");
        System.out.println("6 - Voltar");

        switch (Ler.umInt()) {
            case 1:
                deleteProductDetails(ProductType.COSMETIC);
                return;
            case 2:
                deleteProductDetails(ProductType.FOOD);
                return;
            case 3:
                deleteProductDetails(ProductType.HABITAT);
                return;
            case 4:
                deleteProductDetails(ProductType.HYGIENE);
                return;
            case 5:
                deleteProductDetails(ProductType.MEDICINE);
                return;
            case 6:
                System.out.println("A voltar ...");
                return;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static ProductType getProductByCategory(int op) {
        switch (op) {
            case 1:
                return ProductType.COSMETIC;
            case 2:
                return ProductType.FOOD;
            case 3:
                return ProductType.HABITAT;
            case 4:
                return ProductType.HYGIENE;
            case 5:
                return ProductType.MEDICINE;
            case 6:
                System.out.println("A voltar ...");
                return null;
            default:
                System.out.println("Opção inválida");
                return null;

        }
    }

    //Função atualizar preço
    private static void updatePrice(Product product, ProductType categoria) {
        System.out.println("Qual o novo preço?");
        product.setPrice(Form.insertPrice());
        File.binWrite(Main.products.get(categoria), categoria.getFilePath());
        System.out.println("Preço atualizado!");
    }

    private static void updateCategory(Product product, ProductType categoria) {
        System.out.println("Para que categoria quer mudar?");
        System.out.println("1 - Cosméticos");
        System.out.println("2 - Comida");
        System.out.println("3 - Habitat");
        System.out.println("4 - Higiene");
        System.out.println("5 - Medicamentos");
        System.out.println("6 - Voltar");

        ProductType novaCategoria = getProductByCategory(Ler.umInt());

        if (novaCategoria != null && novaCategoria != categoria) {
            product.setCategory(novaCategoria);
            //remover da antiga e adicionar na nova
            Main.products.get(categoria).remove(product);
            Main.products.get(novaCategoria).add(product);
            //atualizar ficheiros
            File.binWrite(Main.products.get(categoria), categoria.getFilePath());
            File.binWrite(Main.products.get(novaCategoria), novaCategoria.getFilePath());
            System.out.println("Categoria atualizada!");
        } else {
            System.out.println("Categoria inválida");
        }
    }

    private static void updateQuantity(Product product, ProductType categoria) {
        System.out.println("Qual a nova quantidade?");
        int quantidade = Form.insertQuantity();
        product.setQuantity(quantidade);
        File.binWrite(Main.products.get(categoria), categoria.getFilePath());
        System.out.println("Quantidade atualizada!");
    }

    //Função para ver os detalhes dos produtos
    private static void viewProdructDetails(ProductType categoria) {
        System.out.println("Qual o nome do produto?");
        String nome = Ler.umaString();
        ArrayList<Product> produtos = Main.products.get(categoria);
        Product produto = findProduct(produtos, nome);

        if (produto != null) {
            System.out.println(categoria.toString() + " encontrado!");
            System.out.println("Nome: " + produto.getName());
            System.out.println("Quantidade: " + produto.getQuantity());
            System.out.println("Preço atual: " + produto.getPrice());
        } else {
            System.out.println(categoria.toString() + " não encontrado!");
        }
    }

    //Função para Eliminar os produtos
    private static void deleteProductDetails(ProductType categoria) {
        System.out.println("Qual o nome do produto?");
        String nome = Ler.umaString();
        ArrayList<Product> produtos = Main.products.get(categoria);
        Product produto = findProduct(produtos, nome);
        if (produto != null) {
            produtos.remove(produto);
            File.binWrite(produtos, categoria.getFilePath());
            System.out.println(categoria.toString() + " eliminado!");
        } else {
            System.out.println(categoria.toString() + " não encontrado!");
        }
    }

    //Função para encontrar produto
    private static Product findProduct(ArrayList<Product> produtos, String nome) {
        for (Product p : produtos) {
            if (p.getName().toLowerCase().contains(nome.toLowerCase())) {
                return p;
            }
        }
        return null;
    }

    public static Product findProductById(int id) throws ProductNotFoundException {
        AtomicReference<Product> selected = new AtomicReference<>();

        Main.products.forEach((_, products) -> {
            for (Product p : products) {
                if (p.getId() == id) {
                    selected.set(p);
                    break;
                }
            }
        });


        if (selected.get() != null) {
            return selected.get();
        }

        throw new ProductNotFoundException("Erro: Não existe nenhum produto com o id introduzido");
    }


}