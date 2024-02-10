package org.example.lab2_3_4_5.vehicle;

import org.example.lab2_3_4_5.exception.DuplicateModelNameException;
import org.example.lab2_3_4_5.Vehicle;
import org.example.lab2_3_4_5.exception.IncorrectModelNameVehicle;
import org.example.lab2_3_4_5.exception.IncorrectPriceVehicle;
import org.example.lab2_3_4_5.exception.ModelPriceOutOfBoundsException;
import org.example.lab2_3_4_5.exception.NoSuchModelNameException;

import java.io.Serializable;
import java.util.*;

public class Quadracycle implements Vehicle, Serializable, Cloneable {
    private String brand;
    private ArrayList<Quadracycle.Model> list;
    private int size;

    public Quadracycle(String brand, int size) {
        this.brand = brand;
        this.size = size;
        list = new ArrayList<>();
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ArrayList<Quadracycle.Model> getList() {
        return list;
    }

    public void setList(ArrayList<Quadracycle.Model> list) {
        this.list = list;
    }

    public void setLength(int size) {
        this.size = size;
    }

    @Override
    public int getLength() {
        return list.size();
    }

    @Override
    public void changeModelName(String oldName, String newName) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(oldName)) {
            throw new NoSuchModelNameException("We don't have this model", oldName);
        }
        for (Quadracycle.Model model : list) {
            if (model.getModelName().equals(oldName)) {
                model.setModelName(newName);
            }
        }
    }

    @Override
    public String[] getNamesOfModels() {
        String[] namesOfModels = list.stream()
                .map(Quadracycle.Model::getModelName)
                .toArray(String[]::new);
        return namesOfModels;
    }

    @Override
    public int getPriceOfModelName(String name) throws NoSuchModelNameException {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        for (Quadracycle.Model model : list) {
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
        for (Quadracycle.Model model : list) {
            if (model.getModelName().equals(name)) {
                model.setPrice(newPrice);
            }
        }
    }

    @Override
    public int[] getPricesOfModels() {
        int[] prices = list.stream()
                .map(Quadracycle.Model::getPrice)
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
        this.setLength(this.getLength());
    }

    @Override
    public void deleteModel(String name) throws NoSuchModelNameException, IncorrectModelNameVehicle {
        List<String> namesList = Arrays.stream(this.getNamesOfModels()).toList();
        if (!namesList.contains(name)) {
            throw new NoSuchModelNameException("We don't have this model", name);
        }
        Iterator<Quadracycle.Model> iterator = list.iterator();
        while (iterator.hasNext()) {
            Model modelQuadracycle = iterator.next();
            if (modelQuadracycle.getModelName().equals(name)) {
                iterator.remove();
            }
        }
        this.setLength(this.getLength());
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Quadracycle:brand= ").append(brand).append(", ").append("Quadracycle:count of models= ").append(size);
        return buffer.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Quadracycle) {
            Quadracycle quadracycle = (Quadracycle) o;
            if (!quadracycle.brand.equals(this.brand) || quadracycle.getLength() != this.getLength()) {
                return false;
            }
            for (int i = 0; i < this.getLength(); i++) {
                if (!quadracycle.list.get(i).getModelName().equals(this.list.get(i).getModelName())) {
                    return false;
                } else if (quadracycle.list.get(i).getPrice() != this.list.get(i).getPrice()) {
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
    public Quadracycle clone() throws CloneNotSupportedException {
        Quadracycle newQuadracycle = (Quadracycle) super.clone();
        ArrayList<Quadracycle.Model> newList = new ArrayList<>();
        for (Model model : list) {
            newList.add(model.clone());
        }
        newQuadracycle.setList(newList);
        return newQuadracycle;
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
            buffer.append("Quadracycle:model= ").append(modelName).append(", ").append("Quadracycle:price= ").append(price);
            return buffer.toString();
        }

        @Override
        public Quadracycle.Model clone() throws CloneNotSupportedException {
            return (Quadracycle.Model) super.clone();
        }
    }
}
