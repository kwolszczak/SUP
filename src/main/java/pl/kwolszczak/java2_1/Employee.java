package pl.kwolszczak.java2_1;

public class Employee {
    private final String name;
    private final String surname;
    private long salary;
    private static final long BASIC_SALARY = 8_200;

    public Employee(String name, String surname) {
        this(name, surname, BASIC_SALARY);
    }

    public Employee(String name, String surname, long salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return ("\n Salary for " + name + " " + surname + " is " + salary + " PLN");
    }
}
