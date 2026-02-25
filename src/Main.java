import model.*;
import service.UniversityManager;
import util.FileManager;
import exception.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        Scanner scanner = new Scanner(System.in);


        try {
            FileManager.loadStudents(manager.getStudents());
            System.out.println("Previous data loaded successfully.");
        } catch (IOException e) {
            System.out.println("No previous data found. Starting fresh.");
        }

        boolean running = true;

        while (running) {

            System.out.println("\n========= UNIVERSITY SYSTEM =========");
            System.out.println("1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. View Student Records");
            System.out.println("5. Generate Dean's List");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");

            int choice;

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();

                    System.out.print("Type (1 = Undergraduate, 2 = Graduate): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    Student student;

                    if (type == 1) {
                        student = new UndergraduateStudent(name, id);
                    } else if (type == 2) {
                        student = new GraduateStudent(name, id);
                    } else {
                        System.out.println("Invalid type selected.");
                        break;
                    }

                    manager.registerStudent(student);
                    System.out.println("Student registered successfully.");
                    break;

                case 2:

                    System.out.print("Enter Course Code: ");
                    String code = scanner.nextLine();

                    System.out.print("Enter Course Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();

                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();

                    manager.createCourse(
                            new Course(code, title, credits, capacity));

                    System.out.println("Course created successfully.");
                    break;

                case 3:

                    try {
                        System.out.print("Enter Student ID: ");
                        String sid = scanner.nextLine();

                        System.out.print("Enter Course Code: ");
                        String ccode = scanner.nextLine();

                        System.out.print("Enter Grade (0.0 - 4.0): ");
                        double grade = scanner.nextDouble();
                        scanner.nextLine();

                        if (grade < 0.0 || grade > 4.0) {
                            System.out.println("Invalid grade. Must be between 0.0 and 4.0");
                            break;
                        }

                        manager.enrollStudentInCourse(sid, ccode, grade);
                        System.out.println("Enrollment successful.");

                    } catch (CourseFullException e) {
                        System.out.println("Enrollment failed: Course is full.");
                    } catch (StudentAlreadyEnrolledException e) {
                        System.out.println("Enrollment failed: Student already enrolled.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 4:

                    if (manager.getStudents().isEmpty()) {
                        System.out.println("No students registered.");
                    } else {
                        System.out.println("\n--- Student Records ---");
                        manager.getStudents().forEach(s -> {
                            System.out.println(
                                    "ID: " + s.getId() +
                                            " | Name: " + s.getName() +
                                            " | GPA: " + String.format("%.2f", s.getGpa()) +
                                            " | Tuition: $" + s.calculateTuition()
                            );
                        });
                    }
                    break;

                case 5:
                    manager.generateDeansList();
                    break;

                case 6:

                    try {
                        FileManager.saveStudents(manager.getStudents());
                        System.out.println("Data saved successfully.");
                    } catch (IOException e) {
                        System.out.println("Error saving data.");
                    }

                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        }

        scanner.close();
    }
}