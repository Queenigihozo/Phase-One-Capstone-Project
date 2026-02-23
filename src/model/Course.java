package model;

import java.util.ArrayList;
import java.util.List;

import exception.CourseFullException;
import exception.StudentAlreadyEnrolledException;

public class Course {

    private String code;
    private String title;
    private int credits;
    private int capacity;
    private List<Student> students;

    public Course(String code, String title, int credits, int capacity) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student)
            throws CourseFullException, StudentAlreadyEnrolledException {

        if (students.contains(student)) {
            throw new StudentAlreadyEnrolledException("Student already enrolled.");
        }

        if (students.size() >= capacity) {
            throw new CourseFullException("Course is full.");
        }

        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getTitle() {
        return title;
    }
}