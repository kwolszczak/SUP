package pl.kwolszczak.java3_2.FileUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataUtil {

    public static Map<String, String> getProperties(String name) throws IOException {
        var properties = new Properties();
        Path workingDir = Paths.get("").toAbsolutePath();
        try (var reader = new BufferedReader(new FileReader(workingDir +"/src/main/resources/" + name + ".properties"))) {
            properties.load(reader);
            return typeCastConvert(properties);
        }
    }

    private static HashMap<String, String> typeCastConvert(Properties prop) {
        Map<String, String> map = (Map<String, String>) (Map) prop;
        return new HashMap<>(map);
    }
}
