package model;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {

    private double gpa;
    private Map<Course, Double> courses;

    public Student(String name, String id) {
        super(name, id);
        this.courses = new HashMap<>();
        this.gpa = 0.0;
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


    public double calculateTuition() {
        return 2000; // fixed flat tuition
    }

    @Override
    public String getRole() {
        return "Student";
    }
}