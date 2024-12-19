package src.menu;
import menu.FuncoesMenu;
import inputs.Ler;

public class menu {
    public static void main(String[] args) {
        System.out.println("1 - Catálogo");
        System.out.println("2 - Inventário ");
        System.out.println("3 - Estatisticas");
        System.out.println("4 - Sair");
        System.out.println("Escolha uma opção:");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    FuncoesMenu m1 = new FuncoesMenu();
                    m1.menu1();
                    break;
                case 2:
                    FuncoesMenu m2 = new FuncoesMenu();
                    m2.menu2();
                    break;
                case 3:
                    FuncoesMenu m3 = new FuncoesMenu();
                    m3.menu3();

                    break;
                case 4:
                    return;
            }
        }
    }
}

