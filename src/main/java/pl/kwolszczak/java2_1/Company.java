package pl.kwolszczak.java2_1;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void printAllEmployeesSalary() {
        long sumSalary = 0;
        for (Employee employee : employees) {
            sumSalary += employee.salary();
        }
        System.out.println("Sum of salary = "+ sumSalary);
    }

    public void getAllData() {
        System.out.println("Company Summary:\n" + employees);
    }
}
