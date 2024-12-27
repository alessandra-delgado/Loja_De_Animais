// Todo: Colocar cada menu na sua própria classe
package src.ClassesMenu;

import src.Input.Ler;

public class FuncoesMenu {
    public static void menu1() {
        System.out.println("1 - Visualizar catálogo");
        System.out.println("2 - Fazer Compra");
        System.out.println("3 - Sair");
        System.out.println("Escolha uma opção:");

        int op = 0;
        while (true) {
            System.out.println("1 - Produtos");
            System.out.println("2 - Empregados");
            System.out.println("3 - Voltar");
            System.out.print("Insira uma opção: ");
            switch (Ler.umInt()) {
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
        System.out.println("Escolha uma opção:");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    MenuProduct.show();
                    break;
                case 2:

                    MenuEmpregados.show();
                    break;
                case 3:
                    System.out.println("A sair...");
                    return;
            }
        }
    }

    public static void menu3() {
        System.out.println("1 - Produtos mais vendidos");
        System.out.println("2 - Produtos menos vendidos");
        System.out.println("3 - Melhores clientes");
        System.out.println("4 - Valor faturado");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção:");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    System.out.println("Produtos mais vendidos");

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


