package com.pluralsight;
import java.io.*;
import java.util.Scanner;
public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file to process: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFileName = scanner.nextLine();

        try {
            FileReader fileReader = new FileReader(inputFileName);
            BufferedReader bufReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFileName);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            bufWriter.write("id|name|gross pay\n");
            bufReader.readLine();
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split("\\|");

                int employeeID = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeID, name, hoursWorked, payRate);

                String line = String.format("%d|%s|%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                bufWriter.write(line);
            }
            bufReader.close();
            bufWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
