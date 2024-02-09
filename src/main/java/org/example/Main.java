package org.example;

import org.example.lab2_3_4_5.exception.DuplicateModelNameException;
import org.example.lab2_3_4_5.Util;
import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.exception.IncorrectModelNameVehicle;
import org.example.lab2_3_4_5.exception.IncorrectPriceVehicle;
import org.example.lab2_3_4_5.exception.ModelPriceOutOfBoundsException;
import org.example.lab2_3_4_5.exception.NoSuchModelNameException;
import org.example.lab6_1.ModelNameThread;
import org.example.lab6_1.PriceThread;
import org.example.lab2_3_4_5.vehicle.*;
import org.example.lab6_2.ModelNameRunnable;
import org.example.lab6_2.PriceNameRunnable;
import org.example.lab6_2.TransportSynchronizer;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchModelNameException, DuplicateModelNameException, ModelPriceOutOfBoundsException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        //Лабораторная работа №1
       /* MySecondClass mySecondClass = new MySecondClass();
        mySecondClass.changeElement(1, 100);
        System.out.println(mySecondClass.average());
        mySecondClass.printArray();*/

        Car car = new Car("JAK", 1);
        car.addNewModel("i1", 3_750_000);
        car.addNewModel("i2", 4_000_000);
        car.addNewModel("i3", 3_770_000);

        System.out.println("---");

        Bike bike = new Bike("BMW", 0);
        bike.addNewModel("k1", 1_900_000);
        bike.addNewModel("k2", 2_000_000);
        bike.addNewModel("k3", 3_000_000);
        bike.addNewModel("k4", 3_000_000);

        OutputStream outCar = null;
        try {
            outCar = new DataOutputStream(new FileOutputStream("forCarByte.txt"));
            Util.outputVehicle(car, outCar);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        OutputStream outBike = null;
        try {
            outBike = new DataOutputStream(new FileOutputStream("forBikeByte.txt"));
            Util.outputVehicle(bike, outBike);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Чтение из файла (байтовый поток)
        InputStream inCar = null;
        try {
            inCar = new DataInputStream(new FileInputStream("forCarByte.txt"));
            System.out.println(Util.inputCar(inCar));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        InputStream inBike = null;
        try {
            inBike = new DataInputStream(new FileInputStream("forBikeByte.txt"));
            System.out.println(Util.inputBike(inBike));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Запись в файл (символьный поток)
        Writer brCar = null;
        try {
            brCar = new BufferedWriter(new FileWriter("forCarSymbol.txt"));
            Util.writeVehicle(car, brCar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Writer brBike = null;
        try {
            brBike = new BufferedWriter(new FileWriter("forBikeSymbol.txt"));
            Util.writeVehicle(bike, brBike);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Чтение из файла (символьный поток)
        Reader readCar = null;
        try {
//            readCar = new BufferedReader(new FileReader("forCarSymbol.txt"));
            readCar = new FileReader("forCarSymbol.txt");
            Scanner scanner = new Scanner(readCar);
            System.out.println(Util.readCar(scanner));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Reader readBike = null;
        try {
            readBike = new BufferedReader(new FileReader("forBikeSymbol.txt"));
            System.out.println(Util.readBike(readBike));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---");

        Util.serializeVehicle(car);
        System.out.println(Util.deserializeCar());

        Class clazz = Class.forName("org.example.lab2_3_4_5.vehicle.Car");
        Method method = clazz.getDeclaredMethod("changeModelPrice", String.class, int.class);
        method.invoke(car, "i1", 2_240_000);

        //Лабораторная работа №7
        Vehicle moped = new Moped("Vespa", 3);
        moped.addNewModel("Primavera", 1_900_000);
        moped.addNewModel("Elettrica", 2_000_000);
        moped.addNewModel("GTV", 2_150_000);

        //Задание №1
        ModelNameThread thread1 = new ModelNameThread(moped);
        PriceThread thread2 = new PriceThread(moped);

        System.out.println("---");

        /*thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();*/

        //Задание №2

        System.out.println("---");
/*

        TransportSynchronizer sync = new TransportSynchronizer(car);
        ModelNameRunnable model = new ModelNameRunnable(sync);
        PriceNameRunnable price = new PriceNameRunnable(sync);

        Thread t1 = new Thread(model);
        Thread t2 = new Thread(price);

        t1.start();
        t2.start();
*/

    }
}