import java.util.*;
import java.io.*;

public class Customer {
    String name, dateBorrowed, returnDate;
    String carBorrowed;
    int daysBorrowed;
    boolean isReturned;
    double fee;

    // constructor
    public Customer(String name, String dateBorrowed, String returnDate, String carBorrowed, int daysBorrowed, boolean isReturned, double fee) {
        this.name = name;
        this.dateBorrowed = dateBorrowed;
        this.returnDate = returnDate;
        this.carBorrowed = carBorrowed;
        this.daysBorrowed = daysBorrowed;
        this.isReturned = isReturned;
        this.fee = fee;
    }

    // getters and setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDateBorrowed(String dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }
    public void setDateReturned(String dateReturned) {
        this.returnDate = returnDate;
    }
    public void setCarBorrowed(String carBorrowed) {
        this.carBorrowed = carBorrowed;
    }
    public void setDaysBorrowed(int daysBorrowed) {
        this.daysBorrowed = daysBorrowed;
    }
    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }
    public void setFee(double setFee) {
        this.fee = fee;
    }

    public String getName() {
        return name;
    }
    public String getDateBorrowed() {
        return dateBorrowed;
    }
    public String getDateReturned() {
        return returnDate;
    }
    public String getCarBorrowed() {
        return carBorrowed;
    }
    public int getDaysBorrowed() {
        return daysBorrowed;
    }
    public boolean getIsReturned() {
        return isReturned;
    }
    public double getFee() {
        return fee;
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void customerMenu() {
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("What would you like to do?");
            System.out.println("[1] - Add customer to list");
            System.out.println("[2] - Edit customer info");
            System.out.println("[3] - Display customer list");
            System.out.println("[4] - Quit program");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    editCustomerInfo("customers.txt");
                    break;
                case 3:
                    displayCustomerList();
                    break;
                case 4:
                    System.out.println("Quitting program...");
                    isRunning = false;
                    return;
                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }

    private static File createFile() {
        File file = new File("customer.txt");

        try {

            if(file.createNewFile()) {
                System.out.println("✅ SUCCESS: file created!");
            }

            return file;

        } catch (IOException e) {
            System.out.println("❌ ERROR creating file");
        }

        return null;
    }

    private static void writeToFile(File file, String name, String dateBorrowed,
                                    String returnDate, String carBorrowed, int daysBorrowed,
                                    boolean isReturned, double fee) {
        //----------------------------------------------------------------------------------
        if(file == null) {
            System.out.println("❌ ERROR: file not found");
            return;
        }

        try(PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {

            writer.println("=====================================");
            writer.printf("Name: %s\n", name);
            writer.printf("Date Borrowed: %s\n", dateBorrowed);
            writer.printf("Return Date: %s\n", returnDate);
            writer.printf("Car borrowed: %s\n", carBorrowed);
            writer.printf("Days borrowed: %d\n", daysBorrowed);
            writer.println("Is returned: " + isReturned);
            writer.printf("Fee: %.2f\n", fee);

            System.out.println("✅ SUCCESS: file written!");

        } catch(IOException e) {
            System.out.println("❌ ERROR: not written to file!");
        }
    }

    private static void writeToFile(List<Customer> customers, String filename) {
        if(filename == null) {
            System.out.println("❌ File does not exist!");
            return;
        }

        try(PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for(Customer customer : customers) {
                writer.println("=====================================");
                writer.printf("Name: %s\n", customer.getName());
                writer.printf("Date Borrowed: %s\n", customer.getDateBorrowed());
                writer.printf("Return Date: %s\n", customer.getDateReturned());
                writer.printf("Car borrowed: %s\n", customer.getCarBorrowed());
                writer.printf("Days borrowed: %d\n", customer.getDaysBorrowed());
                writer.println("Is returned: " + customer.getIsReturned());
                writer.printf("Fee: %.2f\n", customer.getFee());
            }

            System.out.println("✅ SUCCESS: file written!");

        } catch(IOException e) {
            System.out.println("❌ ERROR: not written to file!");
        }
    }

    private static void overwriteFile(List<Customer> customers, String filename) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for(Customer customer : customers) {
                writer.write("Name: " + customer.getName());
                writer.newLine();
                writer.write("Date borrowed: " + customer.getDateBorrowed());
                writer.newLine();
                writer.write("Return Date: " + customer.getDateReturned());
                writer.newLine();
                writer.write("Car borrowed: " + customer.getCarBorrowed());
                writer.newLine();
                writer.write("Days borrowed: " + customer.getDaysBorrowed());
                writer.newLine();
                writer.write("Is returned: " + customer.getIsReturned());
                writer.newLine();
                writer.write("Fee: " + customer.getFee());
                writer.newLine();
            }

            System.out.println("✅ File updated!");

        } catch(IOException e) {
            System.out.println("❌ File not updated!");
        }
    }

    private static List<Customer> readCustomerFromFile(String filename) {
        List<Customer> customers = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String name="", dateBorrowed="", returnDate="", carBorrowed="";
            boolean isReturned = false;
            int daysBorrowed = 0;
            double fee = 0.00;

            while((line = reader.readLine()) != null) {
                if(line.startsWith("Name: ")) {
                    name = line.split(":")[1].trim();
                } else if(line.startsWith("Date Borrowed: ")) {
                    dateBorrowed = line.split(":")[1].trim();
                } else if(line.startsWith("Return Date: ")) {
                    returnDate = line.split(":")[1].trim();
                } else if(line.startsWith("Car borrowed: ")) {
                    carBorrowed = line.split(":")[1].trim();
                } else if(line.startsWith("Days borrowed: ")) {
                    daysBorrowed = Integer.parseInt(line.split(":")[1].trim());
                } else if(line.startsWith("Is returned: ")) {
                    isReturned = Boolean.parseBoolean(line.split(":")[1].trim());
                } else if(line.startsWith("Fee: ")) {
                    fee = Double.parseDouble(line.split(":")[1].trim());
                } else if(line.startsWith("====")) {
                    customers.add(new Customer(name, dateBorrowed, returnDate, carBorrowed, daysBorrowed, isReturned, fee));
                }
            }

            if(!name.isEmpty() && !carBorrowed.isEmpty() && !dateBorrowed.isEmpty() && !returnDate.isEmpty()) {
                customers.add(new Customer(name, dateBorrowed, returnDate, carBorrowed, daysBorrowed, isReturned, fee));
            }

        } catch(IOException e) {
            System.out.println("❌ Error reading file");
        }

        return customers;
    }

    private static void addCustomer() {
        boolean isRunning = true;
        boolean isReturnedStatus = false;

        System.out.println("Enter customer name: (LN, FN, MN)");
        String name = scanner.nextLine();
        System.out.println("Enter date borrowed: (dd-mm-yyyy)");
        String dateBorrowed = scanner.nextLine();
        System.out.println("Enter return date: (dd-mm-yyyy)");
        String returnDate = scanner.nextLine();
        System.out.println("Enter car borrowed: Brand - Type");
        String carBorrowedStr = scanner.nextLine();
        Car.updateCarList("cars.txt");
        System.out.print("# of days borrowed: ");
        int daysBorrowed = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Is returned: ");
        String isReturnedStr = scanner.nextLine();

        while(isRunning) {
            switch (isReturnedStr.toLowerCase()) {
                case "yes":
                    isReturnedStatus = true;
                    isRunning = false;
                    break;
                case "no":
                    isReturnedStatus = false;
                    isRunning = false;
                    break;
                default:
                    System.out.println("❌ Invalid input");
            }
        }

        Double dailyRate = Car.getDailyRateId();
        Double fee = daysBorrowed * dailyRate;
        System.out.printf("Fee: %.2f\n", fee);

        File file = createFile();
        writeToFile(file, name, dateBorrowed, returnDate, carBorrowedStr, daysBorrowed, isReturnedStatus, fee);
    }

    private static void displayCustomerList() {
        List<Customer> customers = readCustomerFromFile("customers.txt");

        if(customers.isEmpty()) {
            System.out.println("List empty.\n");
            return;
        }

        System.out.println("Name\t\tCar Borrowed\t\tDate Borrowed\tReturn Date");
        for(Customer customer : customers) {
            System.out.println(customer.getName() + "\t\t" + customer.getCarBorrowed() + "\t\t" + customer.getDateBorrowed() + "\t" + customer.getDateReturned());
        }
    }

    private static void editCustomerInfo(String filename) {
        List<Customer> customers = readCustomerFromFile(filename);

        displayCustomerList();

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();

        Customer selected = null;
        for(Customer customer : customers) {
            if(customer.getName().equalsIgnoreCase(name)) {
                selected = customer;
                break;
            }
        }

        if(selected == null) {
            System.out.println("❌ Customer not found!");
            return;
        }

        System.out.println("[1] - Edit name");
        System.out.println("[2] - Edit date borrowed");
        System.out.println("[3] - Edit return date");
        System.out.println("[4] - Edit car borrowed");
        System.out.println("[5] - Edit number of days borrowed");
        System.out.println("[6] - Edit returned");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1:
                System.out.print("Enter new name: ");
                selected.name = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter date borrowed (dd-mm-yyyy):");
                selected.dateBorrowed = scanner.nextLine();
                break;
            case 3:
                System.out.println("Enter new return date (dd-mm-yyyy):");
                selected.returnDate = scanner.nextLine();
                break;
            case 4:
                System.out.println("Enter new car borrowed (Brand - Type):");
                selected.carBorrowed = scanner.nextLine();
                break;
            case 5:
                System.out.println("Enter new number of days:");
                selected.daysBorrowed = scanner.nextInt();
                break;
            case 6:
                System.out.println("Edit return status: ");
                String returnStatus = scanner.nextLine();

                switch(returnStatus.toLowerCase()) {
                    case "yes":
                        selected.isReturned = true;
                        break;
                    case "no":
                        selected.isReturned = false;
                        break;
                    default:
                        System.out.println("❌ Invalid status");
                }
                break;
            default:
                System.out.println("❌ Invalid choice");
        }

        System.out.println("✅ Successfully updated!");
        writeToFile(customers, filename);
    }
}
