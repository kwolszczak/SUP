package pl.kwolszczak.java4_1;

import java.util.List;

public record Movie( String title, Director director, List<Actor>actors, String date, String genre) {
    @Override
    public String toString() {
        String str= "%n%n---- title: %-5s%n date: %s%n genre: %s%n %s%n actors:".formatted( title, date, genre,director);
        for (var actor:actors) {
            str += actor;
        }
        return str;
    }
}
