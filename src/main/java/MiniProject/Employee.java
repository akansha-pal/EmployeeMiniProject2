package MiniProject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String emp_no;
    private LocalDate birth_date;
    private String first_name;
    private String last_name;
    private char gender;
    private LocalDate hire_date;

    public Employee(String emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.emp_no = emp_no;
        this.birth_date = LocalDate.parse(birth_date, formatter);
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender.charAt(0);
        this.hire_date  = LocalDate.parse(hire_date, formatter);
    }

    public String getEmp_no() {
        return emp_no;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }
}
