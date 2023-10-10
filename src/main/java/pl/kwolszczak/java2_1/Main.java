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
                case 3 -> {company.addEmployee(getEmployeeFromConsole());
                    System.out.println("ddd");
                }
                case 4 -> quit = true;
                default -> System.out.println("Wrong option");
            }
        } while (!quit);
    }

    private static EmployeeR getEmployeeFromConsole() {
        String name;
        String surname;
        long salary;

        System.out.println("---Add new employee-----");
        System.out.print("Write name: ");
        name = scanner.nextLine();
        System.out.print("Write surname: ");
        surname = scanner.nextLine();
        System.out.print("Write salary: ");
        salary = Long.parseLong(scanner.nextLine());

        return new EmployeeR(name, surname, salary);
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
}
