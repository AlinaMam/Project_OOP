package org.example;

import org.example.lab2.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchModelNameException, DuplicateModelNameException, ModelPriceOutOfBoundsException {
        /*//Лабораторная №1
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
        car.addNewCarModel(model1);
        System.out.println(Arrays.toString(car.getArray()));
        car.deleteModel("i35");
        System.out.println(Arrays.toString(car.getArray()));
        System.out.println(car.getSizeArrayModels());

        //Задание №2
        Bike bike = new Bike("BMW");
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
        bike.addNewBikeModel(model4);
        System.out.println(bike.getList());
        bike.deleteModel("ky11");
        System.out.println(bike.getList());
        System.out.println(bike.getSizeLinkedList());

        //Задание №5
        Util.averagePrice(car);
        Util.averagePrice(bike);
        Util.getNamesOfModels(car);
        Util.getNamesOfModels(bike);
    }
}