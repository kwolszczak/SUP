package pl.kwolszczak.java4_1;

import java.util.ArrayList;
import java.util.List;

public class MovieLibrary {
    private List<Movie> movies;

    public MovieLibrary() {
        movies = new ArrayList<>();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MovieLibrary{" +
                "movies=" + movies +
                '}';
    }
}
