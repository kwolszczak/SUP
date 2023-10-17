package pl.kwolszczak.java2_1;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Company company = new Company();

    public static void main(String[] args) {
        boolean quit = false;
        int option;
        do {
            displayMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> company.printAllEmployeesSalary();
                case 2 -> company.getAllData();
                case 3 -> company.addEmployee(getEmployeeFromConsole());
                case 4 -> quit = true;
                default -> System.out.println("Wrong option");
            }
        } while (!quit);
    }

    private static Employee getEmployeeFromConsole() {
        String name;
        String surname;
        long salary;
        boolean validData;

        System.out.println("---Add new employee-----");
        do {
            System.out.print("Write name: ");
            name = scanner.nextLine();
            validData = validateData(name);
        } while (!validData);

        do {
            System.out.print("Write surname: ");
            surname = scanner.nextLine();
            validData = validateData(surname);
        } while (!validData);

        do {
            System.out.print("Write salary: ");
            String salaryStr = scanner.nextLine();
            validData = validateSalary(salaryStr);
            salary = !validData ? -1 : Long.parseLong(salaryStr);
        } while (!validData);

        return new Employee(name, surname, salary);
    }

    private static void displayMenu() {
        String menu = """
                            
                1 – Print sum of all employees salary
                2 – Display all employees data
                3 – Add new employee
                4 – End program
                """;
        System.out.println(menu);
    }

    private static boolean validateData(String data) {
        if (data.trim().isEmpty()) {
            System.out.printf("Validation failed. Name, surname should not be empty%n");
            return false;
        }
        return true;
    }

    private static boolean validateSalary(String data) {
        try {
            long salary = Long.parseLong(data);
            if (salary <= 0) {
                System.out.printf("Validation failed. The salary should be greater than 0%n");
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.printf("Can't parse data. Try to write a number%n");
        }
        return false;
    }
}
