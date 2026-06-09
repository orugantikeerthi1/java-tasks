import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student implements Serializable {

    private String name;
    private int rollNumber;
    private String grade;
    private String course;

    // Constructor
    public Student(String name, int rollNumber, String grade, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.course = course;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getCourse() {
        return course;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Display Student Details
    @Override
    public String toString() {

        return "\n----------------------" +
               "\nRoll Number : " + rollNumber +
               "\nName        : " + name +
               "\nGrade       : " + grade +
               "\nCourse      : " + course +
               "\n----------------------";
    }
}

// Main Class
public class studentmanagementsystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    public static void addStudent() {

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        int rollNumber;

        try {
            System.out.print("Enter Roll Number: ");
            rollNumber = Integer.parseInt(sc.nextLine());
        }

        catch (Exception e) {
            System.out.println("Invalid Roll Number!");
            return;
        }

        // Check duplicate roll number
        for (Student s : students) {

            if (s.getRollNumber() == rollNumber) {
                System.out.println("Roll Number already exists!");
                return;
            }
        }

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student student =
                new Student(name, rollNumber, grade, course);

        students.add(student);

        System.out.println("Student Added Successfully!");
    }

    // Display Students
    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search Student
    public static void searchStudent() {

        int rollNumber;

        try {
            System.out.print("Enter Roll Number to Search: ");
            rollNumber = Integer.parseInt(sc.nextLine());
        }

        catch (Exception e) {
            System.out.println("Invalid Input!");
            return;
        }

        for (Student s : students) {

            if (s.getRollNumber() == rollNumber) {

                System.out.println("\nStudent Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    //Remove Student
    public static void removeStudent() {

        int rollNumber;

        try {
            System.out.print("Enter Roll Number to Remove: ");
            rollNumber = Integer.parseInt(sc.nextLine());
        }

        catch (Exception e) {
            System.out.println("Invalid Input!");
            return;
        }

        for (Student s : students) {

            if (s.getRollNumber() == rollNumber) {

                students.remove(s);

                System.out.println("Student Removed Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Edit Student
    public static void editStudent() {

        int rollNumber;

        try {
            System.out.print("Enter Roll Number to Edit: ");
            rollNumber = Integer.parseInt(sc.nextLine());
        }

        catch (Exception e) {
            System.out.println("Invalid Input!");
            return;
        }

        for (Student s : students) {

            if (s.getRollNumber() == rollNumber) {

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                if (!newName.isEmpty()) {
                    s.setName(newName);
                }

                System.out.print("Enter New Grade: ");
                String newGrade = sc.nextLine();

                if (!newGrade.isEmpty()) {
                    s.setGrade(newGrade);
                }

                System.out.print("Enter New Course: ");
                String newCourse = sc.nextLine();

                if (!newCourse.isEmpty()) {
                    s.setCourse(newCourse);
                }

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Save Data
    public static void saveData() {

        try {

            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream("students.dat"));

            oos.writeObject(students);

            oos.close();

            System.out.println("Data Saved Successfully!");
        }

        catch (Exception e) {

            System.out.println("Error Saving Data!");
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadData() {

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream("students.dat"));

            students =
                    (ArrayList<Student>) ois.readObject();

            ois.close();

            System.out.println("Previous Data Loaded Successfully!");
        }

        catch (Exception e) {

            System.out.println("No Previous Data Found.");
        }
    }

    // Main Method
    public static void main(String[] args) {

        loadData();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Edit Student");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");

            int choice;

            try {

                choice = Integer.parseInt(sc.nextLine());
            }

            catch (Exception e) {

                System.out.println("Invalid Choice!");
                continue;
            }

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    editStudent();
                    break;

                case 6:
                    saveData();
                    break;

                case 7:
                    saveData();
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}