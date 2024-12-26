package src.ClassesMenu;

import src.Input.Ler;

public class MainMenu {
    private static void menu() {
        System.out.println("1 - Loja");
        System.out.println("2 - Inventário");
        System.out.println("3 - Estatisticas");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void show() {
        do {
            menu();

            switch (Ler.umInt()) {
                case 1:
                    ShopMenu.show();
                    break;
                case 2:
                    FuncoesMenu.menu2();
                    break;
                case 3:
                    FuncoesMenu.menu3();
                    break;
                case 4:
                    // Exit
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);
    }
}

