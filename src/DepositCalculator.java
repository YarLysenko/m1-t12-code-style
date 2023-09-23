import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return round(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculation() {
        int depositPeriod;
        int command;
        int amount;
        double out;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, " +
                "1 - вклад с обычным процентом, " +
                "2 - вклад с капитализацией:");

        command = scanner.nextInt();
        out = 0;
        if (command == 1) {
            out = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (command == 2) {
            out = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculation();
    }
}
