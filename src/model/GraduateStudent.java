package model;

public class GraduateStudent extends Student {

    private int credits;

    public GraduateStudent(String name, String id, int credits) {
        super(name, id);
        this.credits = credits;
    }

    @Override
    public double calculateTuition() {
        return (credits * 300) + 1000;
    }
}