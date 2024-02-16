package org.example.lab6_3;

import org.example.lab2_3_4_5.Vehicle;

import java.util.concurrent.locks.Lock;

public class PriceRunnable implements Runnable {
    private Vehicle vehicle;
    private Lock locker;

    public PriceRunnable(Vehicle vehicle, Lock locker) {
        this.vehicle = vehicle;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            int[] pricesOfModels = vehicle.getPricesOfModels();
            for (int price : pricesOfModels) {
                System.out.println("Price: " + price);
            }
        } finally {
            locker.unlock();
        }
    }
}
