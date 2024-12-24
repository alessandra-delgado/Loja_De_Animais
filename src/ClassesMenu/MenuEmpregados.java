package src.ClassesMenu;

import src.Input.Ler;

public class MenuEmpregados {
    public static void menu() {
        System.out.println("1 - Adicionar Empregados");
        System.out.println("2 - Atualizar Empregados ");
        System.out.println("3 - Visualizar Empregados ");
        System.out.println("4 - Eliminar Empregados ");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção:");
    }

    public static void show() {
        int op = 0;
        while (true) {
            MenuEmpregados.menu();
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
                    System.out.println("A sair ...");
                    return;
            }
        }
    }
}