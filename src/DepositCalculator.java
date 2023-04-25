import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double deposit, double yearRate, int depositTerm) {
        double result = deposit * Math.pow((1 + yearRate / 12), 12 * depositTerm);
        return round(result, 2);
    }

    double calculateSimplePercent(double deposit, double yearRate, int depositTerm) {
        return round(deposit + deposit * yearRate * depositTerm, 2);
    }

    double round(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void getDepoWithPercent() {
        int deposit;
        int depositTerm;
        int depositType;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        deposit = input.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositTerm = input.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = input.nextInt();
        double depoWithPercent = 0;
        if (depositType ==1) {
            depoWithPercent = calculateSimplePercent(deposit, 0.06, depositTerm);
        } else if (depositType == 2) {
            depoWithPercent = calculateComplexPercent(deposit, 0.06, depositTerm);
        }
        System.out.println("Результат вклада: " + deposit + " за " + depositTerm + " лет превратятся в " + depoWithPercent);
    }

    public static void main(String[] args) {
        new DepositCalculator().getDepoWithPercent();
    }
}

