package menu;
import inputs.Ler;

public class FuncoesMenu {
    public void menu1() {
        System.out.println("1 - Visualizar catálogo");
        System.out.println("2 - Fazer Compra");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:

                    break;
                case 2:

                    return;
                case 3:
                    return;
            }
        }
    }
    public void menu2() {
        System.out.println("1 - Produtos");
        System.out.println("2 - Empregados");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    return;
            }
        }
    }
    public void menu3() {
        System.out.println("1 - Vendas");
        System.out.println("2 - Clientes");
        System.out.println("3 - Sair");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    return;
            }
        }

    }
}