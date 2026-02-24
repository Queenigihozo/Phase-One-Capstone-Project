package model;

import java.util.*;

public abstract class Student extends Person {

    private String studentID;
    private String department;
    private double gpa;

    private Map<Course, Double> enrolledCourses = new HashMap<>();

    public Student(String name, String email,
                   String studentID, String department) {
        super(name, email);
        this.studentID = studentID;
        this.department = department;
    }

    public String getStudentID() { return studentID; }
    public String getDepartment() { return department; }
    public double getGpa() { return gpa; }

    public void enrollCourse(Course course) {
        enrolledCourses.put(course, 0.0);
    }

    public void assignGrade(Course course, double grade) {
        enrolledCourses.put(course, grade);
        calculateGPA();
    }

    private void calculateGPA() {
        double total = 0;
        for (double grade : enrolledCourses.values()) {
            total += grade;
        }
        gpa = enrolledCourses.size() > 0 ?
                total / enrolledCourses.size() : 0;
    }

    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    public abstract double calculateTuition();
}