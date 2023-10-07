package pl.kwolszczak.java2_1;

public record EmployeeR(String name, String surname, long salary ) {
    @Override
    public String toString() {
        return ("\n Salary for " + name + " " + surname + " is " + salary + " PLN");
    }
}
