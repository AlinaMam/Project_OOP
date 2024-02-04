package org.example.lab2_3_4_5;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        }
    }

    public static void getNamesOfModels(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model car: " + s));
        } else if (vehicle instanceof Bike) {
            String[] namesOfModels = vehicle.getNamesOfModels();
            Arrays.stream(namesOfModels).toList().forEach(s -> System.out.println("Name of model bike: " + s));
        }
    }

    public static void outputVehicle(Vehicle vehicle, OutputStream out) {
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            String brand = car.getBrand();
            int countModels = car.getSizeArrayModels();
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

        }
    }

    public static Vehicle inputCar(InputStream in) {
        Vehicle car = null;
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
//            System.out.println(Arrays.toString(model));

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(((DataInputStream) in).readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();
//            System.out.println(Arrays.toString(price));

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
//            System.out.println(Arrays.toString(model));

            List<Integer> prices = new ArrayList<>();
            while (numPrice > 0) {
                prices.add(((DataInputStream) in).readInt());
                numPrice--;
            }
            int[] price = prices.stream().mapToInt(Integer::intValue).toArray();
//            System.out.println(Arrays.toString(price));

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
        }
    }

    public static Vehicle readCar(Reader in) {
        Vehicle car = null;
        StringBuilder builder = new StringBuilder();
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
        }
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

    public static void serializeVehicle(Vehicle car, Vehicle bike) {
        List<Serializable> objects = new ArrayList<>();
        objects.add((Serializable) car);
        objects.add((Serializable) bike);
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

    public static Car createCar(String brand, int length, Vehicle vehicle) throws NoSuchMethodException {
        Class clazz = null;
        Car car = null;
        clazz = vehicle.getClass();
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (!parameterTypes[0].getSimpleName().equals("String") && !parameterTypes[1].getSimpleName().equals("int")) {
                    return null;
                } else {
                    Class[] catClassParams = {String.class, int.class};
                    try {
                        car = (Car) clazz.getConstructor(catClassParams).newInstance(brand, length);
                        return car;
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {

                    }
                }
            }
        }
        return null;
    }
}
