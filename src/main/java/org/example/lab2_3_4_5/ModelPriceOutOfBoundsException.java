package org.example.lab2_3_4_5;

public class ModelPriceOutOfBoundsException extends Exception {
    private int price;

    public int getPrice() {
        return price;
    }

    public ModelPriceOutOfBoundsException(String message, int price) {
        super(message);
        this.price = price;
    }
}
