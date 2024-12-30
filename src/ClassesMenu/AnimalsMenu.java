package src.ClassesMenu;


import src.ClassesLoja.*;
import src.Enum.AnimalType;
import src.Enum.ProductType;
import src.FormValidation.Form;
import src.Input.Ler;
import src.Main;

import java.util.ArrayList;

public class AnimalsMenu {
    private static AnimalType categoria;
    private static boolean real;

    public static void menu() {
        System.out.println("1 - Adicionar Animal");
        System.out.println("2 - Atualizar Animal");
        System.out.println("3 - Visualizar Animal");
        System.out.println("4 - Listar Animais");
        System.out.println("5 - Eliminar Animal");
        System.out.println("6 - Voltar");
    }

    public static void show() {
        while (true) {
            AnimalsMenu.menu();
            switch (Ler.umInt()) {
                case 1:
                    addAnimal();
                    return;
                case 2:
                    updateAnimal();
                    return;
                case 3:
                    showAnimal();
                    return;
                case 4:
                    showAllAnimals();
                    return;
                case 5:
                    deleteAnimal();
                    return;
                case 6:
                    System.out.println("A voltar ...");
                    return;
                default:
                    break;
            }
        }
    }

    private static void showAllAnimals() {
        System.out.println("\nAnimais Reais Aerios: ");
        Main.listProducts(ProductType.ANIMAL_REAL_AERIAL);

        System.out.println("\nAnimais Reais Aquáticos: ");
        Main.listProducts(ProductType.ANIMAL_REAL_AQUATIC);

        System.out.println("\nAnimais Reais Terrestres: ");
        Main.listProducts(ProductType.ANIMAL_REAL_LAND);

        System.out.println("\nAnimais Imaginários Aerios: ");
        Main.listProducts(ProductType.ANIMAL_IMAGINARY_AERIAL);

        System.out.println("\nAnimais Imaginários Aquáticos: ");
        Main.listProducts(ProductType.ANIMAL_IMAGINARY_AQUATIC);

        System.out.println("\nAnimais Imaginários Terrestres: ");
        Main.listProducts(ProductType.ANIMAL_IMAGINARY_LAND);
    }

    public static void addAnimal() {
        AnimalType tipoAnimal = getAnimalType();

        if (tipoAnimal == null) {
            return;
        }

        System.out.println("Qual o nome de animal?");
        String nome = Ler.umaString();
        System.out.println("Qual o preço do animal?");
        double preco = Form.insertPrice();
        System.out.println("Qual a idade do animal?");
        int idade = Form.insertAge();
        System.out.println("Qual a quantidade do animal?");
        int quantidade = Form.insertQuantity();
        System.out.println("Qual o género do animal(F/M)?");
        char genero = Form.insertGender();
        System.out.println("Qual o nome cientifico do animal?");
        String nomeCientifico = Ler.umaString();
        System.out.println("Insira a arte ASCII do animal?");
        String arte = Ler.umaString();

        Animal novoAnimal = new Animal(idade, genero, nomeCientifico, arte, tipoAnimal);
        novoAnimal.setName(nome);
        novoAnimal.setPrice(preco);
        novoAnimal.setQuantity(quantidade);

        System.out.println("O animal é: ");
        System.out.println("1 - Real");
        System.out.println("2 - Imaginário");

        if (Ler.umInt() == 1) {
            //animal real
            if (tipoAnimal == AnimalType.LAND) {
                novoAnimal.setCategory(ProductType.ANIMAL_REAL_LAND);
                Main.products.get(ProductType.ANIMAL_REAL_LAND).add(novoAnimal);
                File.binWrite(Main.products.get(ProductType.ANIMAL_REAL_LAND), "Animal/Real/Land.dat");
            } else if (tipoAnimal == AnimalType.AERIAL) {
                novoAnimal.setCategory(ProductType.ANIMAL_REAL_AERIAL);
                Main.products.get(ProductType.ANIMAL_REAL_AERIAL).add(novoAnimal);
                File.binWrite(Main.products.get(ProductType.ANIMAL_REAL_AERIAL), "Animal/Real/Aerial.dat");
            } else if (tipoAnimal == AnimalType.AQUATIC) {
                novoAnimal.setCategory(ProductType.ANIMAL_REAL_AQUATIC);
                Main.products.get(ProductType.ANIMAL_REAL_AQUATIC).add(novoAnimal);
                File.binWrite(Main.products.get(ProductType.ANIMAL_REAL_AQUATIC), "Animal/Real/Aquatic.dat");
            }
        } else {
            //animal imaginário
            if (tipoAnimal == AnimalType.LAND) {
                novoAnimal.setCategory(ProductType.ANIMAL_IMAGINARY_LAND);
                Main.products.get(ProductType.ANIMAL_IMAGINARY_LAND).add(novoAnimal);
                File.binWrite(Main.products.get(ProductType.ANIMAL_IMAGINARY_LAND), "Animal/Imaginary/Land.dat");
            } else if (tipoAnimal == AnimalType.AERIAL) {
                novoAnimal.setCategory(ProductType.ANIMAL_IMAGINARY_AERIAL);
                Main.products.get(ProductType.ANIMAL_IMAGINARY_AERIAL).add(novoAnimal);
                File.binWrite(Main.products.get(ProductType.ANIMAL_IMAGINARY_AERIAL), "Animal/Imaginary/Aerial.dat");
            } else if (tipoAnimal == AnimalType.AQUATIC) {
                novoAnimal.setCategory(ProductType.ANIMAL_IMAGINARY_AQUATIC);
                Main.products.get(ProductType.ANIMAL_IMAGINARY_AQUATIC).add(novoAnimal);
                File.binWrite(Main.products.get(ProductType.ANIMAL_IMAGINARY_AQUATIC), "Animal/Imaginary/Aquatic.dat");
            }
        }

        File.binWriteInt(Product.getLast(), "Product/LastId.dat");
        System.out.println("Animal registado!!");
    }


