package src.ClassesMenu;
import src.Input.Ler;

public class FuncoesMenu {
    public static void menu1() {
        System.out.println("1 - Visualizar catálogo");
        System.out.println("2 - Fazer Compra");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Finge que tem um catálogo :3");
                    break;
                case 2:
                    System.out.println("Fazer Compra");
                    break;
                case 3:
                    System.out.println("Saí do menu 1");
                    return;
            }
        }
    }
    public static void menu2() {
        System.out.println("1 - Produtos");
        System.out.println("2 - Empregados");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Produtos");
                    break;
                case 2:
                    System.out.println("Empregados");
                    break;
                case 3:
                    System.out.println("sair do menu 2");
                    return;
            }
        }
    }
    public static void menu3() {
        System.out.println("1 - Vendas");
        System.out.println("2 - Clientes");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Vendas");
                    break;
                case 2:
                    System.out.println("Clientes");
                    break;
                case 3:
                    System.out.println("Saí do menu 3");
                    return;
            }
        }

    }

    public static void catalogo() {

    }
}