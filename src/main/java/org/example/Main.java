package org.example;

import org.example.lab2_3.*;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchModelNameException, DuplicateModelNameException, ModelPriceOutOfBoundsException {
        /*//Лабораторная работа №1
        MySecondClass mySecondClass = new MySecondClass();
        mySecondClass.changeElement(1, 100);
        System.out.println(mySecondClass.average());
        mySecondClass.printArray();*/

        //Лабораторная работа №2
        //Задание №1
        Car car = new Car("JAK", 3);
        Car.Model[] arrayModels = {
                car.new Model("i30", 5_000_000),
                car.new Model("i20", 4_000_000),
                car.new Model("i10", 3_500_000)
        };
        car.setArray(arrayModels);
        System.out.println(Arrays.toString(car.getArray()));
        car.changeModelName("i20", "i35");
        System.out.println(Arrays.toString(car.getArray()));
        System.out.println(Arrays.toString(car.getNamesOfModels()));
        System.out.println(car.getPriceOfModelName("i35"));
        car.changeModelPrice("i35", 4_700_000);
        System.out.println(Arrays.toString(car.getArray()));
        System.out.println(Arrays.toString(car.getPricesOfModels()));
        Car.Model model1 = car.new Model("i40", 3_800_000);
        Car.Model model2_0 = car.new Model("i55", 3_750_000);
        car.addNewCarModel(model1);
        car.addNewCarModel(model2_0);
        System.out.println(Arrays.toString(car.getArray()));
        car.deleteModel("i35");
        System.out.println(Arrays.toString(car.getArray()));
        System.out.println(car.getSizeArrayModels());
        //Задание №2
        Bike bike = new Bike("BMW", 3);
        Bike.Model model1_0 = bike.new Model("ky10", 1_700_000);
        Bike.Model model2 = bike.new Model("ky11", 1_800_000);
        Bike.Model model3 = bike.new Model("ky12", 1_900_300);
        LinkedList<Bike.Model> list = new LinkedList<>();
        Collections.addAll(list, model1_0, model2, model3);
        bike.setList(list);
        System.out.println(bike.getList());
        bike.changeModelName("ky10", "ky200");
        System.out.println(bike.getList());
        System.out.println(Arrays.toString(bike.getNamesOfModels()));
        System.out.println(bike.getPriceOfModelName("ky12"));
        bike.changeModelPrice("ky12", 2_000_000);
        System.out.println(bike.getList());
        System.out.println(Arrays.toString(bike.getPricesOfModels()));
        Bike.Model model4 = bike.new Model("ky300", 2_700_000);
        Bike.Model model5 = bike.new Model("ky301", 2_900_000);
        Bike.Model model6 = bike.new Model("ky302", 3_900_000);
        Bike.Model model7 = bike.new Model("ky308", 3_420_000);
        bike.addNewBikeModel(model5);
        bike.addNewBikeModel(model6);
        bike.addNewBikeModel(model7);
        bike.addNewBikeModel(model4);
        System.out.println(bike.getList());
        bike.deleteModel("ky11");
        bike.deleteModel("ky308");
        System.out.println(bike.getList());
        System.out.println(bike.getSizeLinkedList());

        //Задание №5
       /* Util.averagePrice(car);
        Util.averagePrice(bike);
        Util.getNamesOfModels(car);
        Util.getNamesOfModels(bike);*/

        //Лабораторная работа №3
        //Запись в файл (байтовый поток)
        /*OutputStream outCar = null;
        try {
            outCar = new DataOutputStream(new FileOutputStream("forCar.txt"));
            Util.outputVehicle(car, outCar);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        OutputStream outBike = null;
        try {
            outBike = new DataOutputStream(new FileOutputStream("forBike.txt"));
            Util.outputVehicle(bike, outBike);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Чтение из файла (байтовый поток)
        InputStream inCar = null;
        try {
            inCar = new DataInputStream(new FileInputStream("forCar.txt"));
            System.out.println(Util.inputCar(inCar));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        InputStream inBike = null;
        try {
            inBike = new DataInputStream(new FileInputStream("forBike.txt"));
            System.out.println(Util.inputBike(inBike));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        //Запись в файл (символьный поток)
        /*Writer brCar = null;
        try {
            brCar = new BufferedWriter(new FileWriter("forCar.txt"));
            Util.writeVehicle(car, brCar);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

      /*  Writer brBike = null;
        try {
            brBike = new BufferedWriter(new FileWriter("forBike.txt"));
            Util.writeVehicle(bike, brBike);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        //Чтение из файла (символьный поток)
       /* Reader readCar = null;
        try {
            readCar = new BufferedReader(new FileReader("forCar.txt"));
            System.out.println(Util.readCar(readCar));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

      /*  Reader readBike = null;
        try {
            readBike = new BufferedReader(new FileReader("forBike.txt"));
            System.out.println(Util.readBike(readBike));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        //Сериализация
//        Util.serializeVehicle(car, bike);

        Vehicle carNew = Util.deserializeCar();
        Vehicle bikeNew = Util.deserializeBike();
        System.out.println(carNew);
        System.out.println(bikeNew);
    }
}