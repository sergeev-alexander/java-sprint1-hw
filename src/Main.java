import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            String str = scanner.nextLine();
            int i = strCheck(str);
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                stepTracker.changeStepGoal();
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 4) {
                System.out.println("Пока!");
                return;
            } else {
                System.out.println("[" + str + "] - Такой команды нет!");
            }
        }
    }

    static void printMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("(1) -> Ввести количество шагов за определённый день");
        System.out.println("(2) -> Изменить цель по количеству шагов в день");
        System.out.println("(3) -> Напечатать статистику за определённый месяц");
        System.out.println("(4) -> Выйти из приложения");
    }


    public static int strCheck(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return 0;
            }
        }
        return Integer.parseInt(str);
    }
}

