package src.ClassesMenu;

import src.Input.Ler;

public class HelpMenu {
    public static void menu() {
        System.out.println("╭───────────────────╮");
        System.out.println("│ 1 - Loja          │");
        System.out.println("│ 2 - Inventário    │");
        System.out.println("│ 3 - Estatísticas  │");
        System.out.println("│ 4 - Voltar        │");
        System.out.println("╰───────────────────╯");
        System.out.println(" ");
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃  Escolha uma opção:  ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void show () {
        do {
            HelpMenu.menu();

            switch (Ler.umInt()) {
                case 1:
                    System.out.println("╭────────────────────────────────────────────────────────────────────────────────────────────────╮");
                    System.out.println("│ Esta opção corresponde à visualização do catálogo da loja ou à opção para realizar uma compra. │ ");
                    System.out.println("╰────────────────────────────────────────────────────────────────────────────────────────────────╯");
                    break;
                case 2:
                    System.out.println("╭───────────────────────────────────────────────────────────────────────────────────────────────────────╮");
                    System.out.println("│ Esta opção corresponde à gestão de stock ou à gestão de pessoal docente da loja!                      │");
                    System.out.println("│ Isto é, adição de produtos ou pessoal, atualização de informações, visualização ou remoção dos mesmos.│");
                    System.out.println("╰───────────────────────────────────────────────────────────────────────────────────────────────────────╯");
                    break;
                case 3:
                    System.out.println("╭───────────────────────────────────────────────────────────────────────────────────────────────────╮");
                    System.out.println("│ Esta opção corresponde às estatísticas da loja!                                                   │");
                    System.out.println("│ Isto é, produtos de maior ou menor sucesso; tabelas de classificação de clientes e valor faturado.│");
                    System.out.println("╰───────────────────────────────────────────────────────────────────────────────────────────────────╯");
                    break;
                case 4:
                    System.out.println("╭─────────────╮");
                    System.out.println("│  A sair...  │");
                    System.out.println("╰─────────────╯");
                    return;
                default:
                    System.out.println("┏━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃ Opção inválida! ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━┛");
                    return;
            }
        } while (true);
    }
}
