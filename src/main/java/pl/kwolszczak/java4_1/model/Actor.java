package pl.kwolszczak.java4_1.model;

public record Actor(String firstName, String lastName) {
    @Override
    public String toString() {
        return " %s %s,".formatted(firstName, lastName);
    }
}
