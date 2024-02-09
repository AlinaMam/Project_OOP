package org.example.lab2_3_4_5.vehicle;

import org.example.lab2_3_4_5.exception.DuplicateModelNameException;
import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.exception.IncorrectModelNameVehicle;
import org.example.lab2_3_4_5.exception.IncorrectPriceVehicle;
import org.example.lab2_3_4_5.exception.ModelPriceOutOfBoundsException;
import org.example.lab2_3_4_5.exception.NoSuchModelNameException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Car implements Vehicle, Serializable, Cloneable {
    private String brand;
    private Model[] array;
    private int lengthArray;

    public Car(String brand, int lengthArray) {
        this.brand = brand;
        lengthArray = 1;
        this.lengthArray = lengthArray;
        array = new Model[lengthArray];
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Model[] getArray() {
        return array;
    }

    public void setArray(Model[] array) {
        this.array = array;
    }

    public int getLengthArray() {
        return lengthArray;
    }

    private void setLengthArray(int lengthArray) {
        this.lengthArray = lengthArray;
    }

    public int getSizeArrayModels() {
        return this.array.length;
    }


    public void changeModelName(String oldName, String newName) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(oldName)) {
            throw new NoSuchModelNameException("We don't have this model", oldName);
        }
        for (Car.Model model : array) {
            if (model.getModelName().equals(oldName)) {
                model.setModelName(newName);
            }
        }
    }

    public String[] getNamesOfModels() {
        String[] namesModels = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                namesModels[i] = array[i].getModelName();
            }
        }
        return namesModels;
    }

    public int getPriceOfModelName(String name) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        for (Car.Model model : array) {
            if (model.getModelName().equals(name)) {
                return model.getPrice();
            }
        }
        return 0;
    }

    public void changeModelPrice(String name, int newPrice) throws NoSuchModelNameException, ModelPriceOutOfBoundsException {
        if (newPrice <= 0) {
            throw new ModelPriceOutOfBoundsException("Price must be more than zero", newPrice);
        }
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        for (Model model : array) {
            if (model.getModelName().equals(name)) {
                model.setPrice(newPrice);
            }
        }
    }

    public int[] getPricesOfModels() {
        int[] pricesModels = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                pricesModels[i] = array[i].getPrice();
            }
        }
        return pricesModels;
    }

    public void addNewModel(String name, int price) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        if (price <= 0) {
            throw new IncorrectPriceVehicle("Price is les 0 equal 0", price);
        } else if (name.equals(" ")) {
            throw new IncorrectModelNameVehicle("Model name is empty o null", name);
        }

        if (this.array[0] == null) {
            Model model = new Model(name, price);
            this.array[0] = model;
            return;
        } else {
            for (int i = 0; i < this.array.length; i++) {
                if (this.array[i].getModelName().equals(name)) {
                    throw new DuplicateModelNameException("We already have this model", name);
                }
            }
        }
        array = Arrays.copyOf(array, array.length + 1);
        Model model = new Model(name, price);
        array[array.length - 1] = model;
        this.setLengthArray(this.getSizeArrayModels());
    }

    public void deleteModel(String name) throws NoSuchModelNameException, IncorrectModelNameVehicle {
        if (name.equals(" ")) {
            throw new IncorrectModelNameVehicle("Model name is empty o null", name);
        }
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getModelName().equals(name)) {
                index = i;
            }
        }
        Model[] newArray = new Model[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - 1 - index);
        lengthArray = lengthArray - 1;
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Car:brand= ").append(brand).append(", ").append("Car:count of models= ").append(array.length);
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Car) {
            Car car = (Car) o;
            if (!car.getBrand().equals(this.getBrand()) || car.getSizeArrayModels() != this.getSizeArrayModels()) {
                return false;
            }
            for (int i = 0; i < this.getSizeArrayModels(); i++) {
                if (!car.array[i].getModelName().equals(this.array[i].getModelName())) {
                    return false;
                } else if (car.getArray()[i].getPrice() != this.getArray()[i].getPrice()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(brand);
        result = 31 * result + Arrays.hashCode(getNamesOfModels()) + Arrays.hashCode(getPricesOfModels());
        return result;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car newCar = (Car) super.clone();
        Model[] newArray = new Model[this.array.length];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i].clone();
        }
        newCar.setArray(newArray);
        return newCar;
    }

    public class Model implements Serializable, Cloneable {
        private String modelName;
        private int price;

        public Model(String modelName, int price) {
            this.modelName = modelName;
            this.price = price;
        }

        public String getModelName() {
            return modelName;
        }

        public int getPrice() {
            return price;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Car:model= ").append(modelName).append(", ").append("Car:price= ").append(price);
            return buffer.toString();
        }

        @Override
        public Model clone() throws CloneNotSupportedException {
            return (Model) super.clone();
        }
    }
}
