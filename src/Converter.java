class Converter {

    double convertToKm(int steps) {
        int oneStepLengthInCentimeters = 75;
        int centimetersInMeters = 100;
        int metersInKilometers = 100;
        return (double) steps * oneStepLengthInCentimeters / centimetersInMeters / metersInKilometers;

    }

    double convertStepsToKilocalories(int steps) {
        int caloriesPerStep = 50;
        int caloriesInKilocalories = 1000;
        return (double) steps * caloriesPerStep / caloriesInKilocalories;
    }
}
