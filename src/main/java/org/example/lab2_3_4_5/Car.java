package org.example.lab2_3_4_5;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Car implements Vehicle, Serializable, Cloneable {
    private String brand;
    private Model[] array;
    private int length;

    public Car(String brand, int length) {
        this.brand = brand;
        this.length = length;
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
        if (this.getLength() != array.length) {
            System.out.println("Array length is incorrect");
        } else {
            this.array = array;
        }
    }

    public int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public int getSizeArrayModels() {
        return this.getArray().length;
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
        String[] namesOfModels = Arrays.stream(array)
                .map(Car.Model::getModelName)
                .toArray(String[]::new);
        return namesOfModels;
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
        int[] prices = Arrays.stream(array)
                .map(Model::getPrice)
                .mapToInt(Integer::intValue)
                .toArray();
        return prices;
    }


    public void addNewCarModel(Car.Model model) throws DuplicateModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (namesList.contains(model.getModelName())) {
            throw new DuplicateModelNameException("We already have this model", model.getModelName());
        }
        Model[] models = Arrays.copyOf(array, array.length + 1);
        models[models.length - 1] = model;
        this.setLength(this.getLength() + 1);
        this.setArray(models);
    }

    public void deleteModel(String name) throws NoSuchModelNameException {
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
        this.setLength(this.getLength() - 1);
        this.setArray(newArray);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Car:brand= ").append(brand).append(", ").append("Car:count of models= ").append(length);
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Vehicle) {
            Car car = (Car) o;
            return Objects.equals(brand, car.brand) && Arrays.equals(getNamesOfModels(), car.getNamesOfModels())
                    && Arrays.equals(getPricesOfModels(), car.getPricesOfModels());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(brand);
        result = 31 * result + Arrays.hashCode(getNamesOfModels()) + Arrays.hashCode(getPricesOfModels());
        return result;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
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
        public Car.Model clone() throws CloneNotSupportedException {
            return (Car.Model) super.clone();
        }
    }
}
