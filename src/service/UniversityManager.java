package service;

import model.*;
import exception.*;

import java.util.*;

public class UniversityManager {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void createCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(String studentID, String courseCode, double grade)
            throws CourseFullException, StudentAlreadyEnrolledException {

        Student student = students.stream()
                .filter(s -> s.getId().equals(studentID))
                .findFirst()
                .orElse(null);


        Course course = courses.stream()
                .filter(c -> c.getCode().equals(courseCode))
                .findFirst()
                .orElse(null);

        if (student == null || course == null) {
            throw new RuntimeException("Student or Course not found.");
        }

        if (course.getStudents().size() >= course.getCapacity())
            throw new CourseFullException("Course is full.");

        if (course.getStudents().contains(student))
            throw new StudentAlreadyEnrolledException("Student already enrolled.");


//        course.addStudent(student);

        // Add course + grade to student (THIS calculates GPA)
        student.addCourse(course, grade);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void generateDeansList() {

        System.out.println("\n--- Dean's List (GPA > 3.5) ---");

        boolean found = false;

        for (Student s : students) {
            if (s.getGpa() > 3.5) {
                System.out.println(
                        "ID: " + s.getId() +
                                " | Name: " + s.getName() +
                                " | GPA: " + String.format("%.2f", s.getGpa())
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students qualified.");
        }
    }
}