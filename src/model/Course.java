package model;

import java.util.ArrayList;
import java.util.List;

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

    public void

    enrollStudent(Student student) {

        if (!students.contains(student) && students.size() < capacity) {
            students.add(student);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addstude(Student student) {
    }
}