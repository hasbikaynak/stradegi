package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Question1 {
    public static HashMap<String, Double> yearlySummaryFor2020 = new HashMap<>();
    public static HashMap<String, Double> yearlySummaryFor2021 = new HashMap<>();

    public static void main(String[] args) {
        readData();
        writeExcel();
    }

    public static void writeExcel() {
        try {
            // Open the Excel file
            FileInputStream fis = new FileInputStream(new File("src/main/resources/Employee Data.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            // Create a new sheet
            XSSFSheet sheet = workbook.createSheet("Processed output");


            // Create a new row
            XSSFRow row1 = sheet.createRow(0);
            XSSFRow row2 = sheet.createRow(1);
            XSSFRow row3 = sheet.createRow(2);
            XSSFRow row4 = sheet.createRow(3);
            XSSFRow row5 = sheet.createRow(4);
            XSSFRow row7 = sheet.createRow(6);
            XSSFRow row8 = sheet.createRow(7);
            XSSFRow row9 = sheet.createRow(8);
            XSSFRow row10 = sheet.createRow(9);
            XSSFRow row11 = sheet.createRow(10);
            XSSFRow row12 = sheet.createRow(11);
            XSSFRow row14 = sheet.createRow(13);
            XSSFRow row15 = sheet.createRow(14);
            XSSFRow row16 = sheet.createRow(15);
            XSSFRow row17 = sheet.createRow(16);
            XSSFRow row18 = sheet.createRow(17);

            // Create a new cell
            XSSFCell cell1 = row1.createCell(0);
            XSSFCell cell2 = row2.createCell(0);
            XSSFCell cell3 = row2.createCell(1);
            XSSFCell cell4 = row3.createCell(0);
            XSSFCell cell5 = row3.createCell(1);
            XSSFCell cell6 = row4.createCell(0);
            XSSFCell cell7 = row4.createCell(1);
            XSSFCell cell8 = row5.createCell(0);
            XSSFCell cell9 = row5.createCell(1);
            XSSFCell cell10 = row7.createCell(0);
            XSSFCell cell11 = row8.createCell(0);
            XSSFCell cell12 = row8.createCell(1);
            XSSFCell cell13 = row9.createCell(0);
            XSSFCell cell14 = row9.createCell(1);
            XSSFCell cell15 = row10.createCell(0);
            XSSFCell cell16 = row10.createCell(1);
            XSSFCell cell17 = row11.createCell(0);
            XSSFCell cell18 = row11.createCell(1);
            XSSFCell cell19 = row12.createCell(0);
            XSSFCell cell20 = row12.createCell(1);
            XSSFCell cell21 = row14.createCell(0);
            XSSFCell cell22 = row14.createCell(1);
            XSSFCell cell23 = row15.createCell(0);
            XSSFCell cell24 = row15.createCell(1);
            XSSFCell cell25 = row16.createCell(0);
            XSSFCell cell26 = row16.createCell(1);
            XSSFCell cell27 = row17.createCell(0);
            XSSFCell cell28 = row17.createCell(1);
            XSSFCell cell29 = row18.createCell(0);
            XSSFCell cell30 = row18.createCell(1);

            DecimalFormat formatter = new DecimalFormat("#,###.##");
            String formattedNumber = formatter.format(yearlySummaryFor2020.get("Associate") + yearlySummaryFor2021.get("Associate"));
            String formattedNumber1 = formatter.format(yearlySummaryFor2020.get("Senior Associate") + yearlySummaryFor2021.get("Senior Associate"));
            String formattedNumber2 = formatter.format(yearlySummaryFor2020.get("Senior Architect") + yearlySummaryFor2021.get("Senior Architect"));
            String formattedNumber3 = formatter.format(yearlySummaryFor2020.get("Associate"));
            String formattedNumber4 = formatter.format(yearlySummaryFor2020.get("Senior Associate"));
            String formattedNumber5 = formatter.format(yearlySummaryFor2020.get("Senior Architect"));
            String formattedNumber6 = formatter.format(yearlySummaryFor2021.get("Associate"));
            String formattedNumber7 = formatter.format(yearlySummaryFor2021.get("Senior Associate"));
            String formattedNumber8 = formatter.format(yearlySummaryFor2021.get("Senior Architect"));
            // Set the value of the cell
            cell1.setCellValue("Total Salary");
            cell2.setCellValue("Designation");
            cell3.setCellValue("Total Salary");
            cell4.setCellValue("Associate");
            cell5.setCellValue("$ " + formattedNumber);
            cell6.setCellValue("Senior Associate");
            cell7.setCellValue("$ "+ formattedNumber1);
            cell8.setCellValue("Senior Architect");
            cell9.setCellValue("$ "+ formattedNumber2);
            cell10.setCellValue("Yearly Summary");
            cell11.setCellValue("Year");
            cell12.setCellValue("2020");
            cell13.setCellValue("Designation");
            cell14.setCellValue("Total Salary");
            cell15.setCellValue("Associate");
            cell16.setCellValue("$ "+ formattedNumber3);
            cell17.setCellValue("Senior Associate");
            cell18.setCellValue("$ "+ formattedNumber4);
            cell19.setCellValue("Senior Architect");
            cell20.setCellValue("$ "+ formattedNumber5);
            cell21.setCellValue("Year");
            cell22.setCellValue("2021");
            cell23.setCellValue("Designation");
            cell24.setCellValue("Total Salary");
            cell25.setCellValue("Associate");
            cell26.setCellValue("$ "+ formattedNumber6);
            cell27.setCellValue("Senior Associate");
            cell28.setCellValue("$ "+ formattedNumber7);
            cell29.setCellValue("Senior Architect");
            cell30.setCellValue("$ "+ formattedNumber8);

            // Write the data to the file
            FileOutputStream fos = new FileOutputStream(new File("Processed output.xlsx"));
            workbook.write(fos);
            fos.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readData() {

        try {
            // Open the Excel file
            FileInputStream fis = new FileInputStream(new File("src/main/resources/Employee Data.xlsx"));
            Workbook workbook = new XSSFWorkbook(fis);


            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            // Create a list to store the data
            List<Employee> employees = new ArrayList<>();
            // Iterate through each rows
            for (Row row : sheet) {
                // skip first row
                if (row.getRowNum() == 0) continue;
                // Get the values of the cells
                Cell associateCell = row.getCell(1);
                Cell salaryCell = row.getCell(2);
                Cell salaryDateCell = row.getCell(3);
                // Create an Employee object
                Employee employee = new Employee();
                employee.setDesignation(associateCell.getStringCellValue());
                employee.setSalary(salaryCell.getNumericCellValue());
                employee.setSalaryDate(salaryDateCell.getDateCellValue());
                // Add the Employee object to the list
                employees.add(employee);
            }
            // Print the data
            for (Employee employee : employees) {
                if (employee.getSalaryDate().toString().endsWith("2020") && !yearlySummaryFor2020.containsKey(employee.getDesignation())) {
                    yearlySummaryFor2020.put(employee.getDesignation(), employee.getSalary());
                } else if (employee.getSalaryDate().toString().endsWith("2020") && yearlySummaryFor2020.containsKey(employee.getDesignation())) {
                    double value = yearlySummaryFor2020.get(employee.getDesignation());
                    value += employee.getSalary();
                    yearlySummaryFor2020.put(employee.getDesignation(), value);
                } else if (employee.getSalaryDate().toString().endsWith("2021") && !yearlySummaryFor2021.containsKey(employee.getDesignation())) {
                    yearlySummaryFor2021.put(employee.getDesignation(), employee.getSalary());
                } else {
                    double value = yearlySummaryFor2021.get(employee.getDesignation());
                    value += employee.getSalary();
                    yearlySummaryFor2021.put(employee.getDesignation(), value);
                }
            }


            System.out.println(yearlySummaryFor2020);
            System.out.println(yearlySummaryFor2021);

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    private String designation;
    private double salary;
    private Date salaryDate;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }
}


//        FileInputStream inputStream = new FileInputStream("src/main/resources/Employee Data.xlsx");
//        Workbook workbook = new XSSFWorkbook(inputStream);
//        Sheet sheet = workbook.getSheet("Employee Data");
//
//        // Iterate through each rows
//        for (Row row : sheet) {
//            // Get the second cell (column 2)
//            Cell cell = row.getCell(1);
//            // Print the cell value
//            System.out.println(cell.getStringCellValue());
//        }
//        inputStream.close();

