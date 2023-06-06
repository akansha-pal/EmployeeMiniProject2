package MiniProject;

import java.util.ArrayList;

public class EmployeeCsvReader {
        public Employee createEmployee(String line){
                var splitLines = line.split(",");
                return new Employee(splitLines[0],splitLines[1], splitLines[2], splitLines[3],splitLines[4], splitLines[5]);
        }

        public ArrayList<String> readFileLines(String fileName){

        }
}
