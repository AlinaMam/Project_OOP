package org.example.lab6_2;

import org.example.lab2_3_4_5.Vehicle;

public class TransportSynchronizer {
    boolean printValue = false;
    private Vehicle vehicle;

    public TransportSynchronizer(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public synchronized void printNameOfModel() {
        String[] namesOfModels = vehicle.getNamesOfModels();
        for (String name : namesOfModels) {
            while (printValue) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            printValue = true;
            System.out.println("Model: " + name);
            notify();
        }
    }

    public synchronized void printPrice() {
        int[] pricesOfModels = vehicle.getPricesOfModels();
        for (int price : pricesOfModels) {
            while (!printValue) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Price: " + price);
            printValue = false;
            notify();
        }

    }
}
