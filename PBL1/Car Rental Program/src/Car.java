import java.util.*;
import java.io.*;

public class Car {
    private static final Scanner scanner = new Scanner(System.in);
    public static final ArrayList<Car> cars = new ArrayList<>();

    String brand, type, id;
    boolean isAvailable;
    double dailyRate;

    // constructor
    Car(String brand, String type, String id, boolean isAvailable, double dailyRate) {
        this.brand = brand;
        this.type = type;
        this.id = id;
        this.isAvailable = isAvailable;
        this.dailyRate = dailyRate;
    }

    // setters
    public void setBrand(String brand) {this.brand = brand;}
    public void setType(String type) {this.type = type;}
    public void setId(String id) {this.id = id;}
    public void setIsAvailable(boolean isAvailable) {this.isAvailable =isAvailable;}
    public void setDailyRate(double dailyRate) {this.dailyRate = dailyRate;}

    // getters
    public String getBrand() {return brand;}
    public String getType() {return type;}
    public String getId() {return id;}
    public boolean getIsAvailable() {return isAvailable;}
    public double getDailyRate() {return dailyRate;}

    // private functions
    private static Set<String> generatedIds = new HashSet<>();
    private static Random random = new Random();
    private static String generateRandomID(String type) {
        String id;
        String idType = "";
        String fullID;

        if(type.equalsIgnoreCase("truck")) {
            idType = "TR ";
        } else if (type.equalsIgnoreCase("SUV")) {
            idType = "SUV ";
        } else if(type.equalsIgnoreCase("minivan")) {
            idType = "MINI ";
        } else if(type.equalsIgnoreCase("sports")) {
            idType = "SPRT ";
        } else if(type.equalsIgnoreCase("van")) {
            idType = "VAN ";
        } else {
            System.out.println("❌ ERROR: car type invalid!");
            return null;
        }

        do {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 3; i++) {
                sb.append(random.nextInt(10));
            }

            id = sb.toString();
            fullID = idType + "- " + id;
        } while(generatedIds.contains(id));

