import MiniProject.Employee;
import MiniProject.EmployeeCsvReader;
import MiniProject.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class EmployeeTest {

    //test to string method - create employee and test if employee number is same as expected
    @Test
    @DisplayName("Test for createEmployee-correct employee information")
    public void test1() {
        var file = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        Employee employee = EmployeeCsvReader.createEmployee(file.get(0));
        Assertions.assertEquals("37682", employee.getEmp_no());
        //Assertions.assertEquals("28/01/1962",employee.getBirth_date());

        // LocalDate birth_Date
        Assertions.assertEquals("1962-01-28", employee.getBirth_date().toString());
        Assertions.assertEquals("Sigeru", employee.getFirst_name());
        Assertions.assertEquals("Akiyama", employee.getLast_name());
        // Assertions.assertEquals("F",employee.getGender());

        // char gender
        Assertions.assertEquals('F', employee.getGender());
        //Assertions.assertEquals("17/09/1990",employee.getHire_date());

        // LocalDate hire_date
        Assertions.assertEquals("1990-09-17", employee.getHire_date().toString());
    }

    @Test
    @DisplayName("Test for readFileLines - length of list should be 10")
    public void test3() {
        var file = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        Assertions.assertEquals(10, file.size());
    }

    @Test
    @DisplayName("Test for readFileLines - first string should be correct")
    public void test4() {
        var file = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        String expected = "37682,28/01/1962,Sigeru,Akiyama,F,17/09/1990";
        Assertions.assertEquals(expected, file.get(0));
    }

    @Test
    @DisplayName("Test for readFileLines - last string should be correct")
    public void test5() {
        var file = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        String expected = "38882,21/01/1962,Aemilian,Gimarc,F,08/11/1986";
        Assertions.assertEquals(expected, file.get(9));
    }


    @Test
    @DisplayName("Test for readingEmployees - list should be correct length")
    public void test6() {
        var employeeList = EmployeeCsvReader.readEmployees("src/main/resources/Employees_short.csv");
        Assertions.assertEquals(10, employeeList.size());
    }

    @Test
    @DisplayName("Test for readingEmployees - first object should be correct")
    public void test7() {
        var employeeList = EmployeeCsvReader.readEmployees("src/main/resources/Employees_short.csv");
        Assertions.assertEquals("37682", employeeList.get(0).getEmp_no());
        //Assertions.assertEquals("28/01/1962",employeeList.get(0).getBirth_date());

        // LocalDate birth_Date
        Assertions.assertEquals("1962-01-28", employeeList.get(0).getBirth_date().toString());
        Assertions.assertEquals("Sigeru", employeeList.get(0).getFirst_name());
        Assertions.assertEquals("Akiyama", employeeList.get(0).getLast_name());
        // Assertions.assertEquals("F",employeeList.get(0).getGender());

        // char gender
        Assertions.assertEquals('F', employeeList.get(0).getGender());
        // Assertions.assertEquals("17/09/1990",employeeList.get(0).getHire_date());

        // LocalDate hire_Date
        Assertions.assertEquals("1990-09-17", employeeList.get(0).getHire_date().toString());
    }

    @Test
    @DisplayName("Test for readingEmployees - last object should be correct")
    public void test8() {
        var employeeList = EmployeeCsvReader.readEmployees("src/main/resources/Employees_short.csv");
        Assertions.assertEquals("38882", employeeList.get(9).getEmp_no());
        // Assertions.assertEquals("21/01/1962",employeeList.get(9).getBirth_date());

        // LocalDate birth_Date
        Assertions.assertEquals("1962-01-21", employeeList.get(9).getBirth_date().toString());
        Assertions.assertEquals("Aemilian", employeeList.get(9).getFirst_name());
        Assertions.assertEquals("Gimarc", employeeList.get(9).getLast_name());
        //Assertions.assertEquals("F",employeeList.get(9).getGender());

        // char gender
        Assertions.assertEquals('F', employeeList.get(9).getGender());
        // Assertions.assertEquals("08/11/1986",employeeList.get(9).getHire_date());

        // LocalDate hire_Date
        Assertions.assertEquals("1986-11-08", employeeList.get(9).getHire_date().toString());
    }

    @Test
    @DisplayName("Test for readingEmployees - length of employee number should be less than or equal to 8")
    public void test9() {
        var employeeList = EmployeeCsvReader.readEmployees("src/main/resources/Employees_short.csv");
        Assertions.assertEquals(5, employeeList.get(2).getEmp_no().length());
    }

    @Test
    @DisplayName("Test for readingEmployees - length of employee number should be less than or equal to 8")
    public void test10() {
        Logger logger = LogManager.getLogger("My Sparta App for Employees");
        var employeeList = EmployeeCsvReader.readFileLines("src/main/resources/Employees_short.csv");
        for (var employee : employeeList) {
            var validEmployee = true;
            var splitRow = employee.split(",");
            var id = splitRow[0];
            var birthDate = splitRow[1];
            var firstName = splitRow[2];
            var lastName = splitRow[3];
            var gender = splitRow[4];
            var hireDate = splitRow[5];
            Validator isValid = new Validator();
            if (!isValid.idValidator(id)) {
                logger.error("ID is invalid for employee - " + id);
                validEmployee = false;
            }
            if (!isValid.dateValidator(birthDate)) {
                logger.error("Birth date is invalid for employee - " + id);
                validEmployee = false;
            }
            if (!isValid.nameValidator(firstName)) {
                logger.error("First name is invalid for employee - " + id);
                validEmployee = false;
            }
            if (!isValid.nameValidator(lastName)) {
                logger.error("Last name is invalid for employee - " + id);
                validEmployee = false;
            }
            if (!isValid.genderValidator(gender)) {
                logger.error("Gender is invalid for employee - " + id);
                validEmployee = false;
            }
            if (!isValid.dateValidator(hireDate)) {
                logger.error("Hire date is invalid for employee - " + id);
                validEmployee = false;
            }
            if (validEmployee) {
                logger.info("All data is valid for employee - " + id);
            }
        }
    }


}
