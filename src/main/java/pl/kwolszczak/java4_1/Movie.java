package pl.kwolszczak.java4_1;

import java.util.List;

public record Movie( String title, Director director, List<Actor>actors, String date, String genre) {
}
