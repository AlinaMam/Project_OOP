package org.example.MyFirstPackage;

import java.util.Arrays;
import java.util.Random;

public class MySecondClass {
    public int[] buffer;

    public MySecondClass() {
        buffer = new int[7];
        Random random = new Random();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = random.nextInt(11);
        }
    }

    public void getElement(int index) {
        if (buffer.length == 0) {
            System.out.println("Массив пустой");
        } else {
            if (index >= buffer.length || index < 0) {
                System.out.println("Укажите индекс в пределах от 0 до " + (buffer.length - 1) + " включительно");
            } else {
                System.out.println(buffer[index]);
            }
        }
    }

    public void changeElement(int index, int num) {
        if (buffer.length == 0) {
            System.out.println("Массив пустой");
        } else {
            if (index >= buffer.length || index < 0) {
                System.out.println("Укажите индекс в пределах от 0 до " + (buffer.length - 1) + " включительно");
            } else {
                buffer[index] = num;
                System.out.println(Arrays.toString(buffer));
            }
        }
    }

    public double average() {
        if (buffer.length == 0) {
            System.out.println("Массив пустой");
        }
        int sum = 0;
        for (int i = 0; i < buffer.length; i++) {
            sum += buffer[i];
        }
<<<<<<< HEAD
        double result = (double) sum/ buffer.length;
=======
        double result = (double) sum / buffer.length;
>>>>>>> 7e08421 (Лабораторная работа №1)
        return result;
    }

    public void printArray() {
        for (int num : buffer) {
            System.out.println(num);
        }
    }
}
