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

    public void enrollStudentInCourse(String studentID, String courseCode)
            throws CourseFullException, StudentAlreadyEnrolledException {

        Student student = students.stream()
                .filter(s -> students.equals(studentID))
                .findFirst().orElse(null);

        Course course = courses.stream()
                .filter(c -> c.getCode().equals(courseCode))
                .findFirst().orElse(null);

        if (student == null || course == null) {
            System.out.println("Student or Course not found.");
            return;
        }

        if (course.getStudents().size() >= course.getCapacity())
            throw new CourseFullException("Course is full.");

        if (course.getStudents().contains(student))
            throw new StudentAlreadyEnrolledException("Student already enrolled.");

        course.addstude(student);
        student.enrollCourse(course);
    }

    public List<Student> getStudents() { return students; }
    public List<Course> getCourses() { return courses; }

    public void generateDeansList() {
        System.out.println("\n--- Dean's List ---");
        students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .forEach(s ->
                        System.out.println(s.getName() +
                                " GPA: " + s.getGpa()));
    }
}