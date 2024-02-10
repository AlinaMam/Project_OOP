package org.example.lab6_5;

import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.vehicle.Car;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class MyVehicle implements Runnable {
    String fileName;
    ArrayBlockingQueue<Vehicle> brands;

    public MyVehicle(String fileName, ArrayBlockingQueue<Vehicle> brands) {
        this.fileName = fileName;
        this.brands = brands;
    }

    @Override
    public void run() {
        Vehicle vehicle = null;

        try (FileReader fis = new FileReader(this.fileName)) {
            StringBuilder builder = new StringBuilder();
            int num;
            while ((num = fis.read()) != -1) {
                builder.append((char) num);
            }
            vehicle = new Car(builder.toString(), 1);
            this.brands.put(vehicle);

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
