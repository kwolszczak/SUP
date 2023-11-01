package pl.kwolszczak.java4_1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kwolszczak.java4_1.MoviesLibrary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    private FileUtils() {
    }

    public static MoviesLibrary getJsonData(String fileName) throws IOException {

        Path workingDir = Paths.get("").toAbsolutePath();
        System.out.println("Working dir: " + workingDir);

        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File(workingDir + "\\src\\main\\resources\\" + fileName + ".json");
        return mapper.readValue(jsonFile, MoviesLibrary.class);
    }
}
