package org.example.lab2_3_4_5.exception;

public class IncorrectModelNameVehicle extends Exception{
    private String nameModel;

    public String getNameModel() {
        return nameModel;
    }

    public IncorrectModelNameVehicle(String message, String nameModel) {
        super(message);
        this.nameModel = nameModel;
    }
}
