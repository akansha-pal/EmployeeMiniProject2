package org.example;
//import MiniProject.Employee;
//import MiniProject.EmployeeCsvReader;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Iterator;

public class Main {
    //   public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("src/main/resources/Employees_short.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        Iterator<Row> rowIterator = sheet.iterator();
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.cellIterator();
//            String str = "";
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_NUMERIC:
//                        String employeeID= cell.getNumericCellValue() + "";
//                        str+=employeeID.substring(0,employeeID.length()-2)+",";
//                        break;
//                    case Cell.CELL_TYPE_STRING:
//                        str+=cell.getStringCellValue()+",";
//                        break;
//                }
//            }
//            EmployeeCsvReader newEmployee = new EmployeeCsvReader();
//            newEmployee.createEmployee(str.substring(0,str.length()-1));
}

