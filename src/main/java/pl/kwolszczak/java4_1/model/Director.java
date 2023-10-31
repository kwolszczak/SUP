package pl.kwolszczak.java4_1.model;

public record Director(String firstName, String lastName) {
    @Override
    public String toString() {
        return "Director: %s %s".formatted(firstName, lastName);
    }
}
