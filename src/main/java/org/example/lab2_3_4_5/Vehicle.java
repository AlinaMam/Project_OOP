package org.example.lab2_3_4_5;

import org.example.lab2_3_4_5.exception.*;

public interface Vehicle {
    void changeModelName(String oldName, String newName) throws NoSuchModelNameException;

    String[] getNamesOfModels();

    int getPriceOfModelName(String name) throws NoSuchModelNameException;

    void changeModelPrice(String name, int newPrice) throws ModelPriceOutOfBoundsException, NoSuchModelNameException;

    int[] getPricesOfModels();

    void addNewModel(String name, int price) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle;

    void deleteModel(String name) throws NoSuchModelNameException, IncorrectModelNameVehicle;

}
