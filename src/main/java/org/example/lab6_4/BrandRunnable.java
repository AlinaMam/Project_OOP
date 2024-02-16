package org.example.lab6_4;

import org.example.lab2_3_4_5.Vehicle;

public class BrandRunnable implements Runnable {
    private Vehicle vehicle;

    public BrandRunnable(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        System.out.println(vehicle.getBrand() + " with " + Thread.currentThread().getName());
    }
}
