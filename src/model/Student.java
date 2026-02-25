package model;

import java.util.HashMap;
import java.util.Map;

public abstract class Student extends Person {

    private double gpa;
    private Map<Course, Double> courses;

    public Student(String name, String id) {
        super(name, id);
        this.gpa = 0.0;
        this.courses = new HashMap<>();
    }

    public void addCourse(Course course, double grade) {
        courses.put(course, grade);
        calculateGPA();
    }

    private void calculateGPA() {
        double total = 0;
        for (double grade : courses.values()) {
            total += grade;
        }
        if (!courses.isEmpty()) {
            gpa = total / courses.size();
        }
    }

    public double getGpa() {
        return gpa;
    }

    public Map<Course, Double> getCourses() {
        return courses;
    }

    public abstract double calculateTuition();

    @Override
    public String getRole() {
        return "Student";
    }

    public void enrollCourse(Course course) {

    }
}