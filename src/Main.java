import model.*;

public class Main {

    public static void main(String[] args) {

        // Create Students
        Student undergrad = new UndergraduateStudent("Alice", "U001");
        Student grad = new GraduateStudent("Bob", "G001", 6);

        // Create Courses
        Course javaCourse = new Course("CS101", "Java Programming", 3, 30);
        Course dbCourse = new Course("CS202", "Databases", 3, 30);

        // Enroll students in courses
        javaCourse.enrollStudent(undergrad);
        javaCourse.enrollStudent(grad);

        dbCourse.enrollStudent(undergrad);

        // Add grades (Student keeps track using Map)
        undergrad.addCourse(javaCourse, 3.8);
        undergrad.addCourse(dbCourse, 3.6);

        grad.addCourse(javaCourse, 3.9);

        // Display Results
        System.out.println("===== LAB 1 TEST =====");

        System.out.println("\nUndergraduate Student:");
        System.out.println("Name: " + undergrad.getName());
        System.out.println("Tuition: " + undergrad.calculateTuition());
        System.out.println("GPA: " + undergrad.getGpa());

        System.out.println("\nGraduate Student:");
        System.out.println("Name: " + grad.getName());
        System.out.println("Tuition: " + grad.calculateTuition());
        System.out.println("GPA: " + grad.getGpa());

        System.out.println("\nCourse Roster (Java):");
        for (Student s : javaCourse.getStudents()) {
            System.out.println("- " + s.getName());
        }
    }
}