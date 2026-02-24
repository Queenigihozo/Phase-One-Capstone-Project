package main;

import model.*;
import service.UniversityManager;
import util.FileManager;
import exception.*;

import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        Scanner scanner = new Scanner(System.in);

        try {
            FileManager.loadStudents(manager.getStudents());
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }

        while (true) {

            System.out.println("\n1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. View Student Record");
            System.out.println("5. Generate Dean's List");
            System.out.println("6. Save and Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Department: ");
                    String dept = scanner.nextLine();

                    System.out.print("Type (1=Undergrad, 2=Graduate): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    Student student = (type == 1)
                            ? new UndergraduateStudent(name, email, id, dept)
                            : new GraduateStudent(name, email, id, dept);

                    manager.registerStudent(student);
                    break;

                case 2:
                    System.out.print("Course Code: ");
                    String code = scanner.nextLine();

                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Credits: ");
                    int credits = scanner.nextInt();

                    System.out.print("Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();

                    manager.createCourse(
                            new Course(code, title, credits, capacity));
                    break;

                case 3:
                    try {
                        System.out.print("Student ID: ");
                        String sid = scanner.nextLine();

                        System.out.print("Course Code: ");
                        String ccode = scanner.nextLine();

                        manager.enrollStudentInCourse(sid, ccode);
                        System.out.println("Enrollment successful.");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    manager.getStudents().forEach(s -> {
                        System.out.println(s.getStudentID() +
                                " | " + s.getName() +
                                " | GPA: " + s.getGpa());
                    });
                    break;

                case 5:
                    manager.generateDeansList();
                    break;

                case 6:
                    try {
                        FileManager.saveStudents(manager.getStudents());
                    } catch (IOException e) {
                        System.out.println("Error saving data.");
                    }
                    return;
            }
        }
    }
}