package org.example.lab2_3_4;

import java.io.Serializable;
import java.util.*;

public class Bike implements Vehicle, Serializable, Cloneable {
    private String brand;
    private LinkedList<Bike.Model> list;
    private int size;

    public Bike(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LinkedList<Model> getList() {
        return list;
    }

    public void setList(LinkedList<Bike.Model> list) {
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;

    }

    public void changeModelName(String oldName, String newName) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(oldName)) {
            throw new NoSuchModelNameException("We don't have this model", oldName);
        }
        for (Bike.Model model : list) {
            if (model.getModelName().equals(oldName)) {
                model.setModelName(newName);
            }
        }
    }

    public String[] getNamesOfModels() {
        String[] namesOfModels = list.stream()
                .map(Bike.Model::getModelName)
                .toArray(String[]::new);
        return namesOfModels;
    }

    public int getPriceOfModelName(String name) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        for (Bike.Model model : list) {
            if (model.getModelName().equals(name)) {
                return model.getPrice();
            }
        }
        return 0;
    }

    public void changeModelPrice(String name, int newPrice) throws ModelPriceOutOfBoundsException, NoSuchModelNameException {
        if (newPrice <= 0) {
            throw new ModelPriceOutOfBoundsException("Price must be more than zero", newPrice);
        }
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        for (Bike.Model model : list) {
            if (model.getModelName().equals(name)) {
                model.setPrice(newPrice);
            }
        }
    }

    public int[] getPricesOfModels() {
        int[] prices = list.stream()
                .map(Bike.Model::getPrice)
                .mapToInt(Integer::intValue)
                .toArray();
        return prices;
    }

    public void addNewBikeModel(Bike.Model model) throws DuplicateModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (namesList.contains(model.getModelName())) {
            throw new DuplicateModelNameException("We already have this model", model.getModelName());
        }
        list.add(model);
        this.setSize(this.getSizeLinkedList());
    }

    public void deleteModel(String name) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        Iterator<Bike.Model> iterator = list.iterator();
        while (iterator.hasNext()) {
            Bike.Model modelBike = iterator.next();
            if (modelBike.getModelName().equals(name)) {
                iterator.remove();
            }
        }
        this.setSize(this.getSizeLinkedList());
    }

    public int getSizeLinkedList() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Bike:brand= ").append(brand).append(", ").append("Bike:count of models= ").append(size);
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Vehicle) {
            Bike bike = (Bike) o;
            return Objects.equals(brand, bike.brand) && Arrays.equals(getNamesOfModels(), bike.getNamesOfModels())
                    && Arrays.equals(getPricesOfModels(), bike.getPricesOfModels());
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
    public Bike clone() throws CloneNotSupportedException {
        return (Bike) super.clone();
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
            buffer.append("Bike:model= ").append(modelName).append(", ").append("Bike:price= ").append(price);
            return buffer.toString();
        }

        @Override
        public Bike.Model clone() throws CloneNotSupportedException {
            return (Bike.Model) super.clone();
        }
    }
}

