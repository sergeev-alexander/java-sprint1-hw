import java.util.Scanner;

class StepTracker {

    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;
    Scanner scanner = new Scanner(System.in);
    MonthData[] monthToData = new MonthData[12];

    StepTracker() {
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println(month + " - Некорректный номер месяца!");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println(day + " - Некорректный день!");
            return;
        }
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println(steps + " - Некорректное количество шагов!");
            return;
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Текущая цель -> " + goalByStepsPerDay);
        System.out.println("Введите новую цель!");
        int newGoalStepsPerDay = scanner.nextInt();
        if (newGoalStepsPerDay <= 0) {
            System.out.println(newGoalStepsPerDay + " - Некорректная цель!");
            return;
        } else {
            goalByStepsPerDay = newGoalStepsPerDay;
        }
        System.out.println("Цель успешно обновленна!\nНовая цель -> " + goalByStepsPerDay);
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        String monthName = "";
        switch (month - 1) {
            case 0:
                monthName = "январь";
                break;
            case 1:
                monthName = "феврфль";
                break;
            case 2:
                monthName = "март";
                break;
            case 3:
                monthName = "апрель";
                break;
            case 4:
                monthName = "май";
                break;
            case 5:
                monthName = "июнь";
                break;
            case 6:
                monthName = "июль";
                break;
            case 7:
                monthName = "август";
                break;
            case 8:
                monthName = "сентябрь";
                break;
            case 9:
                monthName = "октябрь";
                break;
            case 10:
                monthName = "ноябрь";
                break;
            case 11:
                monthName = "декабрь";
                break;
            default:
                System.out.println(month + " - Некорректный номер месяца!");
                return;
        }
        System.out.println("Статистика по дням за " + monthName + ":");
        monthToData[month - 1].printDaysAndStepsFromMonth();
        int sumSteps = monthToData[month - 1].sumStepsFromMonth();
        System.out.println("Сумма шагов за " + monthName + " -> " + sumSteps);
        int maxSteps = monthToData[month - 1].maxSteps();
        System.out.println("Максимальное пройденное количество шагов за " + monthName + " -> " + maxSteps);
        int averageSteps = monthToData[month - 1].sumStepsFromMonth() / 30;
        System.out.println("Среднее пройденное количество шагов за " + monthName + " -> " + averageSteps);
        int kmDistance = converter.convertToKm(monthToData[month - 1].sumStepsFromMonth());
        System.out.println("Пройденноя за " + monthName + " дистанция -> " + kmDistance + " км.");
        int kklBurned = converter.convertStepsToKilocalories(monthToData[month - 1].sumStepsFromMonth());
        System.out.println("Количество сожжённых килокалорий за " + monthName + " -> " + kklBurned + " ккл.");
        int bestSeries = monthToData[month - 1].bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия за " + monthName + " -> " + bestSeries);
        System.out.println();
    }

}


