package org.example.lab2;

public interface Vehicle {
    void changeModelName(String oldName, String newName) throws NoSuchModelNameException;

    String[] getNamesOfModels();

    int getPriceOfModelName(String name) throws NoSuchModelNameException;

    void changeModelPrice(String name, int newPrice) throws ModelPriceOutOfBoundsException, NoSuchModelNameException;

    int[] getPricesOfModels();

    default void addNewCarModel(Car.Model model) throws DuplicateModelNameException {

    }

    default void addNewBikeModel(Bike.Model model) throws DuplicateModelNameException {

    }

    void deleteModel(String name) throws NoSuchModelNameException;
}
