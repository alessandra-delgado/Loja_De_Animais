package src.ClassesMenu;

import src.Input.Ler;

public class InventoryMenu {

    public static void menu2() {
        System.out.println("1 - Produtos");
        System.out.println("2 - Animais");
        System.out.println("3 - Empregados");
        System.out.println("4 - Clientes");
        System.out.println("5 - Voltar");
        System.out.println("Escolha uma opção:");

        int op = 0;
        while (true) {
            op = Ler.umInt();
            switch (op) {
                case 1:
                    ProductMenu.show();
                    return;
                case 2:
                    AnimalsMenu.show();
                    return;
                case 3:
                    EmployeesMenu.show();
                    return;
                case 4:
                    ClientMenu.show();
                    return;
                case 5:
                    System.out.println("<-");
                    return;
                default:
                    break;
            }
        }
    }
}


