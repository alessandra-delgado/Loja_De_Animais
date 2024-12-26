package src.ClassesMenu;

import java.util.ArrayList;

import src.ClassesLoja.Product;
import src.Enum.ProductType;
import src.ClassesLoja.File;
import src.Input.Ler;
import src.Main;

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
                    System.out.println("A sair ...");
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
                    double preco = Ler.umDouble();

                    //Cria produto
                    Product novoCosmetico = new Product(nome, preco);
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
                    System.out.println("Qual o preco do comida:");
                    double precoComida = Ler.umDouble();

                    Product comida = new Product(nomeComida, precoComida);
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
                    double precoHabitat = Ler.umDouble();

                    Product habitat = new Product(nomeHabitat, precoHabitat);
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
                    double precoHigiene = Ler.umDouble();

                    Product higiene = new Product(nomeHigiene, precoHigiene);
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
                    double precoMedicamento = Ler.umDouble();

                    Product medicamento = new Product(nomeMedicamento, precoMedicamento);
                    medicamento.setCategory(ProductType.MEDICINE);
                    Main.products.get(ProductType.MEDICINE).add(medicamento);
                    File.binWrite(Main.products.get(ProductType.MEDICINE), "Medicine/Medicine.dat");
                    File.binWriteInt(Product.getLast(), "Product/LastId.dat");
                    System.out.println("Medicamento registado!!");
                    return;
                case 6:
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
        System.out.println("4 - Higiene");
        System.out.println("5 - Medicamentos");
        System.out.println("6 - Sair");

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
                    System.out.println("O que quer atualizar:");
                    System.out.println("1 - Preço");
                    System.out.println("2 - Categoria");
                    System.out.println("3 - Sair");
                    while (true) {
                        switch (Ler.umInt()) {
                            case 1:
                                System.out.println("Qual o novo preço?");
                                cosmetics.setPrice(Ler.umDouble());

                                File.binWrite(Main.products.get(ProductType.COSMETIC), "Cosmetics/Cosmetics.dat");
                                System.out.println("Preço atualizado!!");
                                return;
                            case 2:
                                System.out.println("Para que categoria quer mudar:");
                                System.out.println("1 - Comida");
                                System.out.println("2 - Habitat");
                                System.out.println("3 - Higiene");
                                System.out.println("4 - Medicamentos");
                                System.out.println("5 - Sair");
                                ProductType novaCategoria = null;
                                while (true) {
                                    switch (Ler.umInt()) {
                                        case 1:
                                            novaCategoria = ProductType.FOOD;
                                            //remover o produto da categoria atual
                                            Main.products.get(categoria).remove(cosmetics);
                                            //adicionar o produto á nova categoria
                                            Main.products.get(novaCategoria).add(cosmetics);
                                            //atualizar ficheiros
                                            File.binWrite(Main.products.get(categoria), "Cosmetics/Cosmetics.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Food/Food.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 2:
                                            novaCategoria = ProductType.HABITAT;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(cosmetics);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(cosmetics);
                                            //atualiza os ficheiros
                                            File.binWrite(Main.products.get(categoria), "Cosmetics/Cosmetics.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Habitat/Habitat.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 3:
                                            novaCategoria = ProductType.HYGIENE;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(cosmetics);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(cosmetics);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Cosmetics/Cosmetics.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Hygiene/Hygiene.dat");
                                            return;
                                        case 4:
                                            novaCategoria = ProductType.MEDICINE;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(cosmetics);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(cosmetics);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Cosmetics/Cosmetics.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Medicine/Medicine.dat");
                                            return;
                                        case 5:
                                            System.out.println("A sair ...");
                                            return;
                                        default:
                                            System.out.println("Opção inválida.");
                                            break;

                                    }
                                }
                            case 3:
                                System.out.println("A sair...");
                                return;
                            default:
                                break;
                        }
                    }

                } else {
                    System.out.println("Cosmético não encontrado!");
                }
                break;
            case 2:
                categoria = ProductType.FOOD;
                System.out.println("Qual o nome da comida:");
                String comida = Ler.umaString();

                Product foods = findProduct(Main.products.get(ProductType.FOOD), comida);
                if (foods != null) {
                    System.out.println("Comida encontrado!!");
                    System.out.println("Nome: " + foods.getName());
                    System.out.println("Preço atual: " + foods.getPrice());
                    System.out.println("O que quer atualizar:");
                    System.out.println("1 - Preço");
                    System.out.println("2 - Categoria");
                    System.out.println("3 - Sair");
                    while (true) {
                        switch (Ler.umInt()) {
                            case 1:
                                System.out.println("Qual o novo preço?");
                                foods.setPrice(Ler.umDouble());

                                File.binWrite(Main.products.get(ProductType.FOOD), "Food/Food.dat");
                                System.out.println("Preço atualizado!!");
                                return;
                            case 2:
                                System.out.println("Para que categoria quer mudar:");
                                System.out.println("1 - Cosméticos");
                                System.out.println("2 - Habitat");
                                System.out.println("3 - Higiene");
                                System.out.println("4 - Medicamentos");
                                System.out.println("5 - Sair");
                                ProductType novaCategoria = null;
                                while (true) {
                                    switch (Ler.umInt()) {
                                        case 1:
                                            novaCategoria = ProductType.COSMETIC;
                                            //remover o produto da categoria atual
                                            Main.products.get(categoria).remove(foods);
                                            //adicionar o produto á nova categoria
                                            Main.products.get(novaCategoria).add(foods);
                                            //atualizar ficheiros
                                            File.binWrite(Main.products.get(categoria), "Food/Food.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Cosmetics/Cosmetics.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 2:
                                            novaCategoria = ProductType.HABITAT;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(foods);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(foods);
                                            //atualiza os ficheiros
                                            File.binWrite(Main.products.get(categoria), "Food/Food.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Habitat/Habitat.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 3:
                                            novaCategoria = ProductType.HYGIENE;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(foods);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(foods);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Food/Food.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Hygiene/Hygiene.dat");
                                            return;
                                        case 4:
                                            novaCategoria = ProductType.MEDICINE;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(foods);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(foods);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Food/Food.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Medicine/Medicine.dat");
                                            return;
                                        case 5:
                                            System.out.println("A sair ...");
                                            return;
                                        default:
                                            System.out.println("Opção inválida.");
                                            break;
                                    }
                                }
                            case 3:
                                System.out.println("A sair...");
                                return;
                            default:
                                break;
                        }
                    }
                } else {
                    System.out.println("Comida não encontrada!");
                }
                break;

            case 3:
                categoria = ProductType.HABITAT;
                System.out.println("Qual o nome do habitat:");
                String habitat = Ler.umaString();

                Product habitats = findProduct(Main.products.get(ProductType.HABITAT), habitat);
                if (habitats != null) {
                    System.out.println("Habitat encontrado!!");
                    System.out.println("Nome: " + habitats.getName());
                    System.out.println("Preço atual: " + habitats.getPrice());
                    System.out.println("O que quer atualizar:");
                    System.out.println("1 - Preço");
                    System.out.println("2 - Categoria");
                    System.out.println("3 - Sair");
                    while (true) {
                        switch (Ler.umInt()) {
                            case 1:
                                System.out.println("Qual o novo preço?");
                                habitats.setPrice(Ler.umDouble());

                                File.binWrite(Main.products.get(ProductType.HABITAT), "Habitat/Habitat.dat");
                                System.out.println("Preço atualizado!!");
                            case 2:
                                System.out.println("Para que categoria quer mudar:");
                                System.out.println("1 - Cosméticos");
                                System.out.println("2 - Comida");
                                System.out.println("3 - Higiene");
                                System.out.println("4 - Medicamentos");
                                System.out.println("5 - Sair");
                                ProductType novaCategoria = null;
                                while (true) {
                                    switch (Ler.umInt()) {
                                        case 1:
                                            novaCategoria = ProductType.COSMETIC;
                                            //remover o produto da categoria atual
                                            Main.products.get(categoria).remove(habitats);
                                            //adicionar o produto á nova categoria
                                            Main.products.get(novaCategoria).add(habitats);
                                            //atualizar ficheiros
                                            File.binWrite(Main.products.get(categoria), "Habitat/Habitat.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Cosmetics/Cosmetics.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 2:
                                            novaCategoria = ProductType.FOOD;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(habitats);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(habitats);
                                            //atualiza os ficheiros
                                            File.binWrite(Main.products.get(categoria), "Habitat/Habitat.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Food/Food.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 3:
                                            novaCategoria = ProductType.HYGIENE;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(habitats);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(habitats);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Habitat/Habitat.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Hygiene/Hygiene.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 4:
                                            novaCategoria = ProductType.MEDICINE;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(habitats);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(habitats);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Habitat/Habitat.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Medicine/Medicine.dat");
                                            return;
                                        case 5:
                                            System.out.println("A sair ...");
                                            return;
                                        default:
                                            System.out.println("Opção inválida.");
                                            break;
                                    }
                                }
                            case 3:
                                System.out.println("A sair...");
                                return;
                            default:
                                break;
                        }
                    }
                } else {
                    System.out.println("Habitat não encontrado!");
                }
                break;
            case 4:
                categoria = ProductType.HYGIENE;
                System.out.println("Qual o nome do produto de higiene:");
                String higiene = Ler.umaString();

                Product limpeza = findProduct(Main.products.get(ProductType.HYGIENE), higiene);
                if (limpeza != null) {
                    System.out.println("Produto de higiene encontrado!!");
                    System.out.println("Nome: " + limpeza.getName());
                    System.out.println("Preço atual: " + limpeza.getPrice());
                    System.out.println("O que quer atualizar:");
                    System.out.println("1 - Preço");
                    System.out.println("2 - Categoria");
                    System.out.println("3 - Sair");
                    while (true) {
                        switch (Ler.umInt()) {
                            case 1:
                                System.out.println("Qual o novo preço?");
                                limpeza.setPrice(Ler.umDouble());

                                File.binWrite(Main.products.get(ProductType.HYGIENE), "Hygiene/Hygiene.dat");
                                System.out.println("Preço atualizado!!");
                                return;
                            case 2:
                                System.out.println("Para que categoria quer mudar:");
                                System.out.println("1 - Cosméticos");
                                System.out.println("2 - Comida");
                                System.out.println("3 - Habitat");
                                System.out.println("4 - Medicamentos");
                                System.out.println("5 - Sair");
                                ProductType novaCategoria = null;
                                while (true) {
                                    switch (Ler.umInt()) {
                                        case 1:
                                            novaCategoria = ProductType.COSMETIC;
                                            //remover o produto da categoria atual
                                            Main.products.get(categoria).remove(limpeza);
                                            //adicionar o produto á nova categoria
                                            Main.products.get(novaCategoria).add(limpeza);
                                            //atualizar ficheiros
                                            File.binWrite(Main.products.get(categoria), "Hygiene/Hygiene.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Cosmetics/Cosmetics.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 2:
                                            novaCategoria = ProductType.FOOD;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(limpeza);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(limpeza);
                                            //atualiza os ficheiros
                                            File.binWrite(Main.products.get(categoria), "Hygiene/Hygiene.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Food/Food.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 3:
                                            novaCategoria = ProductType.HABITAT;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(limpeza);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(limpeza);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Hygiene/Hygiene.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Habitat/Habitat.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 4:
                                            novaCategoria = ProductType.MEDICINE;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(limpeza);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(limpeza);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Hygiene/Hygiene.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Medicine/Medicine.dat");
                                            return;
                                        case 5:
                                            System.out.println("A sair ...");
                                            return;
                                        default:
                                            System.out.println("Opção inválida.");
                                            break;
                                    }
                                }
                            case 3:
                                System.out.println("A sair...");
                                return;
                            default:
                                break;
                        }
                    }
                } else {
                    System.out.println("Produto de higiene não encontrado!");
                }
                break;
            case 5:
                categoria = ProductType.MEDICINE;
                System.out.println("Qual o nome do medicamento:");
                String medicamento = Ler.umaString();

                Product medicines = findProduct(Main.products.get(ProductType.MEDICINE), medicamento);
                if (medicines != null) {
                    System.out.println("Medicamento encontrado!!");
                    System.out.println("Nome: " + medicines.getName());
                    System.out.println("Preço atual: " + medicines.getPrice());
                    System.out.println("O que quer atualizar:");
                    System.out.println("1 - Preço");
                    System.out.println("2 - Categoria");
                    System.out.println("3 - Sair");
                    while (true) {
                        switch (Ler.umInt()) {
                            case 1:
                                System.out.println("Qual o novo preço?");
                                medicines.setPrice(Ler.umDouble());

                                File.binWrite(Main.products.get(ProductType.MEDICINE), "Medicine/Medicine.dat");
                                System.out.println("Preço atualizado!!");
                                return;
                            case 2:
                                System.out.println("Para que categoria quer mudar:");
                                System.out.println("1 - Cosméticos");
                                System.out.println("2 - Comida");
                                System.out.println("3 - Habitat");
                                System.out.println("4 - Higiene");
                                System.out.println("5 - Sair");
                                ProductType novaCategoria = null;
                                while (true) {
                                    switch (Ler.umInt()) {
                                        case 1:
                                            novaCategoria = ProductType.COSMETIC;
                                            //remover o produto da categoria atual
                                            Main.products.get(categoria).remove(medicines);
                                            //adicionar o produto á nova categoria
                                            Main.products.get(novaCategoria).add(medicines);
                                            //atualizar ficheiros
                                            File.binWrite(Main.products.get(categoria), "Medicine/Medicine.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Cosmetics/Cosmetics.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 2:
                                            novaCategoria = ProductType.FOOD;
                                            //remove o produto da categoria atual
                                            Main.products.get(categoria).remove(medicines);
                                            //adicionar o produto á nova categoria
                                            Main.products.get(novaCategoria).add(medicines);
                                            //atualizar ficheiros
                                            File.binWrite(Main.products.get(categoria), "Medicine/Medicine.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Food/Food.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 3:
                                            novaCategoria = ProductType.HABITAT;
                                            //remove o produto da categoria anterioe
                                            Main.products.get(categoria).remove(medicines);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(medicines);
                                            //atualiza os ficheiros
                                            File.binWrite(Main.products.get(categoria), "Medicine/Medicine.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Habitat/Habitat.dat");
                                            System.out.println("Categoria atualizada!!");
                                            return;
                                        case 4:
                                            novaCategoria = ProductType.HYGIENE;
                                            //remove o produto da categoria anterior
                                            Main.products.get(categoria).remove(medicines);
                                            //adiciona o produto á nova categoria
                                            Main.products.get(novaCategoria).add(medicines);
                                            //atualiza ficheiros
                                            File.binWrite(Main.products.get(categoria), "Medicine/Medicine.dat");
                                            File.binWrite(Main.products.get(novaCategoria), "Hygiene/Hygiene.dat");
                                            return;
                                        case 5:
                                            System.out.println("A sair ...");
                                            return;
                                        default:
                                            System.out.println("Opção inválida.");
                                            break;
                                    }
                                }
                            case 3:
                                System.out.println("A sair...");
                                return;
                            default:
                                break;
                        }
                    }
                } else {
                    System.out.println("Medicamento não encontrado!");
                }
                break;
            case 6:
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
        System.out.println("4 - Higiene");
        System.out.println("5 - Medicamentos");
        System.out.println("6 - Voltar");

        switch (Ler.umInt()) {
            case 1:
                System.out.println("Qual o nome do cosmético:");
                String cosmetico = Ler.umaString();

                Product cosmetics = findProduct(Main.products.get(ProductType.COSMETIC), cosmetico);
                if (cosmetics != null) {
                    System.out.println("Cosmético encontrado!!");
                    System.out.println("Nome: " + cosmetics.getName());
                    System.out.println("Preço atual: " + cosmetics.getPrice());
                } else {
                    System.out.println("Cosmético não encontrado");
                }
                return;
            case 2:
                System.out.println("Qual o nome da comida:");
                String comida = Ler.umaString();

                Product foods = findProduct(Main.products.get(ProductType.FOOD), comida);
                if (foods != null) {
                    System.out.println("Comida encontrado!!");
                    System.out.println("Nome: " + foods.getName());
                    System.out.println("Preço atual: " + foods.getPrice());
                } else {
                    System.out.println("Comida não encontrada");
                }
                return;
            case 3:
                System.out.println("Qual o nome do habitat:");
                String habitat = Ler.umaString();

                Product habitats = findProduct(Main.products.get(ProductType.HABITAT), habitat);
                if (habitats != null) {
                    System.out.println("Habitat encontrado!!");
                    System.out.println("Nome: " + habitats.getName());
                    System.out.println("Preço atual: " + habitats.getPrice());
                } else {
                    System.out.println("Habitat não encontrado");
                }
                return;
            case 4:
                System.out.println("Qual o nome do produto de hygiene:");
                String hygiene = Ler.umaString();

                Product limpeza = findProduct(Main.products.get(ProductType.HYGIENE), hygiene);
                if (limpeza != null) {
                    System.out.println("Hygiene encontrado!!");
                    System.out.println("Nome: " + limpeza.getName());
                    System.out.println("Preço atual: " + limpeza.getPrice());
                } else {
                    System.out.println("Produto de higiene não encontrado");
                }
                return;
            case 5:
                System.out.println("Qual o nome do medicamento:");
                String medicamento = Ler.umaString();

                Product medicines = findProduct(Main.products.get(ProductType.MEDICINE), medicamento);
                if (medicines != null) {
                    System.out.println("Medicamento encontrado!!");
                    System.out.println("Nome: " + medicines.getName());
                    System.out.println("Preço atual: " + medicines.getPrice());
                } else {
                    System.out.println("Medicamento não encontrado");
                }
                break;
            case 6:
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
        System.out.println("4 - Hygiene");
        System.out.println("5 - Medicamentos");
        System.out.println("6 - Voltar");

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
                return;
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
                return;
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
                return;
            case 4:
                categoria = ProductType.HYGIENE;
                System.out.println("Qual o nome do produto a eliminar:");
                String hygiene = Ler.umaString();
                ArrayList<Product> limpeza = Main.products.get(categoria);
                Product limpezaEliminar = findProduct(limpeza, hygiene);

                if (limpezaEliminar != null) {
                    limpeza.remove(limpezaEliminar);
                    File.binWrite(limpeza, "Hygiene/Hygiene.dat");
                    System.out.println("Produto eliminado!");
                } else {
                    System.out.println("Produto não encontrado!");
                }
                return;
            case 5:
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
                return;
            case 6:
                System.out.println("A sair ...");
                return;
            default:
                System.out.println("Opção inválida.");
                return;
        }


    }

    //Função para encontrar produto
    private static Product findProduct(ArrayList<Product> produtos, String nome) {
        for (Product p : produtos) {
            if (p.getName().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}
