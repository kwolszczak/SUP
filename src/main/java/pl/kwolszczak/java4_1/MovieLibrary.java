package pl.kwolszczak.java4_1;

import pl.kwolszczak.java4_1.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public record MovieLibrary(List<Movie> movies) {

    public MovieLibrary(){
       this(new ArrayList<>());
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder("\n\t\tMovieLibrary:");
        for (var movie : movies) {
            str.append(movie);
        }
        return str.toString();
    }

    public void findRandomMovie() {

        Random random = new Random();
        int randomMovie = random.nextInt(movies.size());
        System.out.print("\n\t\tRandom movie for today:");
        System.out.print(movies.get(randomMovie));
    }

    public void findMovieByActor(String firstName, String lastName) {

        System.out.printf("%n\t\tMovies with actor: %s %s", firstName, lastName);
        movies.stream().filter(movie -> movie.actors()
                        .stream()
                        .anyMatch(actor -> actor.firstName().equals(firstName) && actor.lastName().equals(lastName)))
                .forEach(movie -> System.out.printf("%nmovie title: %s", movie.title()));
    }

    public void findMoviesByDates(int dateFrom, int dateTo) {

        System.out.printf("%n\t\tMovies between dates: %s - %s", dateFrom, dateTo);
        movies.stream().filter(movie -> {
                    int movieDate = Integer.parseInt(movie.date());
                    return movieDate >= dateFrom && movieDate <= dateTo;
                })
                .forEach(movie -> System.out.printf("%nmovie title: %s", movie.title()));
    }
}
