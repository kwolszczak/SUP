package pl.kwolszczak.java4_1;

import pl.kwolszczak.java4_1.util.FileJson;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        var library = FileJson.getJsonData("movies2");
        System.out.println(library);
    }
}
