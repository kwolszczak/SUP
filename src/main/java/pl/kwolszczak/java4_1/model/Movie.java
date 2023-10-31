package pl.kwolszczak.java4_1.model;

import java.util.List;

public record Movie(String title, Director director, List<Actor> actors, String date, String genre) {
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("%n%n---- title: %-5s%n date: %s%n genre: %s%n %s%n actors:"
                .formatted(title, date, genre, director));
        for (var actor : actors) {
            str.append(actor);
        }
        return str.toString();
    }
}
