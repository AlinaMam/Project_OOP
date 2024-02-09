package org.example.lab2_3_4_5;

import org.example.lab2_3_4_5.vehicle.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Util {
    public static void averagePrice(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            int[] pricesOfModels = vehicle.getPricesOfModels();
            double avgPriceCar = Arrays.stream(pricesOfModels)
                    .average()
                    .getAsDouble();
            MathContext context = new MathContext(9, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(avgPriceCar, context);
            System.out.println("Average price of car: " + result);

        } else if (vehicle instanceof Bike) {
            int[] pricesOfModels = vehicle.getPricesOfModels();
            double avgPriceCar = Arrays.stream(pricesOfModels)
                    .average()
                    .getAsDouble();
            MathContext context = new MathContext(9, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(avgPriceCar, context);
            System.out.println("Average price of bike: " + result);

        } else if (vehicle instanceof Scooter) {
            int[] pricesOfModels = vehicle.getPricesOfModels();
            double avgPriceScooter = Arrays.stream(pricesOfModels)
                    .average()
                    .getAsDouble();
            MathContext context = new MathContext(9, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(avgPriceScooter, context);
            System.out.println("Average price of scooter: " + result);

        } else if (vehicle instanceof Quadracycle) {
            int[] pricesOfModels = vehicle.getPricesOfModels();
            double avgPriceScooter = Arrays.stream(pricesOfModels)
                    .average()
                    .getAsDouble();
            MathContext context = new MathContext(9, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(avgPriceScooter, context);
            System.out.println("Average price of quadracycle: " + result);

        } else if (vehicle instanceof Moped) {
            int[] pricesOfModels = vehicle.getPricesOfModels();
            double avgPriceScooter = Arrays.stream(pricesOfModels)
                    .average()
                    .getAsDouble();
            MathContext context = new MathContext(9, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(avgPriceScooter, context);
            System.out.println("Average price of moped: " + result);
        }
    }

    public static void getNamesOfModels(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model car: " + s));
        } else if (vehicle instanceof Bike) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model bike: " + s));
        } else if (vehicle instanceof Scooter) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model scooter: " + s));
        } else if (vehicle instanceof Quadracycle) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model quadracycle: " + s));
        } else if (vehicle instanceof Moped) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model moped: " + s));
        }
    }

    public static void outputVehicle(Vehicle vehicle, OutputStream out) {
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            String brand = car.getBrand();
            int countModels = car.getLengthArray();
            String[] namesOfModels = car.getNamesOfModels();
            int[] pricesOfModels = car.getPricesOfModels();
            try {
                ((DataOutputStream) out).writeUTF(brand);
                ((DataOutputStream) out).writeInt(countModels);
                for (String line : namesOfModels) {
                    ((DataOutputStream) out).writeUTF(line);
                }
                for (int price : pricesOfModels) {
                    ((DataOutputStream) out).writeInt(price);
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
        } else if (vehicle instanceof Bike) {
            Bike bike = (Bike) vehicle;
            String brand = bike.getBrand();
            int countModels = bike.getSizeLinkedList();
            String[] namesOfModels = bike.getNamesOfModels();
            int[] pricesOfModels = bike.getPricesOfModels();
            try {
                ((DataOutputStream) out).writeUTF(brand);
                ((DataOutputStream) out).writeInt(countModels);
                for (String line : namesOfModels) {
                    ((DataOutputStream) out).writeUTF(line);
                }
                for (int price : pricesOfModels) {
                    ((DataOutputStream) out).writeInt(price);
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
        } else if (vehicle instanceof Scooter) {
            Scooter scooter = (Scooter) vehicle;
            String brand = scooter.getBrand();
            int countModels = scooter.getSizeHashMap();
            String[] namesOfModels = scooter.getNamesOfModels();
            int[] pricesOfModels = scooter.getPricesOfModels();
            try {
                ((DataOutputStream) out).writeUTF(brand);
                ((DataOutputStream) out).writeInt(countModels);
                for (String line : namesOfModels) {
                    ((DataOutputStream) out).writeUTF(line);
                }
                for (int price : pricesOfModels) {
                    ((DataOutputStream) out).writeInt(price);
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
        } else if (vehicle instanceof Quadracycle) {
            Quadracycle quadracycle = (Quadracycle) vehicle;
            String brand = quadracycle.getBrand();
            int countModels = quadracycle.getSizeArrayList();
            String[] namesOfModels = quadracycle.getNamesOfModels();
            int[] pricesOfModels = quadracycle.getPricesOfModels();
            try {
                ((DataOutputStream) out).writeUTF(brand);
                ((DataOutputStream) out).writeInt(countModels);
                for (String line : namesOfModels) {
                    ((DataOutputStream) out).writeUTF(line);
                }
                for (int price : pricesOfModels) {
                    ((DataOutputStream) out).writeInt(price);
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
        } else if (vehicle instanceof Moped) {
            Moped moped = (Moped) vehicle;
            String brand = moped.getBrand();
            int countModels = moped.getSizeLinkedList();
            String[] namesOfModels = moped.getNamesOfModels();
            int[] pricesOfModels = moped.getPricesOfModels();
            try {
                ((DataOutputStream) out).writeUTF(brand);
                ((DataOutputStream) out).writeInt(countModels);
                for (String line : namesOfModels) {
                    ((DataOutputStream) out).writeUTF(line);
                }
                for (int price : pricesOfModels) {
                    ((DataOutputStream) out).writeInt(price);
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
    }

    public static Vehicle inputCar(InputStream in) {
        Vehicle car = null;
        //пример с использованием DataInputStream
        try {
            String brand = ((DataInputStream) in).readUTF();
            int countModels = ((DataInputStream) in).readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(((DataInputStream) in).readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(((DataInputStream) in).readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            car = new Car(brand, countModels);

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

    public static Vehicle inputBike(InputStream in) {
        Vehicle bike = null;
        try {
            String brand = ((DataInputStream) in).readUTF();
            int countModels = ((DataInputStream) in).readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(((DataInputStream) in).readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(((DataInputStream) in).readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            bike = new Bike(brand, countModels);

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

    public static Vehicle inputScooter(InputStream in) {
        Vehicle scooter = null;
        try {
            String brand = ((DataInputStream) in).readUTF();
            int countModels = ((DataInputStream) in).readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(((DataInputStream) in).readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(((DataInputStream) in).readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            scooter = new Scooter(brand, countModels);

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

    public static Vehicle inputQuadracycle(InputStream in) {
        Vehicle quadracycle = null;
        try {
            String brand = ((DataInputStream) in).readUTF();
            int countModels = ((DataInputStream) in).readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(((DataInputStream) in).readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(((DataInputStream) in).readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            quadracycle = new Quadracycle(brand, countModels);

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

    public static Vehicle inputMoped(InputStream in) {
        Vehicle moped = null;
        try {
            String brand = ((DataInputStream) in).readUTF();
            int countModels = ((DataInputStream) in).readInt();
            int numModels = countModels;
            int numPrice = countModels;
            List<String> models = new ArrayList<>();
            while (numModels > 0) {
                models.add(((DataInputStream) in).readUTF());
                numModels--;
            }
            String[] model = models.stream().toArray(String[]::new);

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(((DataInputStream) in).readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();

            moped = new Moped(brand, countModels);

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


    public static void writeVehicle(Vehicle vehicle, Writer out) {
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            String brand = car.getBrand();
            int countModels = car.getSizeArrayModels();
            String[] namesOfModels = car.getNamesOfModels();
            int[] pricesOfModels = car.getPricesOfModels();
            try {
                out.write(brand + "\n");
                out.write(countModels + "\n");
                for (String line : namesOfModels) {
                    out.write(line + "\n");
                }
                for (int price : pricesOfModels) {
                    out.write(price + "\n");
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
        } else if (vehicle instanceof Bike) {
            Bike bike = (Bike) vehicle;
            String brand = bike.getBrand();
            int countModels = bike.getSizeLinkedList();
            String[] namesOfModels = bike.getNamesOfModels();
            int[] pricesOfModels = bike.getPricesOfModels();
            try {
                out.write(brand + "\n");
                out.write(countModels + "\n");
                for (String line : namesOfModels) {
                    out.write(line + "\n");
                }
                for (int price : pricesOfModels) {
                    out.write(price + "\n");
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
        } else if (vehicle instanceof Scooter) {
            Scooter scooter = (Scooter) vehicle;
            String brand = scooter.getBrand();
            int countModels = scooter.getSizeHashMap();
            String[] namesOfModels = scooter.getNamesOfModels();
            int[] pricesOfModels = scooter.getPricesOfModels();
            try {
                out.write(brand + "\n");
                out.write(countModels + "\n");
                for (String line : namesOfModels) {
                    out.write(line + "\n");
                }
                for (int price : pricesOfModels) {
                    out.write(price + "\n");
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
        } else if (vehicle instanceof Quadracycle) {
            Quadracycle quadracycle = (Quadracycle) vehicle;
            String brand = quadracycle.getBrand();
            int countModels = quadracycle.getSizeArrayList();
            String[] namesOfModels = quadracycle.getNamesOfModels();
            int[] pricesOfModels = quadracycle.getPricesOfModels();
            try {
                out.write(brand + "\n");
                out.write(countModels + "\n");
                for (String line : namesOfModels) {
                    out.write(line + "\n");
                }
                for (int price : pricesOfModels) {
                    out.write(price + "\n");
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
        } else if (vehicle instanceof Moped) {
            Moped moped = (Moped) vehicle;
            String brand = moped.getBrand();
            int countModels = moped.getSizeLinkedList();
            String[] namesOfModels = moped.getNamesOfModels();
            int[] pricesOfModels = moped.getPricesOfModels();
            try {
                out.write(brand + "\n");
                out.write(countModels + "\n");
                for (String line : namesOfModels) {
                    out.write(line + "\n");
                }
                for (int price : pricesOfModels) {
                    out.write(price + "\n");
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
    }

    public static Vehicle readCar(Scanner scanner) {
        //чтение Scanner-ом
        Vehicle car = null;
        try {
            String brand = scanner.next();
            int countModels = scanner.nextInt();
            car = new Car(brand, countModels);
        } finally {
            scanner.close();
        }
        //чтение BufferedReader-ом
       /* StringBuilder builder = new StringBuilder();
        try {
            int num;
            while ((num = in.read()) != -1) {
                builder.append((char) num);
            }
            String line = new String(builder);
            String[] buffer = line.split("\n");
            for (int i = 0; i < buffer.length; i++) {
                car = new Car(buffer[0], Integer.parseInt(buffer[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return car;
    }

    public static Vehicle readBike(Reader in) {
        Vehicle bike = null;
        StringBuilder builder = new StringBuilder();
        try {
            int num;
            while ((num = in.read()) != -1) {
                builder.append((char) num);
            }
            String line = new String(builder);
            String[] buffer = line.split("\n");
            for (int i = 0; i < buffer.length; i++) {
                bike = new Bike(buffer[0], Integer.parseInt(buffer[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bike;
    }

    public static Vehicle readScooter(Reader in) {
        Vehicle scooter = null;
        StringBuilder builder = new StringBuilder();
        try {
            int num;
            while ((num = in.read()) != -1) {
                builder.append((char) num);
            }
            String line = new String(builder);
            String[] buffer = line.split("\n");
            for (int i = 0; i < buffer.length; i++) {
                scooter = new Scooter(buffer[0], Integer.parseInt(buffer[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scooter;
    }

    public static Vehicle readQuadracycle(Reader in) {
        Vehicle quadracycle = null;
        StringBuilder builder = new StringBuilder();
        try {
            int num;
            while ((num = in.read()) != -1) {
                builder.append((char) num);
            }
            String line = new String(builder);
            String[] buffer = line.split("\n");
            for (int i = 0; i < buffer.length; i++) {
                quadracycle = new Quadracycle(buffer[0], Integer.parseInt(buffer[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quadracycle;
    }

    public static Vehicle readMoped(Reader in) {
        Vehicle moped = null;
        StringBuilder builder = new StringBuilder();
        try {
            int num;
            while ((num = in.read()) != -1) {
                builder.append((char) num);
            }
            String line = new String(builder);
            String[] buffer = line.split("\n");
            for (int i = 0; i < buffer.length; i++) {
                moped = new Moped(buffer[0], Integer.parseInt(buffer[1]));
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
