package util;

import model.*;
import java.io.*;
import java.util.*;

public class FileManager {

    public static void saveStudents(List<Student> students)
            throws IOException {

        PrintWriter writer = new PrintWriter("students.txt");

        for (Student s : students) {
            writer.println(
                    s.getId() + "," +
                            s.getName() + "," +
//                            s.getDepartment() + "," +
                            s.getGpa()
            );
        }

        writer.close();
    }

    public static void loadStudents(List<Student> students)
            throws IOException {

        File file = new File("students.txt");
        if (!file.exists()) return;

        Scanner scanner = new Scanner(file);

//        while (scanner.hasNextLine()) {
//            String[] data = scanner.nextLine().split(",");
//            students.add(
//                    new UndergraduateStudent(
//                            data[1], "loaded@email.com",
//                            data[0], data[2]
//                    )
//            );
//        }
//        scanner.close();
//    }

    }
}