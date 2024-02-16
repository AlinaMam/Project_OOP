package org.example;

import org.example.lab2_3_4_5.Util;
import org.example.lab2_3_4_5.exception.DuplicateModelNameException;
import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.exception.IncorrectModelNameVehicle;
import org.example.lab2_3_4_5.exception.IncorrectPriceVehicle;
import org.example.lab2_3_4_5.exception.ModelPriceOutOfBoundsException;
import org.example.lab2_3_4_5.exception.NoSuchModelNameException;
import org.example.lab2_3_4_5.vehicle.*;
import org.example.lab6_1.ModelNameThread;
import org.example.lab6_1.PriceThread;
import org.example.lab6_2.ModelNameRunnable;
import org.example.lab6_2.PriceNameRunnable;
import org.example.lab6_2.TransportSynchronizer;
import org.example.lab6_3.ModelRunnable;
import org.example.lab6_3.PriceRunnable;
import org.example.lab6_4.BrandRunnable;
import org.example.lab6_5.MyVehicle;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        System.out.println(car.getLength());

        System.out.println("---");

        Bike bike = new Bike("BMW", 0);
        bike.addNewModel("k1", 1_900_000);
        bike.addNewModel("k2", 2_000_000);

        Moped vespa = new Moped("Vespa", 1);
        vespa.addNewModel("Primavera", 2_100_000);
        vespa.addNewModel("GTV", 2_200_000);

        Quadracycle quadracycle = new Quadracycle("Dobrynya", 1);
        quadracycle.addNewModel("dobryeDela1", 800_000);
        quadracycle.addNewModel("dobryeDela2", 900_000);

        OutputStream outCar = null;
        try {
            outCar = new DataOutputStream(new FileOutputStream("forCarByte.txt"));
            Util.outputVehicle(car, outCar);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        OutputStream outBike = null;
        try {
            outBike = new FileOutputStream("forBikeByte.txt");
            Util.outputVehicle(bike, outBike);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Чтение из файла (байтовый поток)
        InputStream inCar = null;
        try {
            inCar = new FileInputStream("forCarByte.txt");
            Vehicle newCar = Util.inputCar(inCar);
            System.out.println(Arrays.toString(newCar.getPricesOfModels()));
            System.out.println(Arrays.toString(newCar.getNamesOfModels()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        InputStream inBike = null;
        try {
            inBike = new DataInputStream(new FileInputStream("forBikeByte.txt"));
            Vehicle newBike = Util.inputBike(inBike);
            System.out.println(Arrays.toString(newBike.getPricesOfModels()));
            System.out.println(Arrays.toString(newBike.getNamesOfModels()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Запись в файл (символьный поток)
        Writer brCar = null;
        try {
            brCar = new FileWriter("forCarSymbol.txt");
            Util.writeVehicle(car, brCar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Writer brBike = null;
        try {
            brBike = new FileWriter("forBikeSymbol.txt");
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
            Vehicle newCar = Util.readCar(scanner);
            System.out.println(newCar);
            System.out.println(Arrays.toString(newCar.getNamesOfModels()));
            System.out.println(Arrays.toString(newCar.getPricesOfModels()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Reader readBike = null;
        try {
            readBike = new FileReader("forBikeSymbol.txt");
            Vehicle newBike = Util.readBike(readBike);
            System.out.println(newBike);
            System.out.println(Arrays.toString(newBike.getNamesOfModels()));
            System.out.println(Arrays.toString(newBike.getPricesOfModels()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---");

        Util.serializeVehicle(car);
        System.out.println(Util.deserializeCar());

        System.out.println("---");

        Class clazz = Class.forName("org.example.lab2_3_4_5.vehicle.Car");
        Method method = clazz.getDeclaredMethod("changeModelPrice", String.class, int.class);
        method.invoke(car, "i1", 2_240_000);

        //Лабораторная работа №6
        Vehicle moped = new Moped("Vespa", 3);
        moped.addNewModel("Primavera", 1_900_000);
        moped.addNewModel("Elettrica", 2_000_000);
        moped.addNewModel("GTV", 2_150_000);

        //Задание №1
        /*ModelNameThread thread1 = new ModelNameThread(moped);
        PriceThread thread2 = new PriceThread(moped);

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();*/

        //Задание №2

        /*System.out.println("---");

        TransportSynchronizer sync = new TransportSynchronizer(car);
        ModelNameRunnable model = new ModelNameRunnable(sync);
        PriceNameRunnable price = new PriceNameRunnable(sync);

        Thread t1 = new Thread(model);
        Thread t2 = new Thread(price);

        t1.start();
        t2.start();

        System.out.println("---");*/

        //Задание №3
        Lock locker = new ReentrantLock();
        ModelRunnable mr = new ModelRunnable(car, locker);
        PriceRunnable pr = new PriceRunnable(car ,locker);
        Thread tModel = new Thread(mr);
        Thread tPrice = new Thread(pr);

        tModel.start();
        tPrice.start();

        //Задание №4
        /*ExecutorService executor1 = Executors.newFixedThreadPool(2);
        BrandRunnable brand1 = new BrandRunnable(car);
        BrandRunnable brand2 = new BrandRunnable(bike);
        BrandRunnable brand3 = new BrandRunnable(vespa);
        BrandRunnable brand4 = new BrandRunnable(quadracycle);
        BrandRunnable[] brands = new BrandRunnable[4];
        brands[0] = brand1;
        brands[1] = brand2;
        brands[2] = brand3;
        brands[3] = brand4;
        for (int i = 0; i < brands.length; i++) {
            executor1.execute(brands[i]);
        }
        executor1.shutdown();*/

        System.out.println("---");

        //Задание №5
       /* ArrayBlockingQueue<Vehicle> vehicles = new ArrayBlockingQueue<>(4);
        String name1 = "brand1.txt";
        String name2 = "brand2.txt";
        String name3 = "brand3.txt";
        String name4 = "brand4.txt";
        String[] names = new String[4];
        names[0] = name1;
        names[1] = name2;
        names[2] = name3;
        names[3] = name4;
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        for (String name : names) {
            executor2.execute(new MyVehicle(name, vehicles));
        }
        executor2.shutdown();*/
    }
}