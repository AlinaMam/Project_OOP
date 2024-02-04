package org.example;

import org.example.lab2_3_4_5.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchModelNameException, DuplicateModelNameException, ModelPriceOutOfBoundsException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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
        car.changeModelPrice("i35", 4_700_000);
        Car.Model model1 = car.new Model("i40", 3_800_000);
        Car.Model model2_0 = car.new Model("i55", 3_750_000);
        car.addNewCarModel(model1);
        car.addNewCarModel(model2_0);
        car.deleteModel("i35");
        System.out.println(Arrays.toString(car.getArray()));

        System.out.println("---");

        //Задание №2
        Bike bike = new Bike("BMW", 3);
        Bike.Model model1_0 = bike.new Model("ky10", 1_700_000);
        Bike.Model model2 = bike.new Model("ky11", 1_800_000);
        Bike.Model model3 = bike.new Model("ky12", 1_900_300);
        LinkedList<Bike.Model> list = new LinkedList<>();
        Collections.addAll(list, model1_0, model2, model3);
        bike.setList(list);
        bike.changeModelName("ky10", "ky200");
        bike.changeModelPrice("ky12", 2_000_000);
        Bike.Model model4 = bike.new Model("ky300", 2_700_000);
        Bike.Model model5 = bike.new Model("ky301", 2_900_000);
        bike.addNewBikeModel(model4);
        bike.addNewBikeModel(model5);
        bike.deleteModel("ky11");
        bike.deleteModel("ky301");
        System.out.println(bike.getList());

        System.out.println("---");

        //Задание №5
       /* Util.averagePrice(car);
        Util.averagePrice(bike);
        Util.getNamesOfModels(car);
        Util.getNamesOfModels(bike);*/

        //Лабораторная работа №3
        //Запись в файл (байтовый поток)
       /* OutputStream outCar = null;
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
/*        Writer brCar = null;
        try {
            brCar = new BufferedWriter(new FileWriter("forCar.txt"));
            Util.writeVehicle(car, brCar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Writer brBike = null;
        try {
            brBike = new BufferedWriter(new FileWriter("forBike.txt"));
            Util.writeVehicle(bike, brBike);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Чтение из файла (символьный поток)
        Reader readCar = null;
        try {
            readCar = new BufferedReader(new FileReader("forCar.txt"));
            System.out.println(Util.readCar(readCar));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Reader readBike = null;
        try {
            readBike = new BufferedReader(new FileReader("forBike.txt"));
            System.out.println(Util.readBike(readBike));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        //Сериализация
       /* Util.serializeVehicle(car, bike);

        Vehicle carNew = Util.deserializeCar();
        Vehicle bikeNew = Util.deserializeBike();
        System.out.println(carNew);
        System.out.println(bikeNew);*/

        //Лабораторная работа №4
        //Создадим ещё один car и воспользуемся методами equals и hashcode
        Car car1 = new Car("JAK", 3);
        Car.Model[] arrayModels1 = {
                car1.new Model("i30", 5_000_000),
                car1.new Model("i20", 4_000_000),
                car1.new Model("i10", 3_500_000)
        };
        car1.setArray(arrayModels1);
        System.out.println(Arrays.toString(car1.getArray()));
        car1.changeModelName("i20", "i35");
        car1.changeModelPrice("i35", 4_700_000);
        Car.Model model21 = car.new Model("i40", 3_800_000);
        Car.Model model22 = car.new Model("i55", 3_750_000);
        car1.addNewCarModel(model21);
        car1.addNewCarModel(model22);
        car1.deleteModel("i35");
        System.out.println(Arrays.toString(car.getArray()));

        //Проверка методов equals и hashcode
        System.out.println(car.equals(car1));
        System.out.println(car.hashCode());
        System.out.println(car1.hashCode());

        //Создадим ещё один bike и воспользуемся методами equals и hashcode
        Bike bike1 = new Bike("BMW", 3);
        Bike.Model model31 = bike1.new Model("ky10", 1_700_000);
        Bike.Model model32 = bike1.new Model("ky11", 1_800_000);
        Bike.Model model33 = bike1.new Model("ky12", 1_900_300);
        LinkedList<Bike.Model> list1 = new LinkedList<>();
        Collections.addAll(list1, model31, model32, model33);
        bike1.setList(list1);
        bike1.changeModelName("ky10", "ky200");
        bike1.changeModelPrice("ky12", 2_000_000);
        Bike.Model model34 = bike.new Model("ky300", 2_700_000);
        Bike.Model model35 = bike.new Model("ky301", 2_900_000);
        bike1.addNewBikeModel(model34);
        bike1.addNewBikeModel(model35);
        bike1.deleteModel("ky11");
        bike1.deleteModel("ky301");
        System.out.println(bike1.getList());

        System.out.println(bike.equals(bike1));
        System.out.println(bike.hashCode());
        System.out.println(bike1.hashCode());

        System.out.println("---");

        //Лабораторная работа №5
        //Задание №1

        for (int i = 0; i < args.length; i++) {
            Class clazz = Class.forName(args[0]);
            Method method = clazz.getDeclaredMethod("changeModelPrice", String.class, int.class);
            method.invoke(car, "i55", 2_240_000);
        }
        System.out.println(car.getBrand());
        System.out.println(Arrays.toString(car.getNamesOfModels()));
        System.out.println(Arrays.toString(car.getPricesOfModels()));

        System.out.println("---");

        //Задание №2
        Car kia = Util.createCar("KIA", 2, car);
        System.out.println(kia);

        //Задание №3
        Scooter scooter = new Scooter("Vespa", 2);
        Map<String, Integer> map = new HashMap<>();
        Scooter.Model modelS1 = scooter.new Model("Primavera", 1_900_000);
        Scooter.Model modelS2 = scooter.new Model("Sprint", 1_900_000);
        Scooter.Model modelS3 = scooter.new Model("GTV", 2_100_000);
        map.put(modelS1.getModelName(), modelS1.getPrice());
        map.put(modelS2.getModelName(), modelS2.getPrice());
        scooter.setMap(map);
        scooter.addNewScooterModel(modelS3);
        scooter.deleteModel("GTV");
        System.out.println(scooter.getSize());




//        System.out.println(scooter.getPriceOfModelName("GTV"));
//        scooter.changeModelPrice("Primavera", 2_200_000);
    }
}