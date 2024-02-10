package org.example.lab2_3_4_5;

import org.example.lab2_3_4_5.exception.DuplicateModelNameException;
import org.example.lab2_3_4_5.exception.IncorrectModelNameVehicle;
import org.example.lab2_3_4_5.exception.IncorrectPriceVehicle;
import org.example.lab2_3_4_5.vehicle.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Util {
    public static double averagePrice(Vehicle vehicle) {
        int[] pricesOfModels = vehicle.getPricesOfModels();
        int result = 0;
        for (int price : pricesOfModels) {
            result += price;
        }
        return result / pricesOfModels.length;
    }

    public static void getNamesOfModels(Vehicle vehicle) {
        String[] namesOfModels = vehicle.getNamesOfModels();
        Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model: " + s));
    }

    public static void outputVehicle(Vehicle vehicle, OutputStream out) {
        DataOutputStream dos = new DataOutputStream(out);
        String brand = vehicle.getBrand();
        int countModels = vehicle.getLength();
        String[] namesOfModels = vehicle.getNamesOfModels();
        int[] pricesOfModels = vehicle.getPricesOfModels();
        try {
            dos.writeUTF(brand);
            dos.writeInt(countModels);
            for (String line : namesOfModels) {
                dos.writeUTF(line);
            }
            for (int price : pricesOfModels) {
                dos.writeInt(price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vehicle inputCar(InputStream in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        DataInputStream dis = new DataInputStream(in);
        Vehicle car = null;
        //пример с использованием DataInputStream
        try {
            String brand = dis.readUTF();
            int countModels = dis.readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(dis.readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(dis.readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            car = new Car(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                car.addNewModel(model[i], price[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return car;
    }

    public static Vehicle inputBike(InputStream in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        DataInputStream dis = new DataInputStream(in);
        Vehicle bike = null;
        try {
            String brand = dis.readUTF();
            int countModels = dis.readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(dis.readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(dis.readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            bike = new Bike(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                bike.addNewModel(model[i], price[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bike;
    }

    public static Vehicle inputScooter(InputStream in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        DataInputStream dis = new DataInputStream(in);
        Vehicle scooter = null;
        try {
            String brand = dis.readUTF();
            int countModels = dis.readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(dis.readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(dis.readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            scooter = new Scooter(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                scooter.addNewModel(model[i], price[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return scooter;
    }

    public static Vehicle inputQuadracycle(InputStream in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        DataInputStream dis = new DataInputStream(in);
        Vehicle quadracycle = null;
        try {
            String brand = dis.readUTF();
            int countModels = dis.readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(dis.readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(dis.readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            quadracycle = new Quadracycle(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                quadracycle.addNewModel(model[i], price[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return quadracycle;
    }

    public static Vehicle inputMoped(InputStream in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        DataInputStream dis = new DataInputStream(in);
        Vehicle moped = null;
        try {
            String brand = dis.readUTF();
            int countModels = dis.readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(dis.readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(dis.readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            moped = new Moped(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                moped.addNewModel(model[i], price[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return moped;
    }


    public static void writeVehicle(Vehicle vehicle, Writer writer) {
        BufferedWriter bw = new BufferedWriter(writer);
        String brand = vehicle.getBrand();
        int countModels = vehicle.getLength();
        String[] namesOfModels = vehicle.getNamesOfModels();
        int[] pricesOfModels = vehicle.getPricesOfModels();
        try {
            bw.write(brand + "\n");
            bw.write(countModels + "\n");
            for (String line : namesOfModels) {
                bw.write(line + "\n");
            }
            for (int price : pricesOfModels) {
                bw.write(price + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vehicle readCar(Scanner scanner) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        //чтение Scanner-ом
        Vehicle car = null;
        try {
            String brand = scanner.next();
            int countModels = scanner.nextInt();
            String[] models = new String[countModels];
            for (int i = 0; i < models.length; i++) {
                models[i] = scanner.next();
            }
            int[] prices = new int[countModels];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = scanner.nextInt();
            }
            car = new Car(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                car.addNewModel(models[i], prices[i]);
            }

        } finally {
            scanner.close();
        }
        return car;
    }

    public static Vehicle readBike(Reader in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        BufferedReader br = new BufferedReader(in);
        Vehicle bike = null;
        try {
            String brand = br.readLine();
            int countModels = Integer.parseInt(br.readLine());
            String[] models = new String[countModels];
            for (int i = 0; i < models.length; i++) {
                models[i] = br.readLine();
            }
            int[] prices = new int[countModels];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(br.readLine());
            }
            bike = new Bike(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                bike.addNewModel(models[i], prices[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bike;
    }

    public static Vehicle readScooter(Reader in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        BufferedReader br = new BufferedReader(in);
        Vehicle scooter = null;
        try {
            String brand = br.readLine();
            int countModels = Integer.parseInt(br.readLine());
            String[] models = new String[countModels];
            for (int i = 0; i < models.length; i++) {
                models[i] = br.readLine();
            }
            int[] prices = new int[countModels];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(br.readLine());
            }
            scooter = new Scooter(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                scooter.addNewModel(models[i], prices[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return scooter;
    }

    public static Vehicle readQuadracycle(Reader in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        BufferedReader br = new BufferedReader(in);
        Vehicle quadracycle = null;
        try {
            String brand = br.readLine();
            int countModels = Integer.parseInt(br.readLine());
            String[] models = new String[countModels];
            for (int i = 0; i < models.length; i++) {
                models[i] = br.readLine();
            }
            int[] prices = new int[countModels];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(br.readLine());
            }
            quadracycle = new Quadracycle(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                quadracycle.addNewModel(models[i], prices[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return quadracycle;
    }

    public static Vehicle readMoped(Reader in) throws DuplicateModelNameException, IncorrectPriceVehicle, IncorrectModelNameVehicle {
        BufferedReader br = new BufferedReader(in);
        Vehicle moped = null;
        try {
            String brand = br.readLine();
            int countModels = Integer.parseInt(br.readLine());
            String[] models = new String[countModels];
            for (int i = 0; i < models.length; i++) {
                models[i] = br.readLine();
            }
            int[] prices = new int[countModels];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(br.readLine());
            }
            moped = new Moped(brand, countModels);
            for (int i = 0; i < countModels; i++) {
                moped.addNewModel(models[i], prices[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return moped;
    }

    public static void serializeVehicle(Vehicle... vehicle) {
        List<Serializable> objects = new ArrayList<>();
        for (int i = 0; i < vehicle.length; i++) {
            objects.add((Serializable) vehicle[i]);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Vehicle deserializeCar() {
        Vehicle car = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            List<Serializable> objects = (List<Serializable>) ois.readObject();
            for (Serializable object : objects) {
                if (object instanceof Car) {
                    car = (Car) object;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return car;
    }

    public static Vehicle deserializeBike() {
        Vehicle bike = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            List<Serializable> objects = (List<Serializable>) ois.readObject();
            for (Serializable object : objects) {
                if (object instanceof Bike) {
                    bike = (Bike) object;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return bike;
    }

    public static Vehicle deserializeScooter() {
        Vehicle scooter = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            List<Serializable> objects = (List<Serializable>) ois.readObject();
            for (Serializable object : objects) {
                if (object instanceof Scooter) {
                    scooter = (Scooter) object;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return scooter;
    }

    public static Vehicle deserializeQuadracycle() {
        Vehicle quadracycle = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            List<Serializable> objects = (List<Serializable>) ois.readObject();
            for (Serializable object : objects) {
                if (object instanceof Quadracycle) {
                    quadracycle = (Quadracycle) object;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return quadracycle;
    }

    public static Vehicle deserializeMoped() {
        Vehicle moped = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            List<Serializable> objects = (List<Serializable>) ois.readObject();
            for (Serializable object : objects) {
                if (object instanceof Moped) {
                    moped = (Moped) object;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return moped;
    }

    public static Vehicle createVehicle(String brand, int length, Vehicle vehicle) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = vehicle.getClass();
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        return (Vehicle) constructor.newInstance(brand, length);
    }
}
