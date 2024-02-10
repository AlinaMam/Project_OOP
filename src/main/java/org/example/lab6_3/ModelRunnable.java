package org.example.lab6_3;

import org.example.lab2_3_4_5.Vehicle;

import java.util.concurrent.locks.Lock;

public class ModelRunnable implements Runnable {
    private final Vehicle vehicle;
    private final Lock locker;

    public ModelRunnable(Vehicle vehicle, Lock locker) {
        this.vehicle = vehicle;
        this.locker = locker;
    }

    @Override
    public void run() {
        this.locker.lock();
        try {
            String[] namesOfModels = this.vehicle.getNamesOfModels();
            for (String model : namesOfModels) {
                System.out.println("Model name: " + model);
            }
        } finally {
            this.locker.unlock();
        }
    }
}
