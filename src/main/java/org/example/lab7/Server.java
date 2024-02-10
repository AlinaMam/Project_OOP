package org.example.lab7;

import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.vehicle.Car;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int portNumber = 1777;
        Vehicle car = null;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)){

            Socket fromClientSocket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(fromClientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(fromClientSocket.getOutputStream());

            System.out.println("Waiting for connection on " + portNumber);

            Vehicle[] vehicles = (Vehicle[]) ois.readObject();
            for (Vehicle object : vehicles) {
                car = object;
            }
            assert car != null;
            int[] pricesOfModels = car.getPricesOfModels();

            double result = 0;
            for (int pricesOfModel : pricesOfModels) {
                result += pricesOfModel;
            }
            double avg = result / pricesOfModels.length;

            dos.writeDouble(avg);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
