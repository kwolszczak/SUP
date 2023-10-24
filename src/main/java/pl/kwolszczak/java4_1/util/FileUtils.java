package pl.kwolszczak.java4_1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kwolszczak.java4_1.MovieLibrary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    private FileUtils() {
    }

    public static MovieLibrary getJsonData(String fileName) throws IOException {

        Path workingDir = Paths.get("").toAbsolutePath();
        System.out.println("Working dir: " + workingDir);

        File jsonFile = new File(workingDir + "\\src\\main\\resources\\" + fileName + ".json");
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonFile, MovieLibrary.class);
    }
}
