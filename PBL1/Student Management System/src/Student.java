import java.time.Year;

public class Student {
    private String firstName, lastName, middleName;
    private int age;
    private String id;
    private String program;
    private int schoolYear;

    // constructor
    public Student(String firstName, String lastName, String middleName, int age, String id, String program, int schoolYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;

        this.age = age;
        setAge(age);

        this.id = id;
        this.program = program;
        this.schoolYear = schoolYear;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAge(int age) {
        if(age < 0) {
            System.out.println("Age cannot be negative.");
        }

        this.age = age;
    }

    public void setId(String id) {
        // null first to avoid NullPointerException error
        if(id == null || id.length() > 6) {
            System.out.println("Invalid id. Must be 6 characters long");
            return;
        }

        for(int i = 0; i < id.length(); i++) {
            if(!Character.isDigit(id.charAt(i))) {
                System.out.println("Invalid id. Must contain integers");
                return;
            }
        }

        this.id = id;
    }

    public void setSchoolYear(int schoolYear) {
        Year year = Year.now();
        if(schoolYear < 1970 || schoolYear > year.getValue()) {
            System.out.println("ERROR: Invalid year");
        }

        this.schoolYear = schoolYear;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    // Getters
    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public String getProgram() {
        return program;
    }
}
