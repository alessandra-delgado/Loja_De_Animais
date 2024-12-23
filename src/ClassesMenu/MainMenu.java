package src.ClassesMenu;

import src.Input.Ler;

public class MainMenu implements IMenu{
    private void menu() {
        System.out.println("1 - Catálogo");
        System.out.println("2 - Inventário ");
        System.out.println("3 - Estatisticas");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void show() {
        int op = 0;
        do {
            menu();
            op = Ler.umInt();
            switch (op) {
                case 1:
                    FuncoesMenu.menuCatalogo();
                    break;
                case 2:
                    FuncoesMenu.menuInventario();
                    break;
                case 3:
                    FuncoesMenu.menuEstatisticas();
                    break;
                case 4:
                    // Exit
                    return;
            }
        } while (true);
    }
}

