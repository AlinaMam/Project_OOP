package org.example.lab7;

import org.example.lab2_3_4_5.Util;
import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.exception.DuplicateModelNameException;
import org.example.lab2_3_4_5.exception.IncorrectModelNameVehicle;
import org.example.lab2_3_4_5.exception.IncorrectPriceVehicle;
import org.example.lab2_3_4_5.vehicle.Car;
import org.example.lab2_3_4_5.vehicle.Moped;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        int portNumber = 1777;
        double avg;
        System.out.println("Client is started");

        try(Socket socket = new Socket("localhost", portNumber);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            Vehicle[] vehicles = new Vehicle[2];
            for (int i = 0; i < vehicles.length; i++) {
                vehicles[i] = new Car("EXEED" + i, 2);
                vehicles[i].addNewModel("i10", 1_800_000);
                vehicles[i].addNewModel("i20", 1_900_000);
            }

            oos.writeObject(vehicles);

            System.out.println("From server: " + dis.readDouble());

        } catch (IOException e) {

        } catch (DuplicateModelNameException | IncorrectPriceVehicle | IncorrectModelNameVehicle e) {
            e.printStackTrace();
        }
    }
}
