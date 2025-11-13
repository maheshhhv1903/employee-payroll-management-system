package com.payroll;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollService service = new PayrollService();

        while (true) {
            System.out.println("\n===== Employee Payroll System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();
                    service.addEmployee(new Employee(id, name, salary));
                    System.out.println("Employee Added!");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    Employee emp = service.getEmployee(sc.nextInt());
                    if (emp != null) {
                        System.out.println("Name: " + emp.getName());
                        System.out.println("Basic: " + emp.getBasicSalary());
                        System.out.println("HRA: " + emp.calculateHRA());
                        System.out.println("DA: " + emp.calculateDA());
                        System.out.println("Gross: " + emp.calculateGross());
                    } else
                        System.out.println("Employee not found!");
                    break;

                case 3:
                    for (Employee e : service.getAll()) {
                        System.out.println(e.getId() + " - " + e.getName() + " - ₹" + e.calculateGross());
                    }
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new salary: ");
                    service.updateSalary(uid, sc.nextDouble());
                    System.out.println("Updated!");
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    service.delete(sc.nextInt());
                    System.out.println("Deleted!");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid!");
            }
        }
    }
}