        generatedIds.add(fullID);
        return fullID;
    }

    private static File createFile(String filename) {
        File file = new File(filename);

        try {
            if(file.createNewFile()) {
                System.out.println("✅ SUCCESS: file created");
            }
            return file;
        } catch (IOException e) {
            System.out.println("❌ ERROR: file not created");
        }

        return null;
    }

    private static void writeToFile(File file, String brand, String type, String id, double dailyRate, boolean isAvailable) {
        if(file == null) {
            System.out.println("❌ ERROR: file not found!");
            return;
        }

        // the true in the FileWriter argument so that it won't overwrite the existing file
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {

            writer.println("=====================================");
            writer.printf("Brand: %s\n", brand);
            writer.printf("Type: %s\n", type);
            writer.printf("ID: %s\n", id);
            writer.printf("Daily Rate: %.2f\n", dailyRate);
            writer.println("Is Available: " + isAvailable);

            System.out.println("✅ File successfully written!");

        } catch (IOException e) {
            System.out.println("❌ ERROR: not written to file!");
        }
    }

    private static void writeToFile(List<Car> cars, String filename) {
        if(filename == null) {
            System.out.println("❌ ERROR: file not found!");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for(Car car : cars) {
                writer.println("=====================================");
                writer.printf("Brand: %s\n", car.getBrand());
                writer.printf("Type: %s\n", car.getType());
                writer.printf("ID: %s\n", car.getId());
                writer.printf("Daily Rate: %.2f\n", car.getDailyRate());
                writer.println("Is Available: " + car.getIsAvailable());
            }

            System.out.println("✅ File successfully written!");

        } catch (IOException e) {
            System.out.println("❌ ERROR: not written to file!");
        }
    }

    private static void overwriteCar(List<Car> cars, String filename) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for(Car car : cars) {
                writer.write("Brand: " + car.getBrand());
                writer.newLine();
                writer.write("Type: " + car.getType());
                writer.newLine();
                writer.write("ID: " + car.getId());
                writer.newLine();
                writer.write("Daily rate: " + car.getDailyRate());
                writer.newLine();
                writer.write("Is Available: " + car.getIsAvailable());
                writer.newLine();
            }

            System.out.println("✅ SUCCESS: file overwritten");

        } catch(IOException e) {
            System.out.println("❌ ERROR: file not overwritten");
        }
    }

    private static List<Car> readCarFromFile(String filename) {
        List<Car> cars = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;
            String brand = "", type="", id="";
            double dailyRate = 0.00;
            boolean isAvailable = false;

            while((line = reader.readLine()) != null) {
                if(line.startsWith("Brand: ")) {
                    brand = line.split(":")[1].trim();
                } else if(line.startsWith("Type: ")) {
                    type = line.split(":")[1].trim();
                } else if(line.startsWith(("ID: "))) {
                    id = line.split(":")[1].trim();
                } else if(line.startsWith("Daily Rate: ")) {
                    dailyRate = Double.parseDouble(line.split(":")[1].trim());
                } else if(line.startsWith("Is Available: ")) {
                    isAvailable = Boolean.parseBoolean(line.split(":")[1].trim());
                } else if(line.startsWith("====")) {
                    cars.add(new Car(brand, type, id, isAvailable, dailyRate));
                }
            }

            if (!brand.isEmpty() && !type.isEmpty() && !id.isEmpty()) {
                cars.add(new Car(brand, type, id, isAvailable, dailyRate));
            }

        } catch(IOException e) {
            System.out.println("❌ ERROR: reading file");
        }

        return cars;
    }

    // method
    private static void addCarToList() {
        boolean isAvailable = false, isRunning = true;

        System.out.print("Car brand: ");
        String brand = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        String id = generateRandomID(type);
        System.out.print("ID: " + id);
        System.out.print("\nDaily rate: P");
        double dailyRate = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Is available: ");
        String isAvailableStr = scanner.nextLine();

        while(isRunning) {
            switch (isAvailableStr.toLowerCase()) {
                case "yes":
                    isAvailable = true;
                    isRunning = false;
                    break;
                case "no":
                    isAvailable = false;
                    isRunning = false;
                    break;
                default:
                    System.out.println("❌ ERROR: input invalid!");
            }
        }

        File file = createFile("cars.txt");
        writeToFile(file, brand, type, id, dailyRate, isAvailable);
    }

    public static void updateCarList(String filename) {
        List<Car> cars = readCarFromFile(filename);

        // display car brand, type, id
        displayList(filename);

        System.out.print("Enter ID: ");
        String id = scanner.nextLine().trim();

        Car selected = null;
        for(Car car: cars) {
            if(car.getId().equalsIgnoreCase(id)) {
                selected = car;
                break;
            }
        }

        if(selected == null) {
            System.out.println("❌ ERROR: car does not exist");
            return;
        }

        System.out.println("\n[1] - Change brand");
        System.out.println("[2] - Change type");
        System.out.println("[3] - Change daily rate");
        System.out.println("[4] - Change availability");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1:
                System.out.print("\nEnter new brand: ");
                selected.brand = scanner.nextLine();
                break;
            case 2:
                System.out.print("\nEnter new type: ");
                selected.type = scanner.nextLine();
                break;
            case 3:
                System.out.print("\nEnter new daily rate: ");
                selected.dailyRate = scanner.nextDouble();
                scanner.nextLine();
                break;
            case 4:
                System.out.print("\nEdit availability: ");
                String availability = scanner.nextLine();

                switch(availability.toLowerCase()) {
                    case "yes":
                        selected.isAvailable = true;
                        break;
                    case "no":
                        selected.isAvailable = false;
                        break;
                    default:
                        System.out.println("❌ Invalid status");
                }

                break;
            default:
                System.out.println("❌ Invalid choice!");
        }

        System.out.println("✅ Successfully edited!");
        writeToFile(cars, filename);
    }

    private static void deleteCarFromList(String filename) {
        displayList(filename);
        System.out.print("Enter id: ");
        String id = scanner.nextLine().trim();

        List<Car> cars = readCarFromFile(filename);
        boolean removed = cars.removeIf(car -> car.getId().equals(id));

        if(!removed) {
            System.out.println("❌ ERROR: car not found!");
            return;
        }

        overwriteCar(cars, filename);
    }

    private static void displayList(String filename) {
        List<Car> cars = readCarFromFile(filename);

        if(cars.isEmpty()) {
            System.out.print("\nNo cars\n");
            return;
        }

        System.out.println("Brand\tType\tID");
        for(Car car : cars) {
            System.out.println(car.getBrand() + "\t" + car.getType() + "\t" + car.getId());
        }
    }

    public static void carMenu() {
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("\n=== Car Menu ===");
            System.out.println("[1] - Add car to list");
            System.out.println("[2] - Update car list");
            System.out.println("[3] - Delete car from list");
            System.out.println("[4] - Display Car List");
            System.out.println("[5] - exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    addCarToList();
                    break;
                case 2:
                    updateCarList("cars.txt");
                    break;
                case 3:
                    deleteCarFromList("cars.txt");
                    break;
                case 4:
                    displayList("cars.txt");
                    break;
                case 5:
                    System.out.println("Quitting...");
                    isRunning = false;
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    public static Double getDailyRateId() {
        List<Car> cars = readCarFromFile("cars.txt");

        displayList("cars.txt");
        System.out.print("Enter id: ");
        String id = scanner.nextLine();

        for(Car car : cars) {
            if(car.getId().equalsIgnoreCase(id)) {
                return car.getDailyRate();
            }
        }

        System.out.println("❌ ERROR: car not in list");
        return null;
    }

}
