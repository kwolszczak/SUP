package pl.kwolszczak.java4_1;

import pl.kwolszczak.java4_1.util.FileUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

      /*  //var library = FileUtils.getJsonData("myMovies");
        System.out.println(library);

        library.findRandomMovie();
        library.findMovieByActor("Brad", "Pitt");
        library.findMoviesByDates(2008, 2009);*/

        Controller.run();
    }
}
