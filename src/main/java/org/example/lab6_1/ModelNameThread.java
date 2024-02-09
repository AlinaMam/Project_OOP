package org.example.lab6_1;

import org.example.lab2_3_4_5.Vehicle;

public class ModelNameThread extends Thread {
    private Vehicle vehicle;

    public ModelNameThread(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        String[] namesOfModels = vehicle.getNamesOfModels();
        for (String name : namesOfModels) {
            System.out.println("Name of model: " + name);
        }
    }
}
