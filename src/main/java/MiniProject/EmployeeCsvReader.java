package MiniProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCsvReader {
        public Employee createEmployee(String line){
                System.out.println(line);
                var splitLines = line.split(",");
                return new Employee(splitLines[0],splitLines[1], splitLines[2], splitLines[3],splitLines[4], splitLines[5]);
        }


        public ArrayList<String> readFileLines(String fileName){
             //use for short files - opens and closes the file and handles any file exceptions
              ArrayList<String> readLines = new ArrayList<>();
              Path path = Paths.get(fileName);
               try {
                   readLines = (ArrayList<String>)Files.readAllLines(path);
                } catch (IOException e) {
                //throw new RuntimeException(e);
                e.printStackTrace();
                        }
               return readLines;
                }
        }

}
