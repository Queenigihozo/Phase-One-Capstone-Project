import model.UndergraduateStudent;
import model.Student;

public class Main {

    public static void main(String[] args) {

        Student student = new UndergraduateStudent("John", "S001");

        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Tuition: " + student.calculateTuition());
    }
}