package model;

import java.util.Map;

public class GraduateStudent extends Student {

    private static final double COST_PER_CREDIT = 3000;
    private static final double RESEARCH_FEE = 100;


    public GraduateStudent(String name, String id) {
        super(name, id);

    }

    @Override
    public double calculateTuition() {
        double totalcredits = 0;
        for(Course course : getCourses().keySet()) {
            totalcredits += course.getCredits();
        }
        return (COST_PER_CREDIT * totalcredits) + RESEARCH_FEE;
    }

}