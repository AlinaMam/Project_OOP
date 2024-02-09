package org.example.lab2_3_4_5.exception;

public class IncorrectPriceVehicle extends Exception {
    private int price;

    public int getPrice() {
        return price;
    }

    public IncorrectPriceVehicle(String message, int price) {
        super(message);
        this.price = price;
    }
}
