package org.example.lab2_3_4_5.vehicle;

import org.example.lab2_3_4_5.exception.DuplicateModelNameException;
import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.exception.IncorrectModelNameVehicle;
import org.example.lab2_3_4_5.exception.IncorrectPriceVehicle;
import org.example.lab2_3_4_5.exception.ModelPriceOutOfBoundsException;
import org.example.lab2_3_4_5.exception.NoSuchModelNameException;

import java.io.Serializable;
import java.util.*;

public class Moped implements Vehicle, Serializable, Cloneable {
    private String brand;
    private LinkedList<Moped.Model> list;
    private int size;

    public Moped(String brand, int size) {
        this.brand = brand;
        this.size = size;
        list = new LinkedList<>();
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

    public void setList(LinkedList<Model> list) {
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSizeLinkedList() {
        return list.size();
    }

    @Override
    public void changeModelName(String oldName, String newName) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(oldName)) {
            throw new NoSuchModelNameException("We don't have this model", oldName);
        }
        for (Model model : list) {
            if (model.getModelName().equals(oldName)) {
                model.setModelName(newName);
            }
        }
    }

    @Override
    public String[] getNamesOfModels() {
        String[] namesOfModels = list.stream()
                .map(Moped.Model::getModelName)
                .toArray(String[]::new);
        return namesOfModels;
    }

    @Override
    public int getPriceOfModelName(String name) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        for (Model model : list) {
            if (model.getModelName().equals(name)) {
                return model.getPrice();
            }
        }
        return 0;
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
        for (Model model : list) {
            if (model.getModelName().equals(name)) {
                model.setPrice(newPrice);
            }
        }
    }

    @Override
    public int[] getPricesOfModels() {
        int[] prices = list.stream()
                .map(Model::getPrice)
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

        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getModelName().equals(name)) {
                throw new DuplicateModelNameException("We already have this model", name);
            }
        }
        Model model = new Model(name, price);
        this.list.add(model);
        this.setSize(this.getSizeLinkedList());
    }

    @Override
    public void deleteModel(String name) throws NoSuchModelNameException, IncorrectModelNameVehicle {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        Iterator<Moped.Model> iterator = list.iterator();
        while (iterator.hasNext()) {
            Model modelBike = iterator.next();
            if (modelBike.getModelName().equals(name)) {
                iterator.remove();
            }
        }
        this.setSize(this.getSizeLinkedList());
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Moped:brand= ").append(brand).append(", ").append("Moped:count of models= ").append(size);
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Moped) {
            Moped moped = (Moped) o;
            if (!moped.brand.equals(this.brand) || moped.getSizeLinkedList() != this.getSizeLinkedList()) {
                return false;
            }
            for (int i = 0; i < this.getSizeLinkedList(); i++) {
                if (!moped.list.get(i).getModelName().equals(this.list.get(i).getModelName())) {
                    return false;
                } else if (moped.list.get(i).getPrice() != this.list.get(i).getPrice()) {
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
    public Moped clone() throws CloneNotSupportedException {
        Moped newMoped = (Moped) super.clone();
        LinkedList<Moped.Model> newList = new LinkedList<>();
        for (Model model : list) {
            newList.add(model.clone());
        }
        newMoped.setList(newList);
        return newMoped;
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
            buffer.append("Moped:model= ").append(modelName).append(", ").append("Moped:price= ").append(price);
            return buffer.toString();
        }

        @Override
        public Moped.Model clone() throws CloneNotSupportedException {
            return (Moped.Model) super.clone();
        }
    }
}
