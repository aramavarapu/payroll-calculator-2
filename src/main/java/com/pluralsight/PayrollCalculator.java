package com.pluralsight;
import java.io.*;
public class PayrollCalculator {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine();
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split("\\|");

                int employeeID = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeID, name, hoursWorked, payRate);

                System.out.printf("Id: %d Name: %s Gross Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
            bufReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
