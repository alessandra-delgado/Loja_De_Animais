package src.ClassesMenu;

import src.ClassesLoja.Client;
import src.ClassesLoja.Purchase;
import src.Input.Ler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import static src.Main.clients;

public class TotalGainedMenu {
    public static void menu() {
        System.out.println("1 - Valor faturado num dia");
        System.out.println("2 - Valor faturado numa semana");
        System.out.println("3 - Valor faturado num mês");
        System.out.println("4 - Sair");
    }

    public static void showMenu() {
        do {
            TotalGainedMenu.menu();
            LocalDate date = LocalDate.now();

            switch (Ler.umInt()) {
                case 1:
                    System.out.println("Insira o dia pretendido (YYYY-MM-DD): ");
                    date = LocalDate.parse(Ler.umaString());
                    double total_day = TotalGainedMenu.Total_Day(date);
                    System.out.println("Valor faturado no dia " + date + " = " + total_day);
                    break;
                case 2:
                    System.out.println("Insira um dia da semana pretendida (YYYY-MM-DD): ");
                    date = LocalDate.parse(Ler.umaString());
                    TotalGainedMenu.Total_week(date);
                    break;
                case 3:
                    System.out.println("Insira o ano pretendido: ");
                    int year = Ler.umInt();
                    System.out.println("Insira o mês pretendido (numero inteiro): ");
                    int month = Ler.umInt();
                    date = LocalDate.of(year, month, 1);
                    TotalGainedMenu.Total_Month(date);
                    break;
                case 4:
                    System.out.println("Sair");
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(true);
    }

    public static double Total_Day(LocalDate date) {
        double total_day = 0.0;
        for (Client c : clients) {
            for (Purchase p : c.getPurchases()) {
                if (p.getPurchase_time().toLocalDate().equals(date)) {
                    total_day += p.getTotal();
                }
            }
        }
        return total_day;
    }

    public static void Total_week(LocalDate date) {
        double total_week = 0.0;
        LocalDate StartWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate EndWeek = StartWeek.plusDays(6);

        for (int i = 0; i < 7; i++) {
            total_week += Total_Day(StartWeek.plusDays(i));
        }
        System.out.println("Valor faturado na semana de dia " + StartWeek + " a " + EndWeek + " = " + total_week);
    }

    public static void Total_Month(LocalDate date) {
        double total_month = 0.0;

        for(int i=0; i<date.lengthOfMonth(); i++) {
            total_month += Total_Day(date.plusDays(i));
        }
        System.out.println("Valor faturado no mês " + date.getMonth() + " = " + total_month);
    }
}
