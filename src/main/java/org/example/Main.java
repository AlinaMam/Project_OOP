package org.example;

import org.example.MyFirstPackage.MySecondClass;

public class Main {
    public static void main(String[] args) {
        MySecondClass mySecondClass = new MySecondClass();
        mySecondClass.changeElement(1, 100);
        System.out.println(mySecondClass.average());
        mySecondClass.printArray();
    }
}