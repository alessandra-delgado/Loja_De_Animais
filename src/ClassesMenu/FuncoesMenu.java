// Todo: Colocar cada menu na sua própria classe
package src.ClassesMenu;

import src.Input.Ler;

public class FuncoesMenu {


    public static void menu2() {
        System.out.println("1 - Produtos");
        System.out.println("2 - Empregados");
        System.out.println("3 - Clientes");
        System.out.println("4 - Sair");
        System.out.println("Escolha uma opção:");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    MenuProduct.show();
                    return;
                case 2:
                    MenuEmpregados.show();
                    return;
                case 3:
                    MenuClient.show();
                    return;
                case 4:
                    System.out.println("A sair...");
                    return;
                default:
                    break;
            }
        }
    }

    public static void menu3() {
        System.out.println("1 - Vendas");
        System.out.println("2 - Clientes");
        System.out.println("3 - Sair");
        System.out.println("Escolha uma opção:");

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

}


