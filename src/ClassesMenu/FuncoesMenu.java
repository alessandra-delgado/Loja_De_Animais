// Todo: Colocar cada menu na sua própria classe
package src.ClassesMenu;

import src.Input.Ler;

public class FuncoesMenu {
    public static void menuInventario() {
        while (true) {
            System.out.println("1 - Produtos");
            System.out.println("2 - Empregados");
            System.out.println("3 - Voltar");
            System.out.print("Insira uma opção: ");
            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Produtos");
                    MenuProduct.show();
                    break;
                case 2:
                    System.out.println("Empregados");
                    Menu_Empregados.main();
                    break;
                case 3:
                    System.out.println("A sair...");
                    return;
            }
        }
    }

    public static void menuEstatisticas() {
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

    public class Menu_Empregados {
        public static void main_Empregados() {
            System.out.println("1 - Adicionar Empregados");
            System.out.println("2 - Atualizar Empregados ");
            System.out.println("3 - Visualizar Empregados ");
            System.out.println("4 - Eliminar Empregados ");
            System.out.println("5 - Sair");
            System.out.println("Escolha uma opção:");
        }

        public static void main() {
            int op = 0;
            do {
                main_Empregados();
                op = Ler.umInt();
                switch (op) {
                    case 1:
                        System.out.println("Adicionar Empregados");
                        break;
                    case 2:
                        System.out.println("Atualizar Empregados");
                        break;
                    case 3:
                        System.out.println("Visualizar Empregados");
                        break;
                    case 4:
                        System.out.println("Eliminar Empregados");
                        break;
                    case 5:
                        System.out.println("Sair");
                        return;
                }
            } while (true);
        }
    }
}
