package org.example.lab2_3_4_5.vehicle;

import org.example.lab2_3_4_5.exception.DuplicateModelNameException;
import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.exception.IncorrectModelNameVehicle;
import org.example.lab2_3_4_5.exception.IncorrectPriceVehicle;
import org.example.lab2_3_4_5.exception.ModelPriceOutOfBoundsException;
import org.example.lab2_3_4_5.exception.NoSuchModelNameException;

import java.io.Serializable;
import java.util.*;

public class Scooter implements Vehicle, Serializable, Cloneable {
    private String brand;
    private Map<String, Integer> map;
    private int size;

    public Scooter(String brand, int size) {
        this.brand = brand;
        this.size = size;
        map = new HashMap<>();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSizeHashMap() {
        return map.size();
    }

    @Override
    public void changeModelName(String oldName, String newName) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(oldName)) {
            throw new NoSuchModelNameException("We don't have this model", oldName);
        }
        Map<String, Integer> mapClone = new HashMap<>(map);
        for (var pair : mapClone.entrySet()) {
            if (pair.getKey().equals(oldName)) {
                map.remove(pair.getKey());
                map.put(newName, pair.getValue());
            }
        }
    }

    @Override
    public String[] getNamesOfModels() {
        String[] namesOfModels = map.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
        return namesOfModels;
    }

    @Override
    public int getPriceOfModelName(String name) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        Integer price = map.entrySet()
                .stream()
                .filter(pair -> pair.getKey().equals(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .get();
        return price;
    }

    @Override
    public void changeModelPrice(String name, int newPrice) throws ModelPriceOutOfBoundsException, NoSuchModelNameException {
        if (newPrice <= 0) {
            throw new ModelPriceOutOfBoundsException("Price must be more than zero", newPrice);
        }
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        for (var pair : map.entrySet()) {
            if (pair.getKey().equals(name)) {
                pair.setValue(newPrice);
            }
        }
    }

    @Override
    public int[] getPricesOfModels() {
        int[] prices = map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .mapToInt(Integer::intValue)
                .toArray();
        return prices;
    }

    @Override
    public void addNewModel(String name, int price) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        if (price <= 0) {
            throw new IncorrectPriceVehicle("Price is les 0 equal 0", price);
        } else if (name.equals(" ")) {
            throw new IncorrectModelNameVehicle("Model name is empty o null", name);
        }
        for (var pair : this.map.entrySet()) {
            if (pair.getKey().equals(name)) {
                throw new DuplicateModelNameException("We already have this model", name);
            }
        }
        map.put(name, price);
        this.setSize(this.getSizeHashMap());
    }

    @Override
    public void deleteModel(String name) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        Map<String, Integer> mapClone = new HashMap<>(map);
        for (var pair : mapClone.entrySet()) {
            if (pair.getKey().equals(name)) {
                map.remove(pair.getKey());
            }
        }
        this.setSize(this.getSizeHashMap());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Scooter) {
            Scooter scooter = (Scooter) o;
            if (!scooter.brand.equals(this.brand) || scooter.getSizeHashMap() != this.getSizeHashMap()) {
                return false;
            } else return scooter.map.equals(this.map);
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
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Scooter:brand= ").append(brand).append(", ").append("Scooter:count of models= ").append(size);
        return buffer.toString();
    }

    @Override
    public Scooter clone() throws CloneNotSupportedException {
        Scooter newScooter = (Scooter) super.clone();
        Map<String, Integer> newMap = new HashMap<>(this.map);
        newScooter.setMap(newMap);
        return newScooter;
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

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Scooter:model= ").append(modelName).append(", ").append("Scooter:price= ").append(price);
            return buffer.toString();
        }
        @Override
        public Scooter.Model clone() throws CloneNotSupportedException {
            return (Scooter.Model) super.clone();
        }
    }
}
