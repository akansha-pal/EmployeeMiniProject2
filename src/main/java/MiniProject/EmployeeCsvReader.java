package MiniProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCsvReader {
    public static void main(String[] args) {
        System.out.println(readFileLines("src/main/resources/Employees_short.csv"));
    }

    public static Employee createEmployee(String line) {
        var splitLines = line.split(",");
        return new Employee(splitLines[0], splitLines[1], splitLines[2], splitLines[3], splitLines[4], splitLines[5]);
    }


    public static List<String> readFileLines(String fileName) {
        //use for short files - opens and closes the file and handles any file exceptions
        List<String> readLines = new ArrayList<>();
        Path path = Paths.get(fileName);
        try {
            readLines = Files.readAllLines(path);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        return readLines;
    }

    public static List<Employee> readEmployees(String filename) {
        List<Employee> employees = new ArrayList<>();
        var file = readFileLines(filename);
        for (var f : file) {
            employees.add(createEmployee(f));
        }
        return employees;
    }

}


