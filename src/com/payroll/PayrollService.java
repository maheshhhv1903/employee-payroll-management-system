package com.payroll;

import java.util.*;

public class PayrollService {
    List<Employee> employees;

    public PayrollService() {
        employees = FileHandler.load();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        FileHandler.save(employees);
    }

    public Employee getEmployee(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Employee> getAll() {
        return employees;
    }

    public void updateSalary(int id, double newSalary) {
        Employee emp = getEmployee(id);
        if (emp != null) {
            emp.setBasicSalary(newSalary);
            FileHandler.save(employees);
        }
    }

    public void delete(int id) {
        employees.removeIf(e -> e.getId() == id);
        FileHandler.save(employees);
    }
}
