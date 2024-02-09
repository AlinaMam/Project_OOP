package org.example.lab6_1;

import org.example.lab2_3_4_5.Vehicle;

public class PriceThread extends Thread {
    private Vehicle vehicle;

    public PriceThread(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        int[] pricesOfModels = vehicle.getPricesOfModels();
        for (int price : pricesOfModels) {
            System.out.println("Price: " + price);
        }
    }
}
