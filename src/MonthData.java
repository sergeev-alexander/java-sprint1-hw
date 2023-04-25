class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth(int month) {
        for (int i = 0; i < days.length; i++) {
            String monthName = monthName(month);
            String monthNameCorrectEnding = correctMonthEnding(month, monthName);
            System.out.printf("%02d " + monthNameCorrectEnding + " %d", i + 1, days[i]);
            System.out.println();
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
        }
        return finalSeries;
    }

    String monthName(int month) {
        switch (month - 1) {
            case 0:
                return "январь";
            case 1:
                return "февраль";
            case 2:
                return "март";
            case 3:
                return "апрель";
            case 4:
                return "май";
            case 5:
                return "июнь";
            case 6:
                return "июль";
            case 7:
                return "август";
            case 8:
                return "сентябрь";
            case 9:
                return "октябрь";
            case 10:
                return "ноябрь";
            case 11:
                return "декабрь";
            default:
                return ("[" + month + "] - Некорректный номер месяца!");
        }
    }

    String correctMonthEnding (int month, String monthName) {
        String end = "";
        if (month == 3 || month == 8) {
            end = "та";
        } else {
            end = "я";
        }
        return monthName.substring(0, monthName.length() - 1) + end;
    }
}
