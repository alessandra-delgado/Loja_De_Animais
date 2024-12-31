package src.ClassesMenu;

import src.Input.Ler;

public class MainMenu {
    private static void menu() {
        System.out.println("╭──────────────────╮");
        System.out.println("│ 1 - Loja         │");
        System.out.println("│ 2 - Inventário   │");
        System.out.println("│ 3 - Estatisticas │");
        System.out.println("│ 4 - Ajuda        │");
        System.out.println("│ 5 - Sair         │");
        System.out.println("╰──────────────────╯");
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
                    InventoryMenu.menu2();
                    break;
                case 3:
                    StatsMenu.showMenu();
                    break;
                case 4:
                    HelpMenu.show();
                    break;
                case 5:
                    // Exit
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);
    }
}

