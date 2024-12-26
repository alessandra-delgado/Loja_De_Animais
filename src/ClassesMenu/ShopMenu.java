package src.ClassesMenu;

import src.Input.Ler;

public class ShopMenu {
    private static void menu() {
        System.out.println("Menu Catálogo");
        System.out.println("1 - Visualizar catálogo");
        System.out.println("2 - Fazer Compra");
        System.out.println("3 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void show() {
        while (true) {
            ShopMenu.menu();
            switch (Ler.umInt()) {
                case 1:
                    CatalogMenu.show();
                    break;
                case 2:
                    PurchaseMenu.show();
                    break;
                case 3:
                    System.out.println("A voltar");
                    return;
            }
        }
    }
}