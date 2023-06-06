import MiniProject.Employee;
import MiniProject.EmployeeCsvReader;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import javax.annotation.processing.SupportedAnnotationTypes;

public class EmployeeTest {

    //test to string method - create employee and test if employee number is same as expected
    @Test
    @DisplayName("Test for createEmployee-correct employee information")
    public void test1(){
        var file = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        Employee employee = EmployeeCsvReader.createEmployee(file.get(0));
        Assertions.assertEquals("37682",employee.getEmp_no());
        Assertions.assertEquals("28/01/1962",employee.getBirth_date());
        Assertions.assertEquals("Sigeru",employee.getFirst_name());
        Assertions.assertEquals("Akiyama",employee.getLast_name());
        Assertions.assertEquals("F",employee.getGender());
        Assertions.assertEquals("17/09/1990",employee.getHire_date());
    }

    @Test
    @DisplayName("Test for readFileLines - length of list should be 10")
    public void test3(){
        var file = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        Assertions.assertEquals(10,file.toArray().length);
    }
    @Test
    @DisplayName("Test for readFileLines - first string should be correct")
    public void test4(){
        var file = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        String expected = "37682,28/01/1962,Sigeru,Akiyama,F,17/09/1990";
        Assertions.assertEquals(expected,file.get(0));
    }
    @Test
    @DisplayName("Test for readFileLines - last string should be correct")
    public void test5(){
        var file = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        String expected = "38882,21/01/1962,Aemilian,Gimarc,F,08/11/1986";
        Assertions.assertEquals(expected,file.get(9));
    }


    @Test
    @DisplayName("Test for readingEmployees - list should be correct length")
    public void test6(){
        var employeeList = EmployeeCsvReader.readEmployees("src/main/resources/Employees_short.csv");
        Assertions.assertEquals(10,employeeList.size());
    }
    @Test
    @DisplayName("Test for readingEmployees - first object should be correct")
    public void test7(){
        var employeeList = EmployeeCsvReader.readEmployees("src/main/resources/Employees_short.csv");
        Assertions.assertEquals("37682",employeeList.get(0).getEmp_no());
        Assertions.assertEquals("28/01/1962",employeeList.get(0).getBirth_date());
        Assertions.assertEquals("Sigeru",employeeList.get(0).getFirst_name());
        Assertions.assertEquals("Akiyama",employeeList.get(0).getLast_name());
        Assertions.assertEquals("F",employeeList.get(0).getGender());
        Assertions.assertEquals("17/09/1990",employeeList.get(0).getHire_date());
    }
    @Test
    @DisplayName("Test for readingEmployees - last object should be correct")
    public void test8(){
        var employeeList = EmployeeCsvReader.readEmployees("src/main/resources/Employees_short.csv");
        Assertions.assertEquals("38882",employeeList.get(9).getEmp_no());
        Assertions.assertEquals("21/01/1962",employeeList.get(9).getBirth_date());
        Assertions.assertEquals("Aemilian",employeeList.get(9).getFirst_name());
        Assertions.assertEquals("Gimarc",employeeList.get(9).getLast_name());
        Assertions.assertEquals("F",employeeList.get(9).getGender());
        Assertions.assertEquals("08/11/1986",employeeList.get(9).getHire_date());
    }

}
