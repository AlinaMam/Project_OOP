package org.example.lab7;

import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.vehicle.Car;
import org.example.lab2_3_4_5.vehicle.Moped;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Server {
    public static void main(String[] args) {
        int portNumber = 1777;
        Vehicle car = null;
        Vehicle moped = null;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                System.out.println("Waiting for connection on " + portNumber);

                Socket fromClientSocket = serverSocket.accept();

                try (Socket localSocket = fromClientSocket;
                     ObjectInputStream ois = new ObjectInputStream(localSocket.getInputStream());
                     ObjectOutputStream oos = new ObjectOutputStream(localSocket.getOutputStream())) {

                    List<Serializable> objects = (List<Serializable>) ois.readObject();
                    System.out.println("From client: " + objects);
                    for (Serializable object : objects) {
                        if (object instanceof Car) {
                            car = (Car) object;
                        } else if (object instanceof Moped) {
                            moped = (Moped) object;
                        }
                    }
                    int[] pricesOfModels1 = car.getPricesOfModels();
                    int[] pricesOfModels2 = moped.getPricesOfModels();
                    int[] prices = new int[pricesOfModels1.length + pricesOfModels2.length];
                    System.arraycopy(pricesOfModels1, 0, prices, 0, pricesOfModels1.length);
                    System.arraycopy(pricesOfModels2, 0, prices, pricesOfModels1.length, pricesOfModels2.length);

                    double average = Arrays.stream(prices).average().getAsDouble();

                    oos.writeDouble(average);

                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