    private static AnimalType getAnimalType() {
        while (true) {
            System.out.println("Qual o tipo de animal?");
            System.out.println("1 - Terrestre");
            System.out.println("2 - Aéreo");
            System.out.println("3 - Aquático");
            System.out.println("4 - Cancelar");
            System.out.println("Insira uma opção: ");

            switch (Ler.umInt()) {
                case 1:
                    return AnimalType.LAND;
                case 2:
                    return AnimalType.AERIAL;
                case 3:
                    return AnimalType.AQUATIC;
                case 4:
                    System.out.println("A voltar ...");
                    return null;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void updateAnimal() {
        animalType();
        System.out.println("Qual o nome do animal?");
        String nome = Ler.umaString();

        ArrayList<Animal> animais = getAnimalbyType(categoria, real);
        Animal animal = findAnimal(animais, nome);

        if (animal != null) {
            System.out.println("Animal encontrado!");
            System.out.println("Nome: " + animal.getName());
            System.out.println("Idade: " + animal.getAge());
            System.out.println("Sexo: " + animal.getGender());
            System.out.println("Nome científico: " + animal.getSciname());
            System.out.println("Tipo: " + animal.getType());


            while (true) {
                System.out.println("O que quer atualizar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Idade");
                System.out.println("3 - Sexo");
                System.out.println("4 - Nome científico");
                System.out.println("5 - Tipo");
                System.out.println("6 - Quantidade");
                System.out.println("7 - Voltar");

                switch (Ler.umInt()) {
                    case 1:
                        System.out.println("Qual o novo nome?");
                        animal.setName(Ler.umaString());
                        break;
                    case 2:
                        System.out.println("Qual a nova idade?");
                        animal.setAge(Form.insertAge());
                        break;
                    case 3:
                        System.out.println("Qual o novo sexo?");
                        animal.setGender(Form.insertGender());
                        break;
                    case 4:
                        System.out.println("Qual o novo nome cientifico?");
                        animal.setSciname(Ler.umaString());
                        break;
                    case 5:
                        System.out.println("Qual o novo tipo?");
                        System.out.println("1 - Aéreo");
                        System.out.println("2 - Aquático");
                        System.out.println("3 - Terrestre");
                        AnimalType novoTipo = null;
                        ProductType novaCategoria = null;
                        switch (Ler.umInt()) {
                            case 1:
                                novoTipo = AnimalType.AERIAL;
                                novaCategoria = animal.getCategory().isAnimalReal() ? ProductType.ANIMAL_REAL_AERIAL : ProductType.ANIMAL_IMAGINARY_AERIAL;
                                break;
                            case 2:
                                novoTipo = AnimalType.AQUATIC;
                                novaCategoria = animal.getCategory().isAnimalReal() ? ProductType.ANIMAL_REAL_AQUATIC : ProductType.ANIMAL_IMAGINARY_AQUATIC;
                                break;
                            case 3:
                                novoTipo = AnimalType.LAND;
                                novaCategoria = animal.getCategory().isAnimalReal() ? ProductType.ANIMAL_REAL_LAND : ProductType.ANIMAL_IMAGINARY_LAND;

                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                        Main.products.get(animal.getCategory()).remove(animal);
                        updateFileByType(real, animal.getType());
                        animal.setType(novoTipo);
                        animal.setCategory(novaCategoria);
                        Main.products.get(animal.getCategory()).add(animal);
                        categoria = novoTipo;
                        break;
                    case 6:
                        System.out.println("Qual a nova quantidade?");
                        animal.setQuantity(Form.insertQuantity());
                        break;
                    case 7:
                        System.out.println("A voltar...");
                        return;
                    default:
                        System.out.print("Opção inválida");
                        break;
                }

                //Gravar lista
                updateFileByType(real, categoria);
                System.out.println("Animal atualizado!");
                return;
            }
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    public static void showAnimal() {
        animalType();

        System.out.println("Qual o nome do animal?");
        String nome = Ler.umaString();

        ArrayList<Animal> animais = getAnimalbyType(categoria, real);

        Animal animal = findAnimal(animais, nome);

        if (animal != null) {
            System.out.println("Animal encontrado!");
            System.out.println("Nome: " + animal.getName());
            System.out.println("Idade: " + animal.getAge());
            System.out.println("Sexo: " + animal.getGender());
            System.out.println("Tipo: " + animal.getType());
            System.out.println("Quantidade: " + animal.getQuantity());
            System.out.println("Nome cientifico: " + animal.getSciname());

            //verifica se a arte ASCII está disponivel
            animal.viewAnimal();
        } else {
            System.out.println("Animal não encontrado!");
        }

    }

    public static void deleteAnimal() {
        animalType();
        System.out.println("Qual o nome do animal?");
        String nome = Ler.umaString();
        ArrayList<Animal> animais = getAnimalbyType(categoria, real);
        Animal animal = findAnimal(animais, nome);

        if (animal != null && animal.getCategory() != ProductType.NONE) {
            Main.products.get(animal.getCategory()).remove(animal);

            System.out.println("Animal removido!");
            updateFileByType(real, categoria);
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    private static void animalType() {
        System.out.println("Qual o tipo de animal?");
        System.out.println("1 - Real Terrestre");
        System.out.println("2 - Real Aéreo");
        System.out.println("3 - Real Aquatico");
        System.out.println("4 - Imaginário Terrestre");
        System.out.println("5 - Imaginário Aéreo");
        System.out.println("6 - Imaginário Aquatico");
        System.out.println("7 - Voltar");

        switch (Ler.umInt()) {
            case 1:
                categoria = AnimalType.LAND;
                real = true;
                break;
            case 2:
                categoria = AnimalType.AERIAL;
                real = true;
                break;
            case 3:
                categoria = AnimalType.AQUATIC;
                real = true;
                break;
            case 4:
                categoria = AnimalType.LAND;
                real = false;
                break;
            case 5:
                categoria = AnimalType.AERIAL;
                real = false;
                break;
            case 6:
                categoria = AnimalType.AQUATIC;
                real = false;
                break;
            case 7:
                System.out.println("A voltar ...");
                return;
            default:
                System.out.print("Opção inválida");
                break;
        }
    }

    private static ArrayList<Animal> getAnimalbyType(AnimalType tipo, boolean real) {
        ArrayList<Product> produtos;

        if (real) {
            produtos = switch (tipo) {
                case AERIAL -> Main.products.get(ProductType.ANIMAL_REAL_AERIAL);
                case AQUATIC -> Main.products.get(ProductType.ANIMAL_REAL_AQUATIC);
                case LAND -> Main.products.get(ProductType.ANIMAL_REAL_LAND);
            };
        } else {
            produtos = switch (tipo) {
                case AERIAL -> Main.products.get(ProductType.ANIMAL_IMAGINARY_AERIAL);
                case AQUATIC -> Main.products.get(ProductType.ANIMAL_IMAGINARY_AQUATIC);
                case LAND -> Main.products.get(ProductType.ANIMAL_IMAGINARY_LAND);
            };
        }

        ArrayList<Animal> animais = new ArrayList<>();

        for (Product produto : produtos) {
            if (produto instanceof Animal) {
                animais.add((Animal) produto);
            }
        }

        return animais;
    }

    //procurar animal pelo nome
    private static Animal findAnimal(ArrayList<Animal> animais, String nome) {
        for (Animal animal : animais) {
            if (animal.getName().toLowerCase().contains(nome.toLowerCase())) {
                return animal;
            }
        }
        return null;
    }

    private static void updateFileByType(boolean real, AnimalType tipo) {
        if (real) {
            switch (tipo) {
                case AERIAL:
                    File.binWrite(Main.products.get(ProductType.ANIMAL_REAL_AERIAL), "Animal/Real/Aerial.dat");
                    break;
                case AQUATIC:
                    File.binWrite(Main.products.get(ProductType.ANIMAL_REAL_AQUATIC), "Animal/Real/Aquatic.dat");
                    break;
                case LAND:
                    File.binWrite(Main.products.get(ProductType.ANIMAL_REAL_LAND), "Animal/Real/Land.dat");
                    break;
            }
        } else {
            switch (tipo) {
                case AERIAL:
                    File.binWrite(Main.products.get(ProductType.ANIMAL_IMAGINARY_AERIAL), "Animal/Imaginary/Aerial.dat");
                    break;
                case AQUATIC:
                    File.binWrite(Main.products.get(ProductType.ANIMAL_IMAGINARY_AQUATIC), "Animal/Imaginary/Aquatic.dat");
                    break;
                case LAND:
                    File.binWrite(Main.products.get(ProductType.ANIMAL_IMAGINARY_LAND), "Animal/Imaginary/Land.dat");
                    break;
            }
        }
    }
}