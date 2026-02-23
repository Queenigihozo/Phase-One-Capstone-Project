package model;

public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String name, String id) {
        super(name, id);
    }

    @Override
    public double calculateTuition() {
        return 2000;
    }
}