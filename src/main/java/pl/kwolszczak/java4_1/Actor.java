package pl.kwolszczak.java4_1;

public record Actor(String firstName, String lastName) {
    @Override
    public String toString() {
        return " %s %s,".formatted(firstName, lastName);
    }
}
