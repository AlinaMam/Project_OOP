package org.example.lab2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class Util {
    public static void averagePrice(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            int[] pricesOfModels = vehicle.getPricesOfModels();
            double avgPriceCar = Arrays.stream(pricesOfModels)
                    .average()
                    .getAsDouble();
            MathContext context = new MathContext(9, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(avgPriceCar, context);
            System.out.println("Average price of car: " + result);

        } else if (vehicle instanceof Bike) {
            int[] pricesOfModels = vehicle.getPricesOfModels();
            double avgPriceCar = Arrays.stream(pricesOfModels)
                    .average()
                    .getAsDouble();
            MathContext context = new MathContext(9, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(avgPriceCar, context);
            System.out.println("Average price of bike: " + result);
        }
    }

    public static void getNamesOfModels(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model car: " + s));
        } else if (vehicle instanceof Bike) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model bike: " + s));
        }
    }
}
