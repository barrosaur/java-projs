import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StudentManager {
    private static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addStudent() {
        System.out.println("=== Add a student ===");

        // Name
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student middle name: ");
        String middleName = scanner.nextLine();

        // Age
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // ID
        String id = generateStudId();
        System.out.println("ID: " + id);

        // Program
        System.out.print("Student program: ");
        String program = scanner.nextLine();

        // school year
        System.out.print("School year: ");
        int studYear = scanner.nextInt();

        studentList.add(new Student(firstName, lastName, middleName, age, id, program, studYear));
        System.out.println("Student successfully added!");
    }

    public static void updateStudent() {

        System.out.println("=== Update student information ===");

        if(studentList.size() < 1) {
            System.out.println("No students to update!");
            return;
        }

        Student studFound = searchStudent();

        if(studFound != null) {
            System.out.println("Student FOUND!");
            System.out.println("\nName: " + studFound.getLastName() + ", " + studFound.getFirstName() + ", " + studFound.getMiddleName() + "\n");

            System.out.println("What would you like to do?");
            System.out.println("[1] - Update student name");
            System.out.println("[2] - Update student program");
            System.out.println("[3] - Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Edit:\n[1] - Last Name\n[2] - First Name\n[3] - Middle Name");
                    System.out.print("Enter choice: ");
                    int nameChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch(nameChoice) {
                        case 1:
                            System.out.print("Enter new last name: ");
                            String newLastName = scanner.nextLine();

                            studFound.setLastName(newLastName);
                            System.out.println("Last Name successfully changed!");

                            break;
                        case 2:
                            System.out.print("Enter new first name: ");
                            String newFirstName = scanner.nextLine();

                            studFound.setFirstName(newFirstName);
                            System.out.println("First name successfully changed!");

                            break;
                        case 3:
                            System.out.print("Enter new middle name: ");
                            String newMiddleName = scanner.nextLine();

                            studFound.setMiddleName(newMiddleName);
                            System.out.println("Middle name successfully changed!");

                            break;
                        default:
                            System.out.println("Invalid option!");
                    }

                    break;
                case 2:
                    System.out.println("Enter new student program: ");
                    String newProgram = scanner.nextLine();

                    studFound.setProgram(newProgram);
                    System.out.println("Program Successfully changed!");

                    break;
                case 3:
                    System.out.println("Quitting program...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }

        } else {
            System.out.println("Student NOT FOUND!");
        }
    }

    public static void deleteStudent() {
        System.out.println("=== Delete Student ===");

        if(studentList.size() < 1) {
            System.out.println("No students to delete!");
            return;
        }

        Student studDel = searchStudent();

        if(studDel != null) {
            System.out.println("Student FOUND!");
            System.out.print("Delete student? [y][n] ");
            char choice = Character.toLowerCase(scanner.nextLine().charAt(0));

            switch(choice) {
                case 'y':
                    studentList.remove(studDel);
                    System.out.println("Student Removed!");
                    break;
                case 'n':
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static Student searchStudent() {
        System.out.println("Search a student");
        System.out.println("------------------");
        scanner.nextLine();
        System.out.print("Enter student last name: ");
        String studentName = scanner.nextLine();

        for(Student student : studentList) {
            if(student.getLastName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }

        return null;
    }

    private static final Set<String> generatedIds = new HashSet<>();
    private static final Random random = new Random();

    private static String generateStudId() {
        String id;

        do {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 6; i++) {
                // digits 0-9
                sb.append(random.nextInt(10));
            }

            id = sb.toString();

        } while(generatedIds.contains(id));

        generatedIds.add(id); // marking id as used
        return id;
    }

    public static void showStudInfo() {
        if(studentList.size() < 1) {
            System.out.println("No students");
            return;
        }

        System.out.println("=== Student Info ===");
        Student studInfo = searchStudent();

        if(studInfo != null) {
            System.out.println("Name: " + studInfo.getLastName() + ", " + studInfo.getFirstName() + ", " + studInfo.getMiddleName());
            System.out.println("Age: " + studInfo.getAge());
            System.out.println("ID: " + studInfo.getId());
            System.out.println("Program: " + studInfo.getProgram());
            System.out.println("School year: " + studInfo.getSchoolYear());
        } else {
            System.out.println("Student DOES NOT EXIST");
        }
    }

}
