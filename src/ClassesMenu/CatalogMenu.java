package src.ClassesMenu;

import src.Enum.ProductType;
import src.Input.Ler;
import src.Main;

import java.lang.Math;
import java.util.ArrayList;

public class CatalogMenu {
    private static void menu() {
        System.out.println("1 - Animais Reais");
        System.out.println("2 - Animais Imaginários");
        System.out.println("3 - Cosmeticos");
        System.out.println("4 - Comida");
        System.out.println("5 - Habitat");
        System.out.println("6 - Medicamentos");
        System.out.println("7 - Higiene");
        System.out.println("? - ?");
        System.out.println("8 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void show() {
        do {
            CatalogMenu.menu();

            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Animais Reais");
                    CatalogMenu.submenuAnimals(true);
                    break;
                case 2:
                    System.out.println("Animais Imaginários");
                    CatalogMenu.submenuAnimals(false);
                    break;
                case 3:
                    System.out.println("Cosmeticos");
                    Main.listProducts(ProductType.COSMETIC);
                    break;
                case 4:
                    System.out.println("Comida");
                    Main.listProducts(ProductType.FOOD);
                    break;
                case 5:
                    System.out.println("Habitat");
                    Main.listProducts(ProductType.HABITAT);
                    break;
                case 6:
                    System.out.println("Medicamentos");
                    Main.listProducts(ProductType.MEDICINE);
                    break;
                case 7:
                    System.out.println("Higiene");
                    Main.listProducts(ProductType.HYGIENE);
                    break;
                case 8:
                    System.out.println("Voltar");
                    return;
                case 42:
                    secret();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (true);
    }

    private static void submenuAnimals(boolean areAnimalsReal) {
        ProductType aerialType = areAnimalsReal ? ProductType.ANIMAL_REAL_AERIAL : ProductType.ANIMAL_IMAGINARY_AERIAL;
        ProductType landType = areAnimalsReal ? ProductType.ANIMAL_REAL_LAND : ProductType.ANIMAL_IMAGINARY_LAND;
        ProductType aquaticType = areAnimalsReal ? ProductType.ANIMAL_REAL_AQUATIC : ProductType.ANIMAL_IMAGINARY_AQUATIC;

        do {
            System.out.println("1 - Aéreos");
            System.out.println("2 - Terrestres");
            System.out.println("3 - Aquáticos");
            System.out.println("4 - Todos");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");

            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Aéreos");
                    Main.listProducts(aerialType);
                    break;
                case 2:
                    System.out.println("Terrestres");
                    Main.listProducts(landType);
                    break;
                case 3:
                    System.out.println("Aquáticos");
                    Main.listProducts(aquaticType);
                    break;
                case 4:
                    System.out.println("Todos");
                    Main.listProducts(aerialType);
                    Main.listProducts(landType);
                    Main.listProducts(aquaticType);
                    break;
                case 5:
                    System.out.println("Voltar");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (true);
    }

    public static void secret() {
        ArrayList<String> asciiart = new ArrayList<String>();
        asciiart.add(
                        "                __\n" +
                        "             .-'  |\n" +
                        "            /   <\\|\n" +
                        "           /     \\'\n" +
                        "           |_.- o-o\n" +
                        "           / C  -._)\\\n" +
                        "          /',        |\n" +
                        "         |   `-,_,__,'\n" +
                        "         (,,)====[_]=|\n" +
                        "           '.   ____/\n" +
                        "            | -|-|_\n" +
                        "            |____)_) "
        );
        asciiart.add(
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⠟⠀⣀⣠⠄⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢠⣶⣿⠟⠁⢠⣾⠋⠁⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠹⣿⡇⠀⠀⠸⣿⡄⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠙⠷⡀⠀⠀⢹⠗⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⢀⣤⣴⡖⠒⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠒⢶⣄\n" +
                        "⠀⠀⠈⠙⢛⣻⠿⠿⠿⠟⠛⠛⠛⠋⠉⠀⠀⠀⣸⡿\n" +
                        "⠀⠀⠀⠀⠛⠿⣷⣶⣶⣶⣶⣾⠿⠗⠂⠀⢀⠴⠛⠁\n" +
                        "⠀⠀⠀⠀⠀⢰⣿⣦⣤⣤⣤⣴⣶⣶⠄⠀⠀⠀⠀⠀\n" +
                        "⣀⣤⡤⠄⠀⠀⠈⠉⠉⠉⠉⠉⠀⠀⠀⠀⢀⡀⠀⠀\n" +
                        "⠻⣿⣦⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣠⣴⠾⠃⠀⢀\n" +
                        "⠀⠀⠈⠉⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠁⠀⣀⣤⡶⠋\n" +
                        "⠀⠀⠀⠀⠐⠒⠀⠠⠤⠤⠤⠶⠶⠚⠛⠛⠉⠀⠀⠀"
        );

        asciiart.add(
                        "          ===  %%%%%%%%%%                   \n" +
                        "       === %%%%%%%%%%%%%%%%%%               \n" +
                        "     === %%%%%%%%%%%%%%%%%%%%%%             \n" +
                        "   === %%%%%%%%%%%%%%%%%%%%%%%%%%           \n" +
                        "  === %%%%%%%%%%%%%%%%%%%%%%%%%%%%          \n" +
                        " === %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%         \n" +
                        " ===................................        \n" +
                        "=== %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%        \n" +
                        "=== ................................        \n" +
                        "=== %%%%%######################%%%%%        \n" +
                        " ===................................        \n" +
                        " === %%%%%%###################%%%%%         \n" +
                        "  === %%%%%%################%%%%%%          \n" +
                        "   === %%%%%%%%##########%%%%%%%%           \n" +
                        "     === %%%%%%%%%%%%%%%%%%%%%%             \n" +
                        "       === %%%%%%%%%%%%%%%%%%               \n" +
                        "          -==  %%%%%%%%%%                   \n"
        );

        asciiart.add(
                        "████████████████████████\n" +
                        "████    ███████  ███████\n" +
                        "█████  ████████  ███████\n" +
                        "█████  ████████  ███████\n" +
                        "█████  ████████  ███████\n" +
                        "████    ███      ███████\n" +
                        "████████████████████████\n" +
                        "████████████████████████\n" +
                        "███        █████████████\n" +
                        "████████████████████████\n"
        );

        asciiart.add(
                        "███████  ██████  ██████  ████████  ██        ██ ██          ██ \n" +
                        "██      ██    ██ ██   ██    ██    ██        ███  ██  ████      \n" +
                        "███████ ██    ██ ██████     ██    ██  █████  ██  ██         ██ \n" +
                        "     ██ ██ ▄▄ ██ ██   ██    ██    ██         ██  ██  ████   ██ \n" +
                        "███████  ██████  ██   ██    ██     ██        ██ ██          ██ \n" +
                        "            ▀▀                                                 \n"
        );

        asciiart.add(
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢎⠱⠊⡱⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠤⠒⠒⠒⠒⠤⢄⣑⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⢀⡤⠒⠝⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠲⢄⡀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⢠⣢⠐⡄⠀⠉⠑⠒⠒⠒⣄\n" +
                        "⠀⠀⠀⣀⠴⠋⠀⠀⠀⡎⢀⣘⠿⠀⠀⢠⣀⢄⡦⠀⣛⣐⢸⠀⠀⠀⠀⠀⠀⢘\n" +
                        "⡠⠒⠉⠀⠀⠀⠀⠀⡰⢅⠣⠤⠘⠀⠀⠀⠀⠀⠀⢀⣀⣤⡋⠙⠢⢄⣀⣀⡠⠊\n" +
                        "⢇⠀⠀⠀⠀⠀⢀⠜⠁⠀⠉⡕⠒⠒⠒⠒⠒⠛⠉⠹⡄⣀⠘⡄⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠑⠂⠤⠔⠒⠁⠀⠀⡎⠱⡃⠀⠀⡄⠀⠄⠀⠀⠠⠟⠉⡷⠁⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠤⠤⠴⣄⡸⠤⣄⠴⠤⠴⠄⠼⠀⠀⠀⠀⠀⠀⠀⠀\n"
        );

        int id = (int) (Math.random() * asciiart.size()); // 0 to 3
        System.out.println(asciiart.get(id));
    }
}