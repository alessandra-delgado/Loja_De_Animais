package src.ClassesMenu;
import src.Input.Ler;

public class Menu {
    public static void main_menu() {
        System.out.println("1 - Catálogo");
        System.out.println("2 - Inventário ");
        System.out.println("3 - Estatisticas");
        System.out.println("4 - Sair");
        System.out.println("Escolha uma opção:");
    }
    public static void main() {
        int op = 0;
        do {
            main_menu();
            op = Ler.umInt();
            switch (op) {
                case 1:
                    FuncoesMenu.menu1();
                    break;
                case 2:
                    FuncoesMenu.menu2();
                    break;
                case 3:
                    FuncoesMenu.menu3();
                    break;
                case 4:
                    return;
            }
        }while (true);
    }
}

