import java.util.Scanner;

class StepTracker {

    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;
    Scanner scanner = new Scanner(System.in);
    MonthData[] monthToData = new MonthData[12];
    MonthData name = new MonthData();

    StepTracker() {
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца!");
        String strMonth = scanner.nextLine();
        int month = Main.strCheck(strMonth);
        if (month < 1 || month > 12) {
            System.out.println("[" + strMonth + "] - Некорректный номер месяца!");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)!");
        String strDay = scanner.nextLine();
        int day = Main.strCheck(strDay);
        if (day < 1 || day > 30) {
            System.out.println("[" + strDay + "] - Некорректный день!");
            return;
        }
        System.out.println("Введите количество шагов!");
        String strSteps = scanner.nextLine();
        int steps = Main.strCheck(strSteps);
        if (steps <= 0) {
            System.out.println("[" + strSteps + "] - Некорректное количество шагов!");
            return;
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
        String end = "";
        if (month == 3 || month == 8) {
            end = "та";
        } else {
            end = "я";
        }
        String monthRealName = name.monthName(month).substring(0, name.monthName(month).length() - 1) + end;
        System.out.println(steps + " шагов за " + day + " " + monthRealName + " -> Успешно сохранено!");
    }

    void changeStepGoal() {
        System.out.println("Текущая цель -> " + goalByStepsPerDay);
        System.out.println("Введите новую цель!");
        String str = scanner.nextLine();
        int newGoalStepsPerDay = Main.strCheck(str);
        if (newGoalStepsPerDay <= 0) {
            System.out.println("[" + str + "] - Некорректная цель!");
            return;
        } else {
            goalByStepsPerDay = newGoalStepsPerDay;
        }
        System.out.println("Цель успешно обновленна!\nНовая цель -> " + goalByStepsPerDay);
    }

    void printStatistic() {
        System.out.println("Введите число месяца!");
        String str = scanner.nextLine();
        int month = Main.strCheck(str);
        if (month < 1 || month > 12) {
            System.out.println("[" + str + "] - Некорректный номер месяца!");
            return;
        }
        System.out.println("Статистика по дням за " + name.monthName(month) + ":");
        monthToData[month - 1].printDaysAndStepsFromMonth(month);

        int sumSteps = monthToData[month - 1].sumStepsFromMonth();
        System.out.println("Сумма шагов за " + name.monthName(month) + " -> " + sumSteps);

        int maxSteps = monthToData[month - 1].maxSteps();
        System.out.println("Максимальное пройденное количество шагов за " + name.monthName(month) + " -> " + maxSteps);

        int averageSteps = monthToData[month - 1].sumStepsFromMonth() / 30;
        System.out.println("Среднее пройденное количество шагов за " + name.monthName(month) + " -> " + averageSteps);

        int kmDistance = converter.convertToKm(monthToData[month - 1].sumStepsFromMonth());
        System.out.println("Пройденноя за " + name.monthName(month) + " дистанция -> " + kmDistance + " км.");

        int kklBurned = converter.convertStepsToKilocalories(monthToData[month - 1].sumStepsFromMonth());
        System.out.println("Количество сожжённых килокалорий за " + name.monthName(month) + " -> " + kklBurned + " ккл.");

        int bestSeries = monthToData[month - 1].bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия за " + name.monthName(month) + " -> " + bestSeries);
        System.out.println();
    }
}


