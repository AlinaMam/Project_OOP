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
    public static void main(String[] args) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle, IOException {
        Vehicle car = new Car("EXEED", 1);
        car.addNewModel("i10", 2_900_000);
        car.addNewModel("i20", 3_100_000);

        Vehicle moped = new Moped("Vespa", 2);
        moped.addNewModel("Primavera", 1_900_000);
        moped.addNewModel("GTV", 2_500_000);

        int portNumber = 1777;
        double avg;
        System.out.println("Client is started");

        Socket socket = new Socket("127.0.0.1", portNumber);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        List<Serializable> objects = new ArrayList<>();
        objects.add((Serializable) car);
        objects.add((Serializable) moped);

        oos.writeObject(objects);

        System.out.println("From server: " + ois.readDouble());

        ois.close();
        oos.close();
        socket.close();
    }
}
