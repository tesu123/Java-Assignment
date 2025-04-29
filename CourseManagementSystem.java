import java.util.Scanner;

class Instructor {
    private String name;
    String phoneNumber;

    public
    // Set instructor information
    void setInstructorInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // View instructor information
    void viewInstructorInfo() {
        System.out.println("Instructor Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
    }

}

class Textbook {
    private String title;
    String author;
    String publisher;

    public
    // Set textbook information
    void setTextbookInfo(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // View textbook information
    public void viewTextbookInfo() {
        System.out.println("Textbook Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
    }

}

class Course {
    private String courseName;
    Instructor instructor;
    Textbook textbook;

    public
    // Set course information
    void setCourseInfo(String courseName, Instructor instructor, Textbook textbook) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.textbook = textbook;
    }

    // View course information
    void viewCourseInfo() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("\nInstructor Details:");
        instructor.viewInstructorInfo();
        System.out.println("\nTextbook Details:");
        textbook.viewTextbookInfo();
    }
}

public class CourseManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create objects
        Instructor instructor = new Instructor();
        Textbook textbook = new Textbook();
        Course course = new Course();

        while (true) {
            System.out.println("\n=== Course Management System ===");
            System.out.println("1. Set Instructor Information");
            System.out.println("2. View Instructor Information");
            System.out.println("3. Set Textbook Information");
            System.out.println("4. View Textbook Information");
            System.out.println("5. Set Course Information");
            System.out.println("6. View Course Information");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Instructor Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    instructor.setInstructorInfo(name, phone);
                    System.out.println("Instructor information set successfully!");
                    break;

                case 2:
                    System.out.println("\nInstructor Information:");
                    instructor.viewInstructorInfo();
                    break;

                case 3:
                    System.out.print("Enter Textbook Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();
                    textbook.setTextbookInfo(title, author, publisher);
                    System.out.println("Textbook information set successfully!");
                    break;

                case 4:
                    System.out.println("\nTextbook Information:");
                    textbook.viewTextbookInfo();
                    break;

                case 5:
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    course.setCourseInfo(courseName, instructor, textbook);
                    System.out.println("Course information set successfully!");
                    break;

                case 6:
                    System.out.println("\nCourse Information:");
                    course.viewCourseInfo();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}